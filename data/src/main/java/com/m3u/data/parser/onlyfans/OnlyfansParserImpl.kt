package com.m3u.data.parser.onlyfans

import com.m3u.core.architecture.dispatcher.Dispatcher
import com.m3u.core.architecture.dispatcher.M3uDispatchers.IO
import com.m3u.core.architecture.logger.Logger
import com.m3u.core.architecture.logger.Profiles
import com.m3u.core.architecture.logger.install
import com.m3u.data.api.OkhttpClient
import com.m3u.data.parser.ParserUtils
import com.m3u.data.parser.onlyfans.dto.OnlyfansMe
import com.m3u.data.parser.onlyfans.dto.OnlyfansPost
import com.m3u.data.parser.onlyfans.dto.OnlyfansPosts
import com.m3u.data.parser.onlyfans.dto.OnlyfansSubscribes
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext
import kotlinx.datetime.Clock
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Inject

internal class OnlyfansParserImpl @Inject constructor(
    @Dispatcher(IO) private val ioDispatcher: CoroutineDispatcher,
    @OkhttpClient(true) okHttpClient: OkHttpClient,
    delegate: Logger
) : OnlyfansParser {
    private val logger = delegate.install(Profiles.PARSER_ONLYFANS)

    @OptIn(ExperimentalSerializationApi::class)
    private val json: Json
        get() = Json {
            ignoreUnknownKeys = true
            explicitNulls = false
            isLenient = true
        }

    private val utils by lazy {
        ParserUtils(
            json = json,
            okHttpClient = okHttpClient,
            logger = logger,
            ioDispatcher = ioDispatcher
        )
    }

    override suspend fun parse(input: OnlyfansInput): List<OnlyfansPost> = coroutineScope {
        val hash = createHash()
        val appToken = ""
        val ofRev = ""
        val sign = ""
        val me = getMe(input, appToken, ofRev, sign)
        val userId = checkNotNull(me.id)

        val subscribes = getSubscribes(
            input = input,
            userId = userId,
            appToken = appToken,
            ofRev = ofRev,
            hash = hash,
            sign = sign
        )

        val posts = subscribes.list
            .orEmpty()
            .mapNotNull { subscribe ->
                async {
                    supervisorScope {
                        getPosts(subscribe?.id ?: return@supervisorScope null)
                    }
                }
            }
            .awaitAll()
            .filterNotNull()

        return@coroutineScope posts.flatMap { it.list }
    }

    private suspend fun createHash(): String =
        utils.newCallOrThrow("https://cdn2.onlyfans.com/hash/")

    @OptIn(ExperimentalSerializationApi::class)
    private suspend fun getMe(
        input: OnlyfansInput,
        appToken: String,
        ofRev: String,
        sign: String
    ): OnlyfansMe = withContext(ioDispatcher) {
        val time = Clock.System.now().toEpochMilliseconds().toString()
        utils.okHttpClient.newCall(
            Request.Builder()
                .url("https://onlyfans.com/api2/v2/users/me")
                .headers(
                    Headers.headersOf(
                        "User-Agent: ${input.userAgent}",
                        "x-bc: ${input.xbc}",
                        "Cookie: ${input.cookie}",
                        "Accept: application/json, text/plain, */*",
                        "Sec-Fetch-Site: same-origin",
                        "time: $time",
                        "sign: $sign",
                        "x-of-rev: $ofRev",
                        "app-token: $appToken"
                    )
                )
                .method("GET", null)
                .build()
        )
            .execute()
            .body!!
            .byteStream()
            .let { json.decodeFromStream(it) }
    }

    private suspend fun getSubscribes(
        input: OnlyfansInput,
        userId: String,
        appToken: String,
        ofRev: String,
        hash: String,
        sign: String,
    ): OnlyfansSubscribes {
        val (cookie, userAgent, xbc) = input

        return utils
            .newCallOrThrow("https://onlyfans.com/api2/v2/subscriptions/subscribes?offset=0&type=expired&limit=10&format=infinite")
    }

    private suspend fun getPosts(
        userId: String
    ): OnlyfansPosts {
        return utils.newCallOrThrow(
            "https://onlyfans.com/api2/v2/users/$userId/posts?skip_users=all&pinned=1&counters=0&format=infinite"
        )
    }


}
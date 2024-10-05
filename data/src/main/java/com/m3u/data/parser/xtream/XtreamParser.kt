package com.m3u.data.parser.xtream

import com.m3u.core.util.basic.startsWithAny
import io.ktor.http.Url
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.Serializable
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl

interface XtreamParser {
    suspend fun getSeriesInfoOrThrow(
        input: XtreamInput,
        seriesId: Int
    ): XtreamChannelInfo

    fun parse(input: XtreamInput): Flow<XtreamData>

    suspend fun getInfo(input: XtreamInput): XtreamInfo

    suspend fun getXtreamOutput(input: XtreamInput): XtreamOutput

    companion object {
        fun createInfoUrl(
            basicUrl: String,
            username: String,
            password: String,
            vararg params: Pair<String, Any>
        ): String {
            val url = basicUrl.toHttpUrl()
            val builder = HttpUrl.Builder()
                .scheme(url.scheme)
                .host(url.host)
                .port(url.port)
                .addPathSegment("player_api.php")
                .addQueryParameter("username", username)
                .addQueryParameter("password", password)

            return params
                .fold(builder) { prev, (k, v) -> prev.addQueryParameter(k, v.toString()) }
                .build()
                .toString()
        }

        fun createActionUrl(
            basicUrl: String,
            username: String,
            password: String,
            action: Action,
            vararg params: Pair<String, Any>
        ): String = createInfoUrl(basicUrl, username, password, *params) + "&action=$action"

        fun createXmlUrl(
            basicUrl: String,
            username: String,
            password: String,
        ): String {
            val url = basicUrl.toHttpUrl()
            val builder = HttpUrl.Builder()
                .scheme(url.scheme)
                .host(url.host)
                .port(url.port)
                .addPathSegment("xmltv.php")
                .addQueryParameter("username", username)
                .addQueryParameter("password", password)
            return builder.toString()
        }

        const val GET_SERIES_INFO_PARAM_ID = "series_id"
    }

    @JvmInline
    @Serializable
    value class Action(val path: String) {
        override fun toString(): String = path

        companion object {
            val GET_LIVE_STREAMS = Action("get_live_streams")
            val GET_VOD_STREAMS = Action("get_vod_streams")
            val GET_SERIES_STREAMS = Action("get_series")
            val GET_LIVE_CATEGORIES = Action("get_live_categories")
            val GET_VOD_CATEGORIES = Action("get_vod_categories")
            val GET_SERIES_CATEGORIES = Action("get_series_categories")

            val GET_VOD_INFO = Action("get_vod_info")

            // series episode url
            // http://{host}:{port}/series/{username}/{password}/{episode_id}.{episode_container_extension}
            val GET_SERIES_INFO = Action("get_series_info")

            fun of(value: String): Action {
                return when (value) {
                    GET_LIVE_STREAMS.path -> GET_LIVE_STREAMS
                    GET_VOD_STREAMS.path -> GET_VOD_STREAMS
                    GET_SERIES_STREAMS.path -> GET_SERIES_STREAMS
                    GET_LIVE_CATEGORIES.path -> GET_LIVE_CATEGORIES
                    GET_VOD_CATEGORIES.path -> GET_VOD_CATEGORIES
                    GET_SERIES_CATEGORIES.path -> GET_SERIES_CATEGORIES
                    GET_VOD_INFO.path -> GET_VOD_INFO
                    GET_SERIES_INFO.path -> GET_SERIES_INFO
                    else -> throw IllegalArgumentException(value)
                }
            }
        }
    }
}
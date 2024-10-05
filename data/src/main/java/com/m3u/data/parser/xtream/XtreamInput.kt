package com.m3u.data.parser.xtream

import com.m3u.core.util.basic.startsWithAny
import io.ktor.http.Url
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl

// playlist or stream
data class XtreamInput(
    val basicUrl: String, // scheme + host + port
    val username: String,
    val password: String,
    // DataSource.Xtream.TYPE_LIVE, DataSource.Xtream.TYPE_VOD, DataSource.Xtream.TYPE_SERIES
    val type: String? = null // null means all
) {
    companion object {
        // the name is only used in this project so make sure it is unique
        private const val QUERY_TYPE = "xtream_type"
        fun decodeFromPlaylistUrl(url: String): XtreamInput = try {
            val hasScheme = url.startsWithAny("http:", "https:", ignoreCase = true)
            val httpUrl = if (hasScheme) url.toHttpUrl() else "http://$url".toHttpUrl()
            val username = httpUrl.queryParameter("username").orEmpty()
            val password = httpUrl.queryParameter("password").orEmpty()
            XtreamInput(
                basicUrl = "${httpUrl.scheme}://${httpUrl.host}:${httpUrl.port}",
                username = username,
                password = password,
                type = httpUrl.queryParameter(QUERY_TYPE)
            )
        } catch (e: Exception) {
            error(
                """
                Corrupted Data! It explicitly declares itself to be Xtream but is not.
                ${e.stackTraceToString()}
                """.trimIndent()
            )
        }

        fun encodeToPlaylistUrl(
            input: XtreamInput,
            serverProtocol: String = "http",
            port: Int? = null
        ): String = with(input) {
            val url = Url(basicUrl)
            var builder = HttpUrl.Builder()
                .scheme(serverProtocol)
                .host(url.host)
                .port(port ?: url.port)
                .addPathSegment("player_api.php")
                .addQueryParameter("username", username)
                .addQueryParameter("password", password)
            if (type != null) {
                builder = builder.addQueryParameter(QUERY_TYPE, type)
            }
            builder.build().toString()
        }

        fun decodeFromPlaylistUrlOrNull(url: String): XtreamInput? =
            runCatching { decodeFromPlaylistUrl(url) }.getOrNull()
    }
}
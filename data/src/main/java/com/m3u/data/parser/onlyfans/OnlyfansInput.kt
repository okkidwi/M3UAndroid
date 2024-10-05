package com.m3u.data.parser.onlyfans

import io.ktor.http.Url

internal data class OnlyfansInput(
    val cookie: String,
    val userAgent: String,
    val xbc: String
) {
    companion object {
        fun encodeToPlaylistUrl(input: OnlyfansInput): String =
            "onlyfans://${input.cookie}?" +
                    "user-agent=${input.userAgent}&" +
                    "xbc=${input.xbc}"
        fun decodeFromPlaylistUrl(url: String): OnlyfansInput = with(Url(url)) {
            OnlyfansInput(
                cookie = host,
                userAgent = checkNotNull(parameters["user-agent"]),
                xbc = checkNotNull(parameters["xbc"])
            )
        }
        fun decodeFromPlaylistUrlOrNull(url: String): OnlyfansInput? =
            runCatching { decodeFromPlaylistUrl(url) }.getOrNull()
    }
}

package com.m3u.features.feed

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.m3u.core.architecture.configuration.Configuration
import com.m3u.core.architecture.configuration.ExperimentalConfiguration
import com.m3u.core.wrapper.Event
import com.m3u.core.wrapper.handledEvent
import com.m3u.data.database.entity.Live

data class Channel(
    val title: String,
    val lives: List<Live>
)

@OptIn(ExperimentalConfiguration::class)
data class FeedState(
    val url: String = "",
    val channels: List<Channel> = emptyList(),
    val query: String = "",
    val fetching: Boolean = false,
    val scrollUp: Event<Unit> = handledEvent(),
    private val configuration: Configuration
) {
    val strategy: Int by configuration.feedStrategy
    var rowCount: Int by configuration.rowCount
    val useCommonUIMode: Boolean by configuration.useCommonUIMode
    val scrollMode: Boolean by configuration.scrollMode
    val godMode: Boolean by configuration.godMode
    val autoRefresh: Boolean by configuration.autoRefresh
    val noPictureMode: Boolean by configuration.noPictureMode
}

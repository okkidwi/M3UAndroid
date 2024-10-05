package com.m3u.data.parser.onlyfans.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class OnlyfansMedia(
    @SerialName("canView")
    val canView: Boolean,
//    val convertedToVideo: Boolean,
//    val createdAt: Any,
//    val duration: Int,
    @SerialName("files")
    val files: OnlyfansFiles,
//    val hasCustomPreview: Boolean,
    @SerialName("hasError")
    val hasError: Boolean,
    @SerialName("id")
    val id: Int,
    @SerialName("isReady")
    val isReady: Boolean,
    @SerialName("type")
    val type: String,
//    val videoSources: VideoSources
)
package com.m3u.data.parser.onlyfans.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class OnlyfansFiles(
    @SerialName("full")
    val full: FilesInfo,
//    val preview: Preview,
//    val squarePreview: SquarePreview,
//    val thumb: Thumb
) {
    @Serializable
    data class FilesInfo(
    val height: Int,
//    val size: Int,
//    val sources: List<Any>,
        @SerialName("url")
        val url: String,
    val width: Int
    )
}
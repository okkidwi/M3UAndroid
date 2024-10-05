package com.m3u.data.parser.onlyfans.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class OnlyfansPosts(
//    @SerialName("hasMore")
//    val hasMore: Boolean,
//    val headMarker: String,
    @SerialName("list")
    val list: List<OnlyfansPost>,
//    val tailMarker: String
)
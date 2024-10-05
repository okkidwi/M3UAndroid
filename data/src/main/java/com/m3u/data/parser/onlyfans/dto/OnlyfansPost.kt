package com.m3u.data.parser.onlyfans.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class OnlyfansPost(
    val author: OnlyfansAuthor,
//    val canComment: Boolean,
//    val canReport: Boolean,
//    val canToggleFavorite: Boolean,
//    val canViewMedia: Boolean,
//    val commentsCount: Int,
//    val favoritesCount: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("isMediaReady")
    val isMediaReady: Boolean,
    @SerialName("isOpened")
    val isOpened: Boolean,
//    val isPinned: Boolean,
    @SerialName("media")
    val media: List<OnlyfansMedia>,
//    val mediaCount: Int,
//    val postedAt: String,
//    val postedAtPrecise: String,
    @SerialName("responseType")
    val responseType: String, // get, post
    @SerialName("text")
    val text: String,
//    val tipsAmount: String
)
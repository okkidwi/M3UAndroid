package com.m3u.data.parser.onlyfans.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class OnlyfansSubscribes(
    @SerialName("list")
    val list: List<Subscribe?>? = null
) {
    @Serializable
    data class Subscribe(
//        @SerialName("avatar")
//        val avatar: String? = null,
//        @SerialName("avatarThumbs")
//        val avatarThumbs: AvatarThumbs? = null,
//        @SerialName("canAddSubscriber")
//        val canAddSubscriber: Boolean? = null,
//        @SerialName("canCommentStory")
//        val canCommentStory: Boolean? = null,
//        @SerialName("canEarn")
//        val canEarn: Boolean? = null,
//        @SerialName("canLookStory")
//        val canLookStory: Boolean? = null,
//        @SerialName("canPayInternal")
//        val canPayInternal: Boolean? = null,
//        @SerialName("canReceiveChatMessage")
//        val canReceiveChatMessage: Boolean? = null,
//        @SerialName("canReport")
//        val canReport: Boolean? = null,
//        @SerialName("canRestrict")
//        val canRestrict: Boolean? = null,
//        @SerialName("canTrialSend")
//        val canTrialSend: Boolean? = null,
//        @SerialName("currentSubscribePrice")
//        val currentSubscribePrice: Any? = null,
//        @SerialName("displayName")
//        val displayName: String? = null,
//        @SerialName("hasNotViewedStory")
//        val hasNotViewedStory: Boolean? = null,
//        @SerialName("hasScheduledStream")
//        val hasScheduledStream: Boolean? = null,
//        @SerialName("hasStories")
//        val hasStories: Boolean? = null,
//        @SerialName("hasStream")
//        val hasStream: Boolean? = null,
//        @SerialName("header")
//        val header: String? = null,
//        @SerialName("headerSize")
//        val headerSize: HeaderSize? = null,
//        @SerialName("headerThumbs")
//        val headerThumbs: HeaderThumbs? = null,
//        @SerialName("hideChat")
//        val hideChat: Boolean? = null,
        @SerialName("id")
        val id: String? = null,
//        @SerialName("isBlocked")
//        val isBlocked: Boolean? = null,
//        @SerialName("isPaywallRequired")
//        val isPaywallRequired: Boolean? = null,
//        @SerialName("isPerformer")
//        val isPerformer: Boolean? = null,
//        @SerialName("isRealPerformer")
//        val isRealPerformer: Boolean? = null,
//        @SerialName("isRestricted")
//        val isRestricted: Boolean? = null,
//        @SerialName("isVerified")
//        val isVerified: Boolean? = null,
//        @SerialName("lastSeen")
//        val lastSeen: String? = null,
//        @SerialName("listsStates")
//        val listsStates: List<ListsStates?>? = null,
        @SerialName("name")
        val name: String? = null,
//        @SerialName("notice")
//        val notice: String? = null,
//        @SerialName("promotions")
//        val promotions: List<Promotion?>? = null,
//        @SerialName("subscribePrice")
//        val subscribePrice: Double? = null,
//        @SerialName("subscribedBy")
//        val subscribedBy: Any? = null,
//        @SerialName("subscribedByAutoprolong")
//        val subscribedByAutoprolong: Any? = null,
//        @SerialName("subscribedByData")
//        val subscribedByData: SubscribedByData? = null,
//        @SerialName("subscribedByExpire")
//        val subscribedByExpire: Any? = null,
//        @SerialName("subscribedByExpireDate")
//        val subscribedByExpireDate: String? = null,
//        @SerialName("subscribedIsExpiredNow")
//        val subscribedIsExpiredNow: Boolean? = null,
//        @SerialName("subscribedOn")
//        val subscribedOn: Boolean? = null,
//        @SerialName("subscribedOnData")
//        val subscribedOnData: SubscribedOnData? = null,
//        @SerialName("subscribedOnDuration")
//        val subscribedOnDuration: String? = null,
//        @SerialName("subscribedOnExpiredNow")
//        val subscribedOnExpiredNow: Boolean? = null,
//        @SerialName("subscriptionBundles")
//        val subscriptionBundles: List<SubscriptionBundle?>? = null,
//        @SerialName("tipsEnabled")
//        val tipsEnabled: Boolean? = null,
//        @SerialName("tipsMax")
//        val tipsMax: Int? = null,
//        @SerialName("tipsMin")
//        val tipsMin: Int? = null,
//        @SerialName("tipsMinInternal")
//        val tipsMinInternal: Int? = null,
//        @SerialName("tipsTextEnabled")
//        val tipsTextEnabled: Boolean? = null,
        @SerialName("username")
        val username: String? = null,
//        @SerialName("view")
//        val view: String? = null
    )
}
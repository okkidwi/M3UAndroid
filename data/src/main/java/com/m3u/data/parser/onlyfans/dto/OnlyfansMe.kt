package com.m3u.data.parser.onlyfans.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class OnlyfansMe(
//    @SerialName("about")
//    val about: String? = null,
//    @SerialName("advBlock")
//    val advBlock: List<String?>? = null,
//    @SerialName("ageVerificationRequired")
//    val ageVerificationRequired: Boolean? = null,
//    @SerialName("archivedPostsCount")
//    val archivedPostsCount: Int? = null,
//    @SerialName("audiosCount")
//    val audiosCount: Int? = null,
//    @SerialName("avatar")
//    val avatar: String? = null,
//    @SerialName("avatarThumbs")
//    val avatarThumbs: AvatarThumbs? = null,
//    @SerialName("canAddCard")
//    val canAddCard: Boolean? = null,
//    @SerialName("canAlternativeWalletTopUp")
//    val canAlternativeWalletTopUp: Boolean? = null,
//    @SerialName("canChat")
//    val canChat: Boolean? = null,
//    @SerialName("canCommentStory")
//    val canCommentStory: Boolean? = null,
//    @SerialName("canConnectOfAccount")
//    val canConnectOfAccount: Boolean? = null,
//    @SerialName("canCreateLists")
//    val canCreateLists: Boolean? = null,
//    @SerialName("canLookStory")
//    val canLookStory: Boolean? = null,
//    @SerialName("canPayInternal")
//    val canPayInternal: Boolean? = null,
//    @SerialName("canPinPost")
//    val canPinPost: Boolean? = null,
//    @SerialName("canReceiveChatMessage")
//    val canReceiveChatMessage: Boolean? = null,
//    @SerialName("canSendChatToAll")
//    val canSendChatToAll: Boolean? = null,
//    @SerialName("chatMessagesCount")
//    val chatMessagesCount: Int? = null,
//    @SerialName("connectedOfAccounts")
//    val connectedOfAccounts: List<Any?>? = null,
//    @SerialName("countPinnedChat")
//    val countPinnedChat: Int? = null,
//    @SerialName("countPriorityChat")
//    val countPriorityChat: Int? = null,
//    @SerialName("creditBalance")
//    val creditBalance: Double? = null,
//    @SerialName("creditsMax")
//    val creditsMax: Int? = null,
//    @SerialName("creditsMin")
//    val creditsMin: Int? = null,
//    @SerialName("csrf")
//    val csrf: String? = null,
//    @SerialName("email")
//    val email: String? = null,
//    @SerialName("enabledImageEditorForChat")
//    val enabledImageEditorForChat: Boolean? = null,
//    @SerialName("faceIdRegular")
//    val faceIdRegular: FaceIdRegular? = null,
//    @SerialName("favoritedCount")
//    val favoritedCount: Int? = null,
//    @SerialName("favoritesCount")
//    val favoritesCount: Int? = null,
//    @SerialName("hasInternalPayments")
//    val hasInternalPayments: Boolean? = null,
//    @SerialName("hasLabels")
//    val hasLabels: Boolean? = null,
//    @SerialName("hasNewAlerts")
//    val hasNewAlerts: Boolean? = null,
//    @SerialName("hasNewChangedPriceSubscriptions")
//    val hasNewChangedPriceSubscriptions: Boolean? = null,
//    @SerialName("hasNewHints")
//    val hasNewHints: Boolean? = null,
//    @SerialName("hasNewTicketReplies")
//    val hasNewTicketReplies: HasNewTicketReplies? = null,
//    @SerialName("hasNotViewedStory")
//    val hasNotViewedStory: Boolean? = null,
//    @SerialName("hasPinnedPosts")
//    val hasPinnedPosts: Boolean? = null,
//    @SerialName("hasPurchasedPosts")
//    val hasPurchasedPosts: Boolean? = null,
//    @SerialName("hasRecentlyExpired")
//    val hasRecentlyExpired: Boolean? = null,
//    @SerialName("hasScenario")
//    val hasScenario: Boolean? = null,
//    @SerialName("hasSystemNotifications")
//    val hasSystemNotifications: Boolean? = null,
//    @SerialName("hasTags")
//    val hasTags: Boolean? = null,
//    @SerialName("hasWatermarkPhoto")
//    val hasWatermarkPhoto: Boolean? = null,
//    @SerialName("hasWatermarkVideo")
//    val hasWatermarkVideo: Boolean? = null,
//    @SerialName("header")
//    val header: String? = null,
//    @SerialName("headerSize")
//    val headerSize: HeaderSize? = null,
//    @SerialName("headerThumbs")
//    val headerThumbs: HeaderThumbs? = null,
    @SerialName("id")
    val id: String? = null,
//    @SerialName("ip")
//    val ip: String? = null,
//    @SerialName("isAgeVerified")
//    val isAgeVerified: Boolean? = null,
//    @SerialName("isAllowTweets")
//    val isAllowTweets: Boolean? = null,
//    @SerialName("isAuth")
//    val isAuth: Boolean? = null,
//    @SerialName("isCreditsEnabled")
//    val isCreditsEnabled: Boolean? = null,
//    @SerialName("isDeleteInitiated")
//    val isDeleteInitiated: Boolean? = null,
//    @SerialName("isEmailChecked")
//    val isEmailChecked: Boolean? = null,
//    @SerialName("isEmailRequired")
//    val isEmailRequired: Boolean? = null,
//    @SerialName("isLegalApprovedAllowed")
//    val isLegalApprovedAllowed: Boolean? = null,
//    @SerialName("isMakePayment")
//    val isMakePayment: Boolean? = null,
//    @SerialName("isOtpEnabled")
//    val isOtpEnabled: Boolean? = null,
//    @SerialName("isPaymentCardConnected")
//    val isPaymentCardConnected: Boolean? = null,
//    @SerialName("isPaywallPassed")
//    val isPaywallPassed: Boolean? = null,
//    @SerialName("isPerformer")
//    val isPerformer: Boolean? = null,
//    @SerialName("isRealCardConnected")
//    val isRealCardConnected: Boolean? = null,
//    @SerialName("isRealPerformer")
//    val isRealPerformer: Boolean? = null,
//    @SerialName("isReferrerAllowed")
//    val isReferrerAllowed: Boolean? = null,
//    @SerialName("isSpotifyConnected")
//    val isSpotifyConnected: Boolean? = null,
//    @SerialName("isTwitterConnected")
//    val isTwitterConnected: Boolean? = null,
//    @SerialName("isVerified")
//    val isVerified: Boolean? = null,
//    @SerialName("isVisibleOnline")
//    val isVisibleOnline: Boolean? = null,
//    @SerialName("isWalletAutorecharge")
//    val isWalletAutorecharge: Boolean? = null,
//    @SerialName("isWantComments")
//    val isWantComments: Boolean? = null,
//    @SerialName("ivCountry")
//    val ivCountry: String? = null,
//    @SerialName("ivFailReason")
//    val ivFailReason: Any? = null,
//    @SerialName("ivFlow")
//    val ivFlow: String? = null,
//    @SerialName("ivStatus")
//    val ivStatus: String? = null,
//    @SerialName("joinDate")
//    val joinDate: String? = null,
//    @SerialName("lastSeen")
//    val lastSeen: String? = null,
//    @SerialName("location")
//    val location: Any? = null,
//    @SerialName("maxPinnedPostsCount")
//    val maxPinnedPostsCount: Int? = null,
//    @SerialName("mediasCount")
//    val mediasCount: Int? = null,
//    @SerialName("name")
//    val name: String? = null,
//    @SerialName("needIVApprove")
//    val needIVApprove: Boolean? = null,
//    @SerialName("newTagsCount")
//    val newTagsCount: Int? = null,
//    @SerialName("notificationsCount")
//    val notificationsCount: Int? = null,
//    @SerialName("paidFeed")
//    val paidFeed: Boolean? = null,
//    @SerialName("payoutLegalApproveState")
//    val payoutLegalApproveState: String? = null,
//    @SerialName("photosCount")
//    val photosCount: Int? = null,
//    @SerialName("pinnedPostsCount")
//    val pinnedPostsCount: Int? = null,
//    @SerialName("postsCount")
//    val postsCount: Int? = null,
//    @SerialName("privateArchivedPostsCount")
//    val privateArchivedPostsCount: Int? = null,
//    @SerialName("showPostsInFeed")
//    val showPostsInFeed: Boolean? = null,
//    @SerialName("subscribersCount")
//    val subscribersCount: Int? = null,
//    @SerialName("subscribesCount")
//    val subscribesCount: Int? = null,
//    @SerialName("twitterUsername")
//    val twitterUsername: String? = null,
//    @SerialName("upload")
//    val upload: Upload? = null,
//    @SerialName("username")
//    val username: String? = null,
//    @SerialName("videosCount")
//    val videosCount: Int? = null,
//    @SerialName("view")
//    val view: String? = null,
//    @SerialName("walletAutorechargeAmount")
//    val walletAutorechargeAmount: Int? = null,
//    @SerialName("walletAutorechargeMin")
//    val walletAutorechargeMin: Int? = null,
//    @SerialName("walletFirstRebills")
//    val walletFirstRebills: Boolean? = null,
//    @SerialName("watermarkPosition")
//    val watermarkPosition: String? = null,
//    @SerialName("watermarkText")
//    val watermarkText: String? = null,
//    @SerialName("website")
//    val website: String? = null,
//    @SerialName("wishlist")
//    val wishlist: Any? = null,
//    @SerialName("wsAuthToken")
//    val wsAuthToken: String? = null,
//    @SerialName("wsUrl")
//    val wsUrl: String? = null
)
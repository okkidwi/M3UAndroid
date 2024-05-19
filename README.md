# M3UAndroid

M3U is a FREE stream media player on android devices, which made of jetpack compose.
Android 8.0 and above supported.

### Device support

Most Android devices, including smartphones, TVs, and tablets.

### Features

- Playlist Management.
- Streaming media analysis capabilities.
- Xtream support.
- DLNA screencast.
- i18n (Internationalization).

### Screenshots

<div align="center">
<img src=".github/images/phone/deviceframes.png"/>
<img src=".github/images/tv/playlist.png"/>
</div>
<div style="display:flex;">
<img src=".github/images/tv/foryou.png" width="45%" style="flex:1" />
<img src=".github/images/tv/player.png" width="45%" style="flex:1" />
</div>

### i18n

- [English](i18n/src/main/res/values)
- [Simplified Chinese](i18n/src/main/res/values-zh-rCN)
- [Spanish](i18n/src/main/res/values-es-rES)
- [Romanian](i18n/src/main/res/values-ro-rRO)
- [Brazilian Portuguese](i18n/src/main/res/values-pt-rBR)
- [German](i18n/src/main/res/values-de-rDE)

### Android Development

M3U is an app that attempts to use the latest libraries and tools. As a summary:

- Entirely written in Kotlin.
- UI completely written in Jetpack Compose.
- Material3 design system.
- Uses Kotlin Coroutines throughout.
- Uses many of the Architecture Components, including: Room, Lifecycle, Navigation.
- Uses Hilt for dependency injection.
- Uses Lint Checks for code scanning.
- Uses KSP & KotlinPoet for Code Generating.
- FFmepg-kit & ExoPlayer.

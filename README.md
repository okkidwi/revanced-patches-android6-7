# YouTube ReVanced for Android 6.0-7.1
An unofficial ReVanced Extended for YouTube 17.34.36.  
Based on inotia00's ReVanced Extended [v2.160.1](https://github.com/inotia00/revanced-patches/releases/tag/v2.160.1)

## About
The last YouTube app available on Android 6 & 7 is v17.34.36.

On the other hand, latest ReVanced and RVX patches don't support YouTube 17.34.36, but RVX v2.160.1 is the last version in which most of features work properly.

So I forked ReVanced Extended patches v2.160.1 and fixed some patches and backported some features for Android 6.0-7.1 users.

Because I released this on the GitHub repository, which means that you can use ReVanced Manager to build YT ReVanced for Android 6.0-7.1!  
(but it requires other Android 8.0+ device)

<img src="https://user-images.githubusercontent.com/90122968/226170799-f265a265-6ddf-4143-b27c-7dcec45f26bf.png" width="240">

This is not able in the original RVX patches, as ReVanced Manager cannot select versions of patches/integrations.

## How to build
See [documantation](https://github.com/kitadai31/revanced-patches/wiki/How-to-build).

Other informations are also avalable on [wiki](https://github.com/kitadai31/revanced-patches-android6-7/wiki).

## 🧩 Patches List

### [📦 `com.google.android.youtube`](https://play.google.com/store/apps/details?id=com.google.android.youtube)
<details>

| 💊 Patch | 📜 Description | 🏹 Target Version |
|:--------:|:--------------:|:-----------------:|
| `client-spoof` | Spoofs the YouTube client to prevent playback issues. | 17.34.36 |
| `custom-branding-icon-afn-blue` | Changes the YouTube launcher icon (Afn / Blue). | 17.34.36 |
| `custom-branding-icon-afn-red` | Changes the YouTube launcher icon (Afn / Red). | 17.34.36 |
| `custom-branding-icon-revancify` | Changes the YouTube launcher icon (Revancify). | 17.34.36 |
| `custom-branding-name` | Changes the YouTube launcher name to your choice (defaults to ReVanced Extended). | 17.34.36 |
| `custom-seekbar-color` | Change seekbar color in dark mode. | 17.34.36 |
| `custom-video-speed` | Adds more video speed options. | 17.34.36 |
| `default-video-quality` | Adds ability to set default video quality settings. | 17.34.36 |
| `default-video-speed` | Adds ability to set default video speed settings. | 17.34.36 |
| `disable-haptic-feedback` | Disable haptic feedback when swiping. | 17.34.36 |
| `enable-external-browser` | Use an external browser to open the url. | 17.34.36 |
| `enable-minimized-playback` | Enables minimized and background playback. | 17.34.36 |
| `enable-new-layout` | Spoof the YouTube client version to 18.05.40 to use the new layout. | 17.34.36 |
| `enable-old-quality-layout` | Enables the original quality flyout menu. | 17.34.36 |
| `enable-open-links-directly` | Bypass URL redirects (youtube.com/redirect) when opening links in video descriptions. | 17.34.36 |
| `enable-seekbar-tapping` | Enables tap-to-seek on the seekbar of the video player. | 17.34.36 |
| `enable-tablet-miniplayer` | Enables the tablet mini player layout. | 17.34.36 |
| `enable-wide-searchbar` | Replaces the search icon with a wide search bar. This will hide the YouTube logo when active. | 17.34.36 |
| `force-enable-new-layout` | Force spoof the YouTube client version to 18.05.40. | 17.34.36 |
| `force-premium-heading` | Forces premium heading on the home screen. | 17.34.36 |
| `force-vp9-codec` | Forces the VP9 codec for videos. | 17.34.36 |
| `header-switch` | Add switch to change header. | 17.34.36 |
| `hide-auto-captions` | Hide captions from being automatically enabled. | 17.34.36 |
| `hide-auto-player-popup-panels` | Hide automatic popup panels (playlist or live chat) on video player. | 17.34.36 |
| `hide-autoplay-button` | Hides the autoplay button in the video player. | 17.34.36 |
| `hide-button-container` | Adds the options to hide action buttons under a video. | 17.34.36 |
| `hide-cast-button` | Hides the cast button in the video player. | 17.34.36 |
| `hide-channel-watermark` | Hides creator's watermarks on videos. | 17.34.36 |
| `hide-comment-component` | Adds options to hide comment component under a video. | 17.34.36 |
| `hide-create-button` | Hides the create button in the navigation bar. | 17.34.36 |
| `hide-crowdfunding-box` | Hides the crowdfunding box between the player and video description. | 17.34.36 |
| `hide-email-address` | Hides the email address in the account switcher. | 17.34.36 |
| `hide-endscreen-cards` | Hides the suggested video cards at the end of a video in fullscreen. | 17.34.36 |
| `hide-endscreen-overlay` | Hide endscreen overlay on swipe controls. | 17.34.36 |
| `hide-filmstrip-overlay` | Hide flimstrip overlay on swipe controls. | 17.34.36 |
| `hide-firsttime-background-notification` | Disable notification when you launch background play for the first time. | 17.34.36 |
| `hide-flyout-panel` | Adds options to hide player settings flyout panel. | 17.34.36 |
| `hide-fullscreen-panels` | Hides video description and comments panel in fullscreen view. | 17.34.36 |
| `hide-general-ads` | Hooks the method which parses the bytes into a ComponentContext to filter components. | 17.34.36 |
| `hide-info-cards` | Hides info-cards in videos. | 17.34.36 |
| `hide-live-chat-button` | Hides the live chat button in the video player. | 17.34.36 |
| `hide-mix-playlists` | Removes mix playlists from home feed and video player. | 17.34.36 |
| `hide-next-prev-button` | Hides the next prev button in the player controller. | 17.34.36 |
| `hide-player-captions-button` | Hides the captions button in the video player. | 17.34.36 |
| `hide-player-overlay-filter` | Remove the dark filter layer from the player's background. | 17.34.36 |
| `hide-shorts-button` | Hides the shorts button in the navigation bar. | 17.34.36 |
| `hide-shorts-component` | Hides other Shorts components. | 17.34.36 |
| `hide-shorts-pivot-bar` | Hides the bottom navigation tabs when playing shorts. | 17.34.36 |
| `hide-snackbar` | Hides the snackbar action popup. | 17.34.36 |
| `hide-startup-shorts-player` | Disables playing YouTube Shorts when launching YouTube. | 17.34.36 |
| `hide-stories` | Hides YouTube Stories shelf on the feed. | 17.34.36 |
| `hide-suggested-actions` | Hide the suggested actions bar inside the player. | 17.34.36 |
| `hide-time-and-seekbar` | Hides progress bar and time counter on videos. | 17.34.36 |
| `hide-tooltip-content` | Hides the tooltip box that appears on first install. | 17.34.36 |
| `hide-video-ads` | Removes ads in the video player. | 17.34.36 |
| `layout-switch` | Tricks the dpi to use some tablet/phone layouts. | 17.34.36 |
| `materialyou` | Enables MaterialYou theme for Android 12+ | 17.34.36 |
| `microg-support` | Allows YouTube ReVanced to run without root and under a different package name with Vanced MicroG. | 17.34.36 |
| `optimize-resource` | Removes duplicate resources and adds missing translation files from YouTube. | 17.34.36 |
| `overlay-buttons` | Add overlay buttons for ReVanced Extended. | 17.34.36 |
| `patch-options` | Create an options.toml file. | 17.34.36 |
| `protobuf-spoof` | Spoofs the protobuf to prevent playback issues. | 17.34.36 |
| `remove-player-button-background` | Removes the background from the video player buttons. | 17.34.36 |
| `return-youtube-dislike` | Shows the dislike count of videos using the Return YouTube Dislike API. | 17.34.36 |
| `settings` | Applies mandatory patches to implement ReVanced settings into the application. | 17.34.36 |
| `sponsorblock` | Integrates SponsorBlock which allows skipping video segments such as sponsored content. | 17.34.36 |
| `swipe-controls` | Adds volume and brightness swipe controls. | 17.34.36 |
| `switch-create-notification` | Switching the create button and notification button. | 17.34.36 |
| `theme` | Applies a custom theme (default: amoled). | 17.34.36 |
| `translations` | Add Crowdin Translations. | 17.34.36 |
</details>

## Todo
Reconstruction based on latest verison RVX patches (for well maintainability🔧, updated translation🌍 and new features✨)

## Successor wanted!
Embarrassingly, I'm not very familiar with reverse engineering and even programming. (but I can read a little smali. :D )  
So I can not create new patches by myself. All my modifing are just copy and paste.

If a better successor ReVanced Patches for 6.0-7.1 is emerged, I will promptly delete the repository and retire ReVanced community!

## Thanks
[@inotia00](https://github.com/inotia00) - Original ReVanced Extended developer  
[@revanced](https://github.com/revanced) - Official ReVanced team

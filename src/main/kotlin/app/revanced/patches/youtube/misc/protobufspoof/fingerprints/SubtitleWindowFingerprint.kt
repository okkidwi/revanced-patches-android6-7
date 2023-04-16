package app.revanced.patches.youtube.misc.protobufspoof.fingerprints

import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint

object SubtitleWindowFingerprint : MethodFingerprint(
    parameters = listOf("I", "I", "I", "Z", "Z"),
    customFingerprint = { it.definingClass == "Lcom/google/android/libraries/youtube/player/subtitles/model/SubtitleWindowSettings;"
                && it.name == "<init>"
    }
)
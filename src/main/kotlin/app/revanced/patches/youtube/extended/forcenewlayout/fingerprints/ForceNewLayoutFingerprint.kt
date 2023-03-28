package app.revanced.patches.youtube.extended.forcenewlayout.fingerprints

import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint

object ForceNewLayoutFingerprint : MethodFingerprint(
    returnType = "L",
    parameters = listOf("L"),
    customFingerprint = { it.definingClass == "Lapp/revanced/integrations/patches/extended/VersionOverridePatch;"}
)
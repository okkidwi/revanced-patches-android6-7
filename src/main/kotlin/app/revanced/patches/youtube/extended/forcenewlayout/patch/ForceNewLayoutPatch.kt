package app.revanced.patches.youtube.extended.forcenewlayout.patch

import app.revanced.patcher.annotation.Description
import app.revanced.patcher.annotation.Name
import app.revanced.patcher.annotation.Version
import app.revanced.patcher.data.BytecodeContext
import app.revanced.patcher.extensions.addInstructions
import app.revanced.patcher.patch.BytecodePatch
import app.revanced.patcher.patch.PatchResult
import app.revanced.patcher.patch.PatchResultSuccess
import app.revanced.patcher.patch.annotations.DependsOn
import app.revanced.patcher.patch.annotations.Patch
import app.revanced.patches.youtube.extended.forcenewlayout.fingerprints.ForceNewLayoutFingerprint
import app.revanced.patches.youtube.extended.oldlayout.resource.patch.OldLayoutPatch
import app.revanced.shared.annotation.YouTubeCompatibility
import app.revanced.shared.extensions.toErrorResult

@Patch(false)
@Name("force-enable-new-layout")
@Description("Force spoof the YouTube client version to 18.05.40.")
@DependsOn([OldLayoutPatch::class])
@YouTubeCompatibility
@Version("0.0.1")
class ForceNewLayoutPatch : BytecodePatch(
    listOf(
        ForceNewLayoutFingerprint
    )
) {
    override fun execute(context: BytecodeContext): PatchResult {

        ForceNewLayoutFingerprint.result?.let {
            with (it.mutableMethod) {
                addInstructions(
                    0, """
                        const-string v1, "18.05.40"
                        return-object v1
                    """
                )
            }
        } ?: return ForceNewLayoutFingerprint.toErrorResult()

        return PatchResultSuccess()
    }
}
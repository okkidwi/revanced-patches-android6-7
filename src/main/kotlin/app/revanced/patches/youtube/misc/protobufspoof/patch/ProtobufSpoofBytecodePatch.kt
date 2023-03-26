package app.revanced.patches.youtube.misc.protobufspoof.patch

import app.revanced.patcher.annotation.Name
import app.revanced.patcher.annotation.Version
import app.revanced.patcher.data.BytecodeContext
import app.revanced.patcher.data.toMethodWalker
import app.revanced.patcher.extensions.addInstructions
import app.revanced.patcher.patch.BytecodePatch
import app.revanced.patcher.patch.PatchResult
import app.revanced.patcher.patch.PatchResultSuccess
import app.revanced.patcher.util.proxy.mutableTypes.MutableMethod
import app.revanced.patches.youtube.misc.protobufpoof.fingerprints.ProtobufParameterBuilderFingerprint
import app.revanced.shared.annotation.YouTubeCompatibility
import app.revanced.shared.extensions.toErrorResult
import app.revanced.shared.util.integrations.Constants.MISC_PATH

/*
* from 2.166.4
* https://github.com/inotia00/revanced-patches/commit/9c3da568e285b2aa1a336aef6e6fdbef5d6d87c1
*/
@Name("protobuf-spoof-bytecode-patch")
@YouTubeCompatibility
@Version("0.0.1")
class ProtobufSpoofBytecodePatch : BytecodePatch(
    listOf(ProtobufParameterBuilderFingerprint)
) {
    override fun execute(context: BytecodeContext): PatchResult {

        ProtobufParameterBuilderFingerprint.result?.let {
            with (context
                .toMethodWalker(it.method)
                .nextMethod(it.scanResult.patternScanResult!!.startIndex, true)
                .getMethod() as MutableMethod
            ) {
                val protobufParam = 3

                addInstructions(
                    0,
                    """
                        invoke-static {p$protobufParam}, $MISC_PATH/ProtobufSpoofPatch;->getProtobufOverride(Ljava/lang/String;)Ljava/lang/String;
                        move-result-object p$protobufParam
                    """
                )
            }
        } ?: return ProtobufParameterBuilderFingerprint.toErrorResult()

        return PatchResultSuccess()
    }
}
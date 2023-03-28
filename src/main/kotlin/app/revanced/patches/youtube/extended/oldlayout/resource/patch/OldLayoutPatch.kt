package app.revanced.patches.youtube.extended.oldlayout.resource.patch

import app.revanced.patcher.annotation.Description
import app.revanced.patcher.annotation.Name
import app.revanced.patcher.annotation.Version
import app.revanced.patcher.data.ResourceContext
import app.revanced.patcher.patch.annotations.DependsOn
import app.revanced.patcher.patch.annotations.Patch
import app.revanced.patcher.patch.PatchResult
import app.revanced.patcher.patch.PatchResultSuccess
import app.revanced.patcher.patch.ResourcePatch
import app.revanced.patches.youtube.extended.oldlayout.bytecode.patch.OldLayoutBytecodePatch
import app.revanced.patches.youtube.misc.settings.resource.patch.SettingsPatch
import app.revanced.shared.annotation.YouTubeCompatibility
import app.revanced.shared.util.resources.ResourceHelper

@Patch
@Name("enable-new-layout") //renamed from "enable-old-layout"
@Description("Spoof the YouTube client version to 18.05.40 to use the new layout.")
@DependsOn(
    [
        OldLayoutBytecodePatch::class,
        SettingsPatch::class
    ]
)
@YouTubeCompatibility
@Version("0.0.1")
class OldLayoutPatch : ResourcePatch {
    override fun execute(context: ResourceContext): PatchResult {

        /*
         add settings
         */
        ResourceHelper.addSettings2(
            context,
            "PREFERENCE_CATEGORY: REVANCED_EXTENDED_SETTINGS",
            "PREFERENCE: EXTENDED_SETTINGS",
            "SETTINGS: EXPERIMENTAL_FLAGS",
            "SETTINGS: ENABLE_OLD_LAYOUT"
        )

        ResourceHelper.patchSuccess(
            context,
            "enable-new-layout"
        )

        return PatchResultSuccess()
    }
}
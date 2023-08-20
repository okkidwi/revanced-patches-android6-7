package app.revanced.patches.youtube.misc.sponsorblock.resource.patch

import app.revanced.patcher.annotation.Description
import app.revanced.patcher.annotation.Name
import app.revanced.patcher.data.ResourceContext
import app.revanced.patcher.patch.annotations.DependsOn
import app.revanced.patcher.patch.annotations.Patch
import app.revanced.patcher.patch.PatchResult
import app.revanced.patcher.patch.PatchResultSuccess
import app.revanced.patcher.patch.ResourcePatch
import app.revanced.patches.youtube.misc.settings.resource.patch.SettingsPatch
import app.revanced.patches.youtube.misc.sponsorblock.bytecode.patch.SponsorBlockBytecodePatch
import app.revanced.patches.youtube.misc.sponsorblock.bytecode.patch.SponsorBlockSecondaryBytecodePatch
import app.revanced.shared.annotation.YouTubeCompatibility
import app.revanced.shared.util.resources.ResourceHelper
import app.revanced.shared.util.resources.ResourceUtils
import app.revanced.shared.util.resources.ResourceUtils.copyResources
import app.revanced.shared.util.resources.ResourceUtils.copyXmlNode

@Patch
@Name("sponsorblock")
@Description("Integrates SponsorBlock which allows skipping video segments such as sponsored content.")
@DependsOn(
    [
        SettingsPatch::class,
        SponsorBlockBytecodePatch::class,
        SponsorBlockSecondaryBytecodePatch::class
    ]
)
@YouTubeCompatibility
class SponsorBlockResourcePatch : ResourcePatch {

    override fun execute(context: ResourceContext): PatchResult {
        /*
         merge SponsorBlock drawables to main drawables
         */

        arrayOf(
            ResourceUtils.ResourceGroup(
                "layout",
                "inline_sponsor_overlay.xml",
                "new_segment.xml",
                "skip_sponsor_button.xml"
            ),
            ResourceUtils.ResourceGroup(
                // required resource for back button, because when the base APK is used, this resource will not exist
                "drawable",
                "ic_sb_adjust.xml",
                "ic_sb_compare.xml",
                "ic_sb_edit.xml",
                "ic_sb_logo.xml",
                "ic_sb_publish.xml",
                "ic_sb_voting.xml"
            )
        ).forEach { resourceGroup ->
            context.copyResources("youtube/sponsorblock", resourceGroup)
        }

        /*
        merge xml nodes from the host to their real xml files
         */

        // collect all host resources
        val hostingXmlResources = mapOf("layout" to arrayOf("youtube_controls_layout"))

        // copy nodes from host resources to their real xml files
        hostingXmlResources.forEach { (path, resources) ->
            resources.forEach { resource ->
                val hostingResourceStream = this.javaClass.classLoader.getResourceAsStream("youtube/sponsorblock/host/$path/$resource.xml")!!

                val targetXmlEditor = context.xmlEditor["res/$path/$resource.xml"]
                "RelativeLayout".copyXmlNode(
                    context.xmlEditor[hostingResourceStream],
                    targetXmlEditor
                ).also {
                    val children = targetXmlEditor.file.getElementsByTagName("RelativeLayout").item(0).childNodes

                    // Replace the startOf with the voting button view so that the button does not overlap
                    for (i in 1 until children.length) {
                        val view = children.item(i)

                        // Replace the attribute for a specific node only
                        if (!(view.hasAttributes() && view.attributes.getNamedItem("android:id").nodeValue.endsWith("player_video_heading"))) continue

                        // voting button id from the voting button view from the youtube_controls_layout.xml host file
                        val SBButtonId = "@+id/sponsorblock_button"

                        view.attributes.getNamedItem("android:layout_toStartOf").nodeValue = SBButtonId

                        break
                    }
                }.close() // close afterwards
            }
        }

        /*
         add ReVanced Settings
         */
        ResourceHelper.addReVancedSettings(
            context,
            "PREFERENCE: SPONSOR_BLOCK"
        )

        ResourceHelper.patchSuccess(
            context,
            "sponsorblock"
        )

        return PatchResultSuccess()
    }
}
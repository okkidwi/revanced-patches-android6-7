package app.revanced.patches.youtube.misc.protobufspoof.fingerprints

import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint
import org.jf.dexlib2.Opcode

object BadResponseFingerprint : MethodFingerprint(
    opcodes = listOf(
        Opcode.CONST_16
    ),
    strings = listOf("Response code: ")
)
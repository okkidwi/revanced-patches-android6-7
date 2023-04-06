package app.revanced.shared.util

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.nio.channels.Channels

/**
 * Provides alternative file copy functions that does not use java.nio.file.
 *
 * This is needed for ReVanced Manager running on Android 6.0-7.1
 * because before Android 8.0 does not support java.nio.file.
 *
 * To use, catch NoClassDefFoundError or catch NoSuchMethodError caused by java.io.File#toPath()
 */
object FileCopyCompat {
    /**
     * Alternative implementation of
     * java.nio.file.Files#copy(Path source, Path target, CopyOption... options)
     *
     * If the target file already exists, it will be replaced.
     */
    fun copy(source: File, target: File) {
        val inFile = FileInputStream(source)
        val outFile = FileOutputStream(target)
        
        val inChannel = inFile.channel
        val outChannel = outFile.channel
        outChannel.transferFrom(inChannel, 0, inChannel.size())

        outFile.close()
        inFile.close()
    }

    /**
     * Alternative implementation of
     * java.nio.file.Files#copy(InputStream in, Path target, CopyOption... options)
     *
     * If the target file already exists, it will be replaced.
     */
    fun copy(inStream: InputStream, target: File) {
        val fos = FileOutputStream(target)

        fos.channel.transferFrom(Channels.newChannel(inStream), 0, 524288)
        // Support up to 524288 Bytes = 512KB. Probably enough. If it is not enough, increase it.

        fos.close()
    }
}
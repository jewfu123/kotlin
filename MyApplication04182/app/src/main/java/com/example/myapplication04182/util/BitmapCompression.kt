package com.mutkuensert.bitmapcompression

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.annotation.FloatRange
import androidx.annotation.IntRange
import androidx.core.graphics.scale
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream

private const val TAG = "BitmapCompression"

/**
 * @property file The file to be reduced in size. It will be overwritten with the size reduction processes.
 * @property sizeLimitBytes Max size the file can be after compression.
 * @property compressPriority Start reducing file size by scaling down or compressing.
 * @property lowerWidthLimit Stop scaling down before dropping down below this value.
 * @property lowerHeightLimit Stop scaling down before dropping down below this value.
 * @property compressionQualityDownTo Lower value means lower quality and smaller size.
 * @property scaleDownFactor Scale factor to divide width and height of image in every loop.
 */

internal val Bitmap.aspectRatio: Float get() = width.toFloat() / height.toFloat()

internal fun Bitmap.getHeightByWidth(width: Int): Int {
    return (width / aspectRatio).toInt()
}

internal fun Bitmap.getWidthByHeight(height: Int): Int {
    return (height * aspectRatio).toInt()
}

internal fun Bitmap.createOutputStream(): ByteArrayOutputStream {
    val byteArrayOutputStream = ByteArrayOutputStream()
    compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)

    return byteArrayOutputStream
}

internal fun File.overwriteByStream(outputStream: ByteArrayOutputStream) {
    delete()
    createNewFile()
    outputStream().use {
        outputStream.writeTo(it)
    }
}

internal fun File.overwriteByBitmap(bitmap: Bitmap) {
    val byteArrayOutputStream = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)
    overwriteByStream(byteArrayOutputStream)
    byteArrayOutputStream.close()
}

class SizeException(override val message: String) : RuntimeException(message)

class BitmapCompression(
    private val file: File,
    private val file2: File,
    var sizeLimitBytes: Int,
    var compressPriority: CompressPriority = CompressPriority.StartByCompress,
    var lowerWidthLimit: Int? = null,
    var lowerHeightLimit: Int? = null,
    @IntRange(from = 1, to = 90)
    var compressionQualityDownTo: Int = 50,
    @FloatRange(from = 0.1, to = 0.9)
    var scaleDownFactor: Float = 0.8f
) {
    private var bitmap = BitmapFactory.decodeFile(file.absolutePath)

    companion object {

        /**
         * @param file The file will be overwritten with the size reduction processes.
         */
        fun compress(
            file: File,
            @IntRange(from = 0, to = 100)
            quality: Int,
        ) {
            val newBitmap = compress(BitmapFactory.decodeFile(file.absolutePath), quality)

            val byteArrayOutputStream = newBitmap.createOutputStream()

            file.overwriteByStream(byteArrayOutputStream)
            byteArrayOutputStream.close()
        }

        fun compress(
            bitmap: Bitmap,
            @IntRange(from = 0, to = 100)
            quality: Int
        ): Bitmap {
            val byteArrayOutputStream = ByteArrayOutputStream()

            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, byteArrayOutputStream)

            val newBitmap = BitmapFactory.decodeByteArray(
                byteArrayOutputStream.toByteArray(),
                0,
                byteArrayOutputStream.size()
            )

            byteArrayOutputStream.close()

            return newBitmap
        }

        /**
         * Scale down preserving the aspect ratio.
         */
        fun scaleDownToWidth(
            file: File,
            width: Int
        ) {
            var bitmap = BitmapFactory.decodeFile(file.absolutePath)

            bitmap = scaleDownToWidth(bitmap, width)

            val outputStream = bitmap.createOutputStream()
            file.overwriteByStream(outputStream)
            outputStream.close()
        }

        /**
         * Scale down preserving the aspect ratio.
         */
        fun scaleDownToWidth(
            bitmap: Bitmap,
            width: Int
        ): Bitmap {
            if (width >= bitmap.width) {
                Log.i(TAG, "Argument $width is already bigger than or equals to ${bitmap.width}")
                return bitmap
            }

            return bitmap.scale(
                width = width,
                height = bitmap.getHeightByWidth(width)
            )
        }

        /**
         * Scale down preserving the aspect ratio.
         */
        fun scaleDownToHeight(
            file: File,
            height: Int
        ) {
            var bitmap = BitmapFactory.decodeFile(file.absolutePath)

            bitmap = scaleDownToHeight(bitmap, height)

            val outputStream = bitmap.createOutputStream()
            file.overwriteByStream(outputStream)
            outputStream.close()
        }

        /**
         * Scale down preserving the aspect ratio.
         */
        fun scaleDownToHeight(
            bitmap: Bitmap,
            height: Int
        ): Bitmap {
            if (height >= bitmap.height) {
                Log.i(TAG, "Argument $height is already bigger than or equals to ${bitmap.height}")
                return bitmap
            }

            return bitmap.scale(
                width = bitmap.getWidthByHeight(height),
                height = height
            )
        }
    }

    /**
     * @throws SizeException If compression and scaling down processes can't reduce the file
     * size under the limit within current configuration.
     */
    fun compressAndScaleDown() {
        if (file.length() <= sizeLimitBytes) {
            Log.i(TAG, "File ${file.name} is already under the size limit.")
            return
        }

        compressAndScaleDownByPriority()

        if (file.length() > sizeLimitBytes) {
            throw SizeException(
                "File is too big for specified limits. " +
                        "You can try with lower resolution limits, increasing scaleDownFactor " +
                        "or change compress priority to CompressPriority.STARTBYCOMPRESS"
            )
        }
    }

    private fun compress() {
        var factor = 95
        val byteArrayOutputStream = ByteArrayOutputStream()

        do {
            byteArrayOutputStream.reset()

            bitmap.compress(Bitmap.CompressFormat.JPEG, factor, byteArrayOutputStream)
            factor -= 5

            if (factor <= compressionQualityDownTo) break
        } while (byteArrayOutputStream.size() > sizeLimitBytes)

        //file2.overwriteByStream(byteArrayOutputStream)
        file.overwriteByStream(byteArrayOutputStream)
        byteArrayOutputStream.close()
    }

    private fun scaleDown() {
        val byteArrayOutputStream = ByteArrayOutputStream()

        //val fileOutputStream = FileOutputStream(file)

        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)

        while ((byteArrayOutputStream.size() > sizeLimitBytes)) {
            val scaledDownWidth = bitmap.width * scaleDownFactor
            val scaledDownHeight = bitmap.height * scaleDownFactor

            if ((lowerWidthLimit != null && scaledDownWidth < lowerWidthLimit!!)
                || (lowerHeightLimit != null && scaledDownHeight < lowerHeightLimit!!)
            ) {
                break
            }

            bitmap = bitmap.scale(
                width = scaledDownWidth.toInt(),
                height = scaledDownHeight.toInt()
            )

            byteArrayOutputStream.reset()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)
        }
        val buffer: ByteArray = byteArrayOutputStream.toByteArray()
        //file2.writeBytes(buffer)
        //fileOutputStream.close()

        file.overwriteByStream(byteArrayOutputStream)
        byteArrayOutputStream.close()
    }

    enum class CompressPriority {
        StartByScaleDown, StartByCompress
    }

    private fun compressAndScaleDownByPriority() {
        if (compressPriority == CompressPriority.StartByScaleDown) {
            scaleDown()
            compress()
        } else {
            compress()
            scaleDown()
        }
    }
}
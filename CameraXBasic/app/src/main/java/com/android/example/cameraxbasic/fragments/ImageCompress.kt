package com.android.example.cameraxbasic.fragments

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import kotlin.math.sqrt


object ImageCompress {
    @Throws(IOException::class)
    fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "JPEG_" + timeStamp + "_"
        val storageDir =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            imageFileName,  /* prefix */
            ".jpg",  /* suffix */
            storageDir /* directory */
        )
    }

    fun scal(fileUri: Uri): File {
        val path = fileUri.path
        var outputFile = File(path)
        val fileSize = outputFile.length()
        val fileMaxSize = (200 * 1024).toLong()
        if (fileSize >= fileMaxSize) {
            val options = BitmapFactory.Options()
            options.inJustDecodeBounds = true
            BitmapFactory.decodeFile(path, options)
            val height = options.outHeight
            val width = options.outWidth
            val scale = sqrt((fileSize.toFloat() / fileMaxSize).toDouble())
            options.outHeight = (height / scale).toInt()
            options.outWidth = (width / scale).toInt()
            options.inSampleSize = (scale + 0.5).toInt()
            options.inJustDecodeBounds = false
            val bitmap = BitmapFactory.decodeFile(path, options)
            outputFile = File(PhotoUtil.createImageFile().getPath())
            var fos: FileOutputStream? = null
            try {
                fos = FileOutputStream(outputFile)
                bitmap.compress(Bitmap.CompressFormat.JPEG, 50, fos)
                fos.close()
            } catch (e: IOException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
            Log.d("", "sss ok " + outputFile.length())
            if (!bitmap.isRecycled) {
                bitmap.recycle()
            } else {
                val tempFile = outputFile
                outputFile = File(PhotoUtil.createImageFile().getPath())
                PhotoUtil.copyFileUsingFileChannels(tempFile, outputFile)
            }
        }
        return outputFile
    }
}
package com.android.example.cameraxbasic.fragments

import android.net.Uri
import android.os.Environment
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.nio.channels.FileChannel
import java.text.SimpleDateFormat
import java.util.Date


object PhotoUtil {
    /**
     * 一切都操作uri
     * @return
     */
    fun createImageFile(): Uri {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = "JPEG_" + timeStamp + "_"
        val storageDir = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_PICTURES
        )
        var image: File? = null
        try {
            image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",  /* suffix */
                storageDir /* directory */
            )
        } catch (e: IOException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }

        // Save a file: path for use with ACTION_VIEW intents
        return Uri.fromFile(image)
    }

    fun copyFileUsingFileChannels(source: File?, dest: File?) {
        var inputChannel: FileChannel? = null
        var outputChannel: FileChannel? = null
        try {
            try {
                inputChannel = FileInputStream(source).channel
                outputChannel = FileOutputStream(dest).channel
                outputChannel.transferFrom(inputChannel, 0, inputChannel.size())
            } catch (e: IOException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
        } finally {
            try {
                inputChannel!!.close()
                outputChannel!!.close()
            } catch (e: IOException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
        }
    }
}
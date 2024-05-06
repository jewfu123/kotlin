package com.example.myapplication04182

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.scale
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mutkuensert.bitmapcompression.BitmapCompression
import com.mutkuensert.bitmapcompression.SizeException
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val pathname: String = "/storage/emulated/0/Pictures/witch-8259351.jpg"
        val NameOut: String = "/storage/emulated/0/Pictures/witch-8259351_ys.jpg"
        val NameOut2: String = "/storage/emulated/0/Pictures/witch-8259351_sc.jpg"
        val file = File(pathname)
        val fileOut = File(NameOut2)
        val bitmap: Bitmap = BitmapFactory.decodeFile(file.absolutePath)
        val sdcard = Environment.getExternalStorageDirectory()
        val fileX = File(sdcard, "/Pictures/witch-8259351.jpg")
        val fileX2 = File(sdcard, "/Pictures/witch-8259351_X.jpg")
        //ImageCompress(bitmap, fileOut)
        //ImageScale(bitmap, fileOut)
        testBitmap(fileX,fileX2)

        val fdelete: File = fileX2//File(uri.getPath())
        if (fdelete.exists()) {
            if (fdelete.delete()) {
                Log.v("file Deleted :" , fdelete.path)
            } else {
                Log.v("file not Deleted :" , fdelete.path)
            }
        }
    }

    fun ImageCompress(bitmap: Bitmap, file:File) {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val fileOutputStream = FileOutputStream(file)
        bitmap.compress(Bitmap.CompressFormat.JPEG, 30, byteArrayOutputStream)
        Log.v("bitmap compressed size:", byteArrayOutputStream.size().toString())
        val buffer: ByteArray = byteArrayOutputStream.toByteArray()
        file.writeBytes(buffer)
        fileOutputStream.close()
        byteArrayOutputStream.close()
        Log.v("result", "compressed completed!")
    }

    fun ImageScale(bitmap: Bitmap, file:File) {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val fileOutputStream = FileOutputStream(file)
        var bitmap2 = bitmap.scale(240,320)
        Log.v("bitmap scaled size:", byteArrayOutputStream.size().toString())
        bitmap2.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)

        val buffer: ByteArray = byteArrayOutputStream.toByteArray()
        file.writeBytes(buffer)
        fileOutputStream.close()
        byteArrayOutputStream.close()
        Log.v("result", "scaled completed!")
    }

    fun testBitmap(tempFile: File,tmpFile2: File) {
        val compression = BitmapCompression(
            file = tempFile,
            file2 = tmpFile2,
            sizeLimitBytes = 1048576,
            compressPriority = BitmapCompression.CompressPriority.StartByScaleDown,
            lowerWidthLimit = 1024,
            compressionQualityDownTo = 85
        )

        try {
            compression.compressAndScaleDown()
        } catch (exception: SizeException) {
            compression.lowerWidthLimit = 768
            compression.compressAndScaleDown()
        }
    }
}
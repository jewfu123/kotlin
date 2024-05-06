
#How to compress photo in Android with Kotlin

##Gradle

```Kotlin
dependencies {
implementation 'id.zelory:compressor:3.0.0'
}
```

###Compress Image File

```
```Kotlin
val compressedImageFile = Compressor.compress(context, actualImageFile)
```

###Compress Image File to specific destination

```Kotlin
val compressedImageFile = Compressor.compress(context, actualImageFile) {
default()
destination(myFile)
}
```


###Using default constraint and custom partial of it

```Kotlin
val compressedImageFile = Compressor.compress(context, actualImageFile) {
default(width = 640, format = Bitmap.CompressFormat.WEBP)
}
```

###Full custom constraint

```Kotlin
val compressedImageFile = Compressor.compress(context, actualImageFile) {
resolution(1280, 720)
quality(80)
format(Bitmap.CompressFormat.WEBP)
size(2_097_152) // 2 MB
}

val compressedImageFile = Compressor.compress(context, actualImageFile) {
    resolution(1280, 720)
    quality(80)
    format(Bitmap.CompressFormat.WEBP)
    size(2_097_152) // 2 MB
    }

val compressedImageFile = Compressor.compress(context, actualImageFile) {
    resolution(1280, 720)
    quality(80)
    format(Bitmap.CompressFormat.WEBP)
    size(2_097_152) // 2 MB
    }

val compressedImageFile = Compressor.compress(context, actualImageFile) {
    resolution(1280, 720)
    quality(80)
    format(Bitmap.CompressFormat.WEBP)
    size(2_097_152) // 2 MB
}
```

https://github.com/zetbaitsu/Compressor


























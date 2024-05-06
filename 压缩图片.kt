//压缩图片
private fun comImag(): Bitmap? {
	// chooseImagResult为上面选择图片选择后返回的图片数组
    var localMedia = chooseImagResult[0]
    var file = File(localMedia.realPath)

    var imgUri = file.toUri()
    //将图片转换为bitmap
    var bitmapImg = BitmapFactory.decodeStream(contentResolver.openInputStream(imgUri))

    val baos = ByteArrayOutputStream()
    bitmapImg.compress(Bitmap.CompressFormat.JPEG, 100, baos)
    if (baos.toByteArray().size / 1024 > 1024) { //判断如果图片大于1M,进行压缩避免在生成图片（BitmapFactory.decodeStream）时溢出
      baos.reset() //重置baos即清空baos
      bitmapImg.compress(Bitmap.CompressFormat.JPEG, 50, baos) //这里压缩50%，把压缩后的数据存放到baos中
    }
    var isBm: ByteArrayInputStream? = ByteArrayInputStream(baos.toByteArray())
    val newOpts = BitmapFactory.Options()
    //开始读入图片，此时把options.inJustDecodeBounds 设回true了
    newOpts.inJustDecodeBounds = true
    var bitmap = BitmapFactory.decodeStream(isBm, null, newOpts)
    newOpts.inJustDecodeBounds = false
    val w = newOpts.outWidth
    val h = newOpts.outHeight

    val hh = 800f //这里设置高度为800f
    val ww = 480f //这里设置宽度为480f
    //缩放比。由于是固定比例缩放，只用高或者宽其中一个数据进行计算即可
    var be = 1 //be=1表示不缩放
    if (w > h && w > ww) { //如果宽度大的话根据宽度固定大小缩放
      be = (newOpts.outWidth / ww).toInt()
    } else if (w < h && h > hh) { //如果高度高的话根据宽度固定大小缩放
      be = (newOpts.outHeight / hh).toInt()
    }
    if (be <= 0) be = 1
    newOpts.inSampleSize = be //设置缩放比例
    //重新读入图片，注意此时已经把options.inJustDecodeBounds 设回false了
    isBm = ByteArrayInputStream(baos.toByteArray())
    bitmap = BitmapFactory.decodeStream(isBm, null, newOpts)
    return compressImage(bitmap!!) //压缩好比例大小后再进行质量压缩
}


//图片上传
 try {
    //上传图片
    OkHttpClient client = new OkHttpClient().newBuilder().build();
    RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), bitmapToByte(path));
    Request request = new Request.Builder().url(mUploadUrl).put(requestBody).build();
    Response response = client.newCall(request).execute();
    if (response.isSuccessful()) {
        return "success";
    } else {
        return null;
    }
} catch (Exception e) {
    Log.e(TAG, "uploadPic: " + e.getLocalizedMessage());
    return null;
}












































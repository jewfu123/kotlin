# kotlin
some sample codes from Android Kotlin

#api website:
https://opentdb.com/api_config.php

#pictures website:
https://unsplash.com/


Report this ad
14 Answers
Sorted by:

Highest score (default)
198

Below is the code for your purpose :

public static boolean externalMemoryAvailable() {
        return android.os.Environment.getExternalStorageState().equals(
                android.os.Environment.MEDIA_MOUNTED);
    }

    public static String getAvailableInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSizeLong();
        long availableBlocks = stat.getAvailableBlocksLong();
        return formatSize(availableBlocks * blockSize);
    }

    public static String getTotalInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSizeLong();
        long totalBlocks = stat.getBlockCountLong();
        return formatSize(totalBlocks * blockSize);
    }

    public static String getAvailableExternalMemorySize() {
        if (externalMemoryAvailable()) {
            File path = Environment.getExternalStorageDirectory();
            StatFs stat = new StatFs(path.getPath());
            long blockSize = stat.getBlockSizeLong();
            long availableBlocks = stat.getAvailableBlocksLong();
            return formatSize(availableBlocks * blockSize);
        } else {
            return ERROR;
        }
    }

    public static String getTotalExternalMemorySize() {
        if (externalMemoryAvailable()) {
            File path = Environment.getExternalStorageDirectory();
            StatFs stat = new StatFs(path.getPath());
            long blockSize = stat.getBlockSizeLong();
            long totalBlocks = stat.getBlockCountLong();
            return formatSize(totalBlocks * blockSize);
        } else {
            return ERROR;
        }
    }

    public static String formatSize(long size) {
        String suffix = null;

        if (size >= 1024) {
            suffix = "KB";
            size /= 1024;
            if (size >= 1024) {
                suffix = "MB";
                size /= 1024;
            }
        }

        StringBuilder resultBuffer = new StringBuilder(Long.toString(size));

        int commaOffset = resultBuffer.length() - 3;
        while (commaOffset > 0) {
            resultBuffer.insert(commaOffset, ',');
            commaOffset -= 3;
        }

        if (suffix != null) resultBuffer.append(suffix);
        return resultBuffer.toString();
    }
    

ĝgggggggg
'''Kotlin
import android.os.Environment
import java.io.File

private const val ERROR = "Error"

fun externalMemoryAvailable(): Boolean {
    return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
}

fun getAvailableInternalMemorySize(): String {
    val path = Environment.getDataDirectory()
    val stat = StatFs(path.path)
    val blockSize = stat.blockSizeLong
    val availableBlocks = stat.availableBlocksLong
    return formatSize(availableBlocks * blockSize)
}

fun getTotalInternalMemorySize(): String {
    val path = Environment.getDataDirectory()
    val stat = StatFs(path.path)
    val blockSize = stat.blockSizeLong
    val totalBlocks = stat.blockCountLong
    return formatSize(totalBlocks * blockSize)
}

fun getAvailableExternalMemorySize(): String {
    return if (externalMemoryAvailable()) {
        val path = Environment.getExternalStorageDirectory()
        val stat = StatFs(path.path)
        val blockSize = stat.blockSizeLong
        val availableBlocks = stat.availableBlocksLong
        formatSize(availableBlocks * blockSize)
    } else {
        ERROR
    }
}

fun getTotalExternalMemorySize(): String {
    return if (externalMemoryAvailable()) {
        val path = Environment.getExternalStorageDirectory()
        val stat = StatFs(path.path)
        val blockSize = stat.blockSizeLong
        val totalBlocks = stat.blockCountLong
        formatSize(totalBlocks * blockSize)
    } else {
        ERROR
    }
}

fun formatSize(size: Long): String {
    var suffix: String? = null

    if (size >= 1024) {
        suffix = "KB"
        var sizeTemp = size / 1024
        if (sizeTemp >= 1024) {
            suffix = "MB"
            sizeTemp /= 1024
        }
        return "$sizeTemp$suffix"
    }

    return "$size"
}

'''

## About Android URI,file path :

从Android10开始，引入了分区存储，不让直接通过File的方式操作SD卡路径了。必须通过MediaStore，也就是说，让MediaStore给你指定存放位置，暴露抽象的Uri，让你用，真实路径隐藏。

（2）通过MediaStore的方式

MediaStore其实就是一个数据库，里面存的是媒体信息（名字、描述、路径等），访问MediaStore通过ContentResolver。MediaStore存的只是媒体信息，保存媒体本身到本地还是需要我们自己完成的，只不过MediaStore告诉了我们位置，而且有写入的方式。

```Android
public Uri createImageUri(Context context) {
    ContentValues values = new ContentValues();
    // 需要指定文件信息时，非必须
    values.put(MediaStore.Images.Media.DESCRIPTION, "This is an image");
    values.put(MediaStore.Images.Media.DISPLAY_NAME, "Image.png");
    values.put(MediaStore.Images.Media.MIME_TYPE, "image/png");
    values.put(MediaStore.Images.Media.TITLE, "Image.png");
    //values.put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/test");

    return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
}

```
先在MediaStore的Images中创建一条表示图片的记录，返回表示这个图片的Uri。

more information below:

https://blog.csdn.net/zhongyili_sohu/article/details/109091437

https://blog.csdn.net/weixin_35538624/article/details/117557206


Android中URI

一、Uri简介
URI（Universal Resource Identifier）通用资源标识符

Uri和URI的区别：Uri是Android开发的，扩展了Java中的一些功能来特定的适用于Android开发，所以，在开发时，只使用Android提供的 Uri 即可。

Uri代表要操作的数据，Android里面的每种可用的资源，包括图像、视频、联系人等都可以用Uri来表示。

二、Uri组成
Uri的组成一般有三部分组成：
访问资源的命名机制、存放资源的主机名、资源自身的名称
例如解释：

https://blog.csdn.net/qq_12345/article/details/7777777
1
例如，所有联系人的Uri：

content://contacts/people
1
某张图片的Uri：

content://media/external/images/media/4
1
以下述Uri为例

content://com.android.providers.media.documents/document/image:1598915
1
uri.getScheme()：content
指的是Uri协议
uri.getAuthority()：com.android.providers.media.documents
文件提供器标识
uri.getPath()：document/image:1598915
获取文件提供器之后的路径
uri.getPathSegments()：[document, image:158975]
获取文件提供器之后的路径，以File.separator切分成数组（自动解码）
uri.withAppendedPath(uri, segment)：content://com.android.providers.media.documents/image:1598915/segment
在uri最后添加一个子路径
三、Uri格式
不同类别Uri的格式：

比如
第一行的图片表示，系统自带的文件管理器中的图片的Uri的格式；
第二行的图片表示，第三方集成到系统管理器中的图片的Uri的格式。

序号  类别  Uri
1   图片  content://com.android.providers.media.documents/document/image%3A1598915
-   图片  content://media/external/images/media/1508729
2   视频  content://com.android.providers.media.documents/document/video%3A1594850
-   视频  content://media/external/video/media/1594849
3   音频  content://com.android.providers.media.documents/document/audio%3A920365
4   下载  content://com.android.providers.downloads.documents/document/raw%3A%2Fstorage%2Femulated%2F0%2FDownload%2Ftest.txt
5   手机  content://com.android.externalstorage.documents/document/primary%3Atest.txt
6   文件管理器   file:///storage/emulated/0/test.txt
7   文件管理器   content://com.jinghong.fileguanlijh.FILE_PROVIDER/storage_root/Android/log.txt
8   ES文件管理器 content://com.estrongs.files/storage/emulated/0/test.txt
9   文件管理器   content://com.tencent.mtt.fileprovider/QQBrowser/test.txt
上面的%3A指的是冒号

四、Uri分类
系统的内容提供器
第三方的内容提供器
旧式file类型的uri
系统的内容提供器创建的文件都是来自DocumentsProvider
使用DocumentsContract.isDocumentUri(context, uri)可以判断该uri是否来自系统内容提供器。

五、内容提供器（重点）
  文件存储、SP存储以及数据库存储这些持久化技术所保存的数据都只能在当前应用程序中访问，虽然文件和SP存储中提供了MODE_WORLD_READABLE和MODE_WORLD_WRITEABLE这两种操作模式，用于供给其它的应用程序访问当前应用的数据，但是这两种模式在Android 4.2中已被废弃，因为Android官方不推荐使用这种方式来实现程序跨程序数据共享的功能，而是应使用内容提供器技术。

内容提供器的用法一般有两种：

使用现有的内容提供器来读取和操作相应程序中的数据
创建自己的内容提供器给我们程序的数据提供外部访问接口
5.1 ContentResolver
  对于每一个应用程序来说，如果想要访问内容提供器中共享的数据，就一定要借助ContentResolver类，可以通过Context中的getContentResolver()方法获取到该类的实例。ContentResolver中提供了一系列的方法用于对数据进行CRUD操作。
  不同于SQLiteDatabase，ContentResolver中的增删改查方法都是不接收表名参数的，而是使用一个Uri参数代替，这个参数被称为内容Uri。
   内容Uri给内容提供器中的数据建立了唯一标识符，它主要由两部分组成：authority和path。

authority用于对不同的应用程序做区分，一般为了避免冲突，都会采用程序包名的方式来进行命名。比如某个程序的包名是com.example.app，那么该程序对应的authority就可以命名为com.example.app.provider。
path用于对同一应用程序中不同的表做区分，通常都会添加到authority的后面。比如某个程序的数据库里存在两张表：table1和table2，这时就可以将path分别命名为/table1和/table2。
将authority和path进行组合，内容URI就变成了 com.example.app.provider/table1 和 com.example.app.provider/table2，
在字符串的头部加上协议声明，因此内容URI最标准的格式写法即为(以第一个为例）：

content://com.example.app.provider/table1
1
除此之外，我们还可以在这个内容Uri的后面加上一个id：

content://com.example.app.provider/table1/1
1
表示调用方期望访问的是com.example.app这个应用的table1表中id为1的数据。
内容Uri的格式主要就只有以上两种： 以路径结尾表示期望访问该表中所有的数据；以id结尾表示期望访问该表中拥有相应id的数据。我们可以使用通配符的方式来分别匹配这两种格式的内容Uri，规则如下：

*：表示匹配任意长度的任意字符
#：表示匹配任意长度的数字
所以一个能够匹配任意表的内容URI可以写成：
content://com.example.app.provider/*
1
一个能够匹配table1表中任意一行数据的内容Uri格式可以写成：

content://com.example.app.provider/table/#
1
内容URI可以非常清楚地表达出我们想要访问哪个程序中哪张表里的数据。

  在得到了内容URI字符串之后，我们还需要将它解析成Uri对象才可以作为参数传入，解析的方法很简单，只需调用Uri.parse()方法就可以将内容Uri字符串解析成Uri对象了：

Uri uri = Uri.parse("content://com.example.app.provider/table1")
文章知识点与官方知识档案匹配，可进一步学习相关知识
Java技能树首页概览146241 人正在系统学习中

URI详解：
https://blog.csdn.net/JMW1407/article/details/114840191









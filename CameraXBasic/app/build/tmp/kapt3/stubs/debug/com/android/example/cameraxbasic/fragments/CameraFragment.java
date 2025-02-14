package com.android.example.cameraxbasic.fragments;

import java.lang.System;

/**
 * Main fragment for this app. Implements all camera operations including:
 * - Viewfinder
 * - Photo taking
 * - Image analysis
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00be\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 T2\u00020\u0001:\u0002TUB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0010H\u0002J\b\u0010,\u001a\u00020-H\u0002J \u0010.\u001a\u00020-2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u0002022\u0006\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u000209H\u0002J\u0010\u0010;\u001a\u00020-2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020-2\u0006\u0010?\u001a\u00020@H\u0016J$\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\b\u0010I\u001a\u00020-H\u0016J\b\u0010J\u001a\u00020-H\u0016J\u001a\u0010K\u001a\u00020-2\u0006\u0010L\u001a\u00020B2\b\u0010G\u001a\u0004\u0018\u00010HH\u0017J\u0010\u0010M\u001a\u00020-2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010N\u001a\u00020-2\u0006\u0010O\u001a\u000207H\u0002J\u0011\u0010P\u001a\u00020-H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010QJ\b\u0010R\u001a\u00020-H\u0002J\b\u0010S\u001a\u00020-H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020(X\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006V"}, d2 = {"Lcom/android/example/cameraxbasic/fragments/CameraFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_fragmentCameraBinding", "Lcom/android/example/cameraxbasic/databinding/FragmentCameraBinding;", "broadcastManager", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "camera", "Landroidx/camera/core/Camera;", "cameraExecutor", "Ljava/util/concurrent/ExecutorService;", "cameraProvider", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "cameraUiContainerBinding", "Lcom/android/example/cameraxbasic/databinding/CameraUiContainerBinding;", "displayId", "", "displayListener", "Landroid/hardware/display/DisplayManager$DisplayListener;", "displayManager", "Landroid/hardware/display/DisplayManager;", "getDisplayManager", "()Landroid/hardware/display/DisplayManager;", "displayManager$delegate", "Lkotlin/Lazy;", "fragmentCameraBinding", "getFragmentCameraBinding", "()Lcom/android/example/cameraxbasic/databinding/FragmentCameraBinding;", "imageAnalyzer", "Landroidx/camera/core/ImageAnalysis;", "imageCapture", "Landroidx/camera/core/ImageCapture;", "lensFacing", "mediaStoreUtils", "Lcom/android/example/cameraxbasic/utils/MediaStoreUtils;", "preview", "Landroidx/camera/core/Preview;", "volumeDownReceiver", "Landroid/content/BroadcastReceiver;", "windowManager", "Landroidx/window/WindowManager;", "aspectRatio", "width", "height", "bindCameraUseCases", "", "compress", "outputFile", "Ljava/io/File;", "bitmap", "Landroid/graphics/Bitmap;", "targetSize", "", "compressImage", "filePath", "", "hasBackCamera", "", "hasFrontCamera", "observeCameraState", "cameraInfo", "Landroidx/camera/core/CameraInfo;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onResume", "onViewCreated", "view", "removeCameraStateObservers", "setGalleryThumbnail", "filename", "setUpCamera", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCameraSwitchButton", "updateCameraUi", "Companion", "LuminosityAnalyzer", "app_debug"})
public final class CameraFragment extends androidx.fragment.app.Fragment {
    private com.android.example.cameraxbasic.databinding.FragmentCameraBinding _fragmentCameraBinding;
    private com.android.example.cameraxbasic.databinding.CameraUiContainerBinding cameraUiContainerBinding;
    private androidx.localbroadcastmanager.content.LocalBroadcastManager broadcastManager;
    private com.android.example.cameraxbasic.utils.MediaStoreUtils mediaStoreUtils;
    private int displayId = -1;
    private int lensFacing = androidx.camera.core.CameraSelector.LENS_FACING_BACK;
    private androidx.camera.core.Preview preview;
    private androidx.camera.core.ImageCapture imageCapture;
    private androidx.camera.core.ImageAnalysis imageAnalyzer;
    private androidx.camera.core.Camera camera;
    private androidx.camera.lifecycle.ProcessCameraProvider cameraProvider;
    private androidx.window.WindowManager windowManager;
    private final kotlin.Lazy displayManager$delegate = null;
    
    /**
     * Blocking camera operations are performed using this executor
     */
    private java.util.concurrent.ExecutorService cameraExecutor;
    
    /**
     * Volume down button receiver used to trigger shutter
     */
    private final android.content.BroadcastReceiver volumeDownReceiver = null;
    
    /**
     * We need a display listener for orientation changes that do not trigger a configuration
     * change, for example if we choose to override config change in manifest or for 180-degree
     * orientation changes.
     */
    private final android.hardware.display.DisplayManager.DisplayListener displayListener = null;
    @org.jetbrains.annotations.NotNull
    public static final com.android.example.cameraxbasic.fragments.CameraFragment.Companion Companion = null;
    private static final java.lang.String TAG = "CameraXBasic";
    private static final java.lang.String FILENAME = "yyyy-MM-dd-HH-mm-ss-SSS";
    private static final java.lang.String PHOTO_TYPE = "image/jpeg";
    private static final double RATIO_4_3_VALUE = 1.3333333333333333;
    private static final double RATIO_16_9_VALUE = 1.7777777777777777;
    
    public CameraFragment() {
        super();
    }
    
    private final com.android.example.cameraxbasic.databinding.FragmentCameraBinding getFragmentCameraBinding() {
        return null;
    }
    
    private final android.hardware.display.DisplayManager getDisplayManager() {
        return null;
    }
    
    @java.lang.Override
    public void onResume() {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setGalleryThumbnail(java.lang.String filename) {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Inflate camera controls and update the UI manually upon config changes to avoid removing
     * and re-adding the view finder from the view hierarchy; this provides a seamless rotation
     * transition on devices that support it.
     *
     * NOTE: The flag is supported starting in Android 8 but there still is a small flash on the
     * screen for devices that run Android 9 or below.
     */
    @java.lang.Override
    public void onConfigurationChanged(@org.jetbrains.annotations.NotNull
    android.content.res.Configuration newConfig) {
    }
    
    /**
     * Initialize CameraX, and prepare to bind the camera use cases
     */
    private final java.lang.Object setUpCamera(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    /**
     * Declare and bind preview, capture and analysis use cases
     */
    private final void bindCameraUseCases() {
    }
    
    private final void removeCameraStateObservers(androidx.camera.core.CameraInfo cameraInfo) {
    }
    
    private final void observeCameraState(androidx.camera.core.CameraInfo cameraInfo) {
    }
    
    /**
     * [androidx.camera.core.ImageAnalysis.Builder] requires enum value of
     * [androidx.camera.core.AspectRatio]. Currently it has values of 4:3 & 16:9.
     *
     * Detecting the most suitable ratio for dimensions provided in @params by counting absolute
     * of preview ratio to one of the provided values.
     *
     * @param width - preview width
     * @param height - preview height
     * @return suitable aspect ratio
     */
    private final int aspectRatio(int width, int height) {
        return 0;
    }
    
    /**
     * Method used to re-draw the camera UI controls, called every time configuration changes.
     */
    private final void updateCameraUi() {
    }
    
    private final android.graphics.Bitmap compressImage(java.lang.String filePath) {
        return null;
    }
    
    private final void compress(java.io.File outputFile, android.graphics.Bitmap bitmap, long targetSize) {
    }
    
    /**
     * Enabled or disabled a button to switch cameras depending on the available cameras
     */
    private final void updateCameraSwitchButton() {
    }
    
    /**
     * Returns true if the device has an available back camera. False otherwise
     */
    private final boolean hasBackCamera() {
        return false;
    }
    
    /**
     * Returns true if the device has an available front camera. False otherwise
     */
    private final boolean hasFrontCamera() {
        return false;
    }
    
    /**
     * Our custom image analysis class.
     *
     * <p>All we need to do is override the function `analyze` with our desired operations. Here,
     * we compute the average luminosity of the image by looking at the Y plane of the YUV frame.
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B2\u0012+\b\u0002\u0010\u0002\u001a%\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003j\u0004\u0018\u0001`\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\f\u0010\u001a\u001a\u00020\u001b*\u00020\u001cH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R/\u0010\u0015\u001a#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00030\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/android/example/cameraxbasic/fragments/CameraFragment$LuminosityAnalyzer;", "Landroidx/camera/core/ImageAnalysis$Analyzer;", "listener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "luma", "", "Lcom/android/example/cameraxbasic/fragments/LumaListener;", "(Lkotlin/jvm/functions/Function1;)V", "frameRateWindow", "", "frameTimestamps", "Ljava/util/ArrayDeque;", "", "<set-?>", "framesPerSecond", "getFramesPerSecond", "()D", "lastAnalyzedTimestamp", "listeners", "Ljava/util/ArrayList;", "analyze", "image", "Landroidx/camera/core/ImageProxy;", "toByteArray", "", "Ljava/nio/ByteBuffer;", "app_debug"})
    static final class LuminosityAnalyzer implements androidx.camera.core.ImageAnalysis.Analyzer {
        private final int frameRateWindow = 8;
        private final java.util.ArrayDeque<java.lang.Long> frameTimestamps = null;
        private final java.util.ArrayList<kotlin.jvm.functions.Function1<java.lang.Double, kotlin.Unit>> listeners = null;
        private long lastAnalyzedTimestamp = 0L;
        private double framesPerSecond = -1.0;
        
        public LuminosityAnalyzer() {
            super();
        }
        
        public LuminosityAnalyzer(@org.jetbrains.annotations.Nullable
        kotlin.jvm.functions.Function1<? super java.lang.Double, kotlin.Unit> listener) {
            super();
        }
        
        public final double getFramesPerSecond() {
            return 0.0;
        }
        
        /**
         * Helper extension function used to extract a byte array from an image plane buffer
         */
        private final byte[] toByteArray(java.nio.ByteBuffer $this$toByteArray) {
            return null;
        }
        
        /**
         * Analyzes an image to produce a result.
         *
         * <p>The caller is responsible for ensuring this analysis method can be executed quickly
         * enough to prevent stalls in the image acquisition pipeline. Otherwise, newly available
         * images will not be acquired and analyzed.
         *
         * <p>The image passed to this method becomes invalid after this method returns. The caller
         * should not store external references to this image, as these references will become
         * invalid.
         *
         * @param image image being analyzed VERY IMPORTANT: Analyzer method implementation must
         * call image.close() on received images when finished using them. Otherwise, new images
         * may not be received or the camera may stall, depending on back pressure setting.
         */
        @java.lang.Override
        public void analyze(@org.jetbrains.annotations.NotNull
        androidx.camera.core.ImageProxy image) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/android/example/cameraxbasic/fragments/CameraFragment$Companion;", "", "()V", "FILENAME", "", "PHOTO_TYPE", "RATIO_16_9_VALUE", "", "RATIO_4_3_VALUE", "TAG", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}
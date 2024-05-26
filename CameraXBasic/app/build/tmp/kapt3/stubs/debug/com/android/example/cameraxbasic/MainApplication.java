package com.android.example.cameraxbasic;

import java.lang.System;

/**
 * Set CameraX logging level to Log.ERROR to avoid excessive logcat messages.
 * Refer to https://developer.android.com/reference/androidx/camera/core/CameraXConfig.Builder#setMinimumLoggingLevel(int)
 * for details.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/android/example/cameraxbasic/MainApplication;", "Landroid/app/Application;", "Landroidx/camera/core/CameraXConfig$Provider;", "()V", "getCameraXConfig", "Landroidx/camera/core/CameraXConfig;", "app_debug"})
public final class MainApplication extends android.app.Application implements androidx.camera.core.CameraXConfig.Provider {
    
    public MainApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public androidx.camera.core.CameraXConfig getCameraXConfig() {
        return null;
    }
}
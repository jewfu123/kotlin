package com.android.example.cameraxbasic.fragments;

import java.lang.System;

/**
 * Fragment used to present the user with a gallery of photos taken
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001!B\u0007\b\u0000\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\u001a\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/android/example/cameraxbasic/fragments/GalleryFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_fragmentGalleryBinding", "Lcom/android/example/cameraxbasic/databinding/FragmentGalleryBinding;", "args", "Lcom/android/example/cameraxbasic/fragments/GalleryFragmentArgs;", "getArgs", "()Lcom/android/example/cameraxbasic/fragments/GalleryFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "fragmentGalleryBinding", "getFragmentGalleryBinding", "()Lcom/android/example/cameraxbasic/databinding/FragmentGalleryBinding;", "hasMediaItems", "Lkotlinx/coroutines/CompletableDeferred;", "", "mediaList", "", "Lcom/android/example/cameraxbasic/utils/MediaStoreFile;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onViewCreated", "view", "MediaPagerAdapter", "app_debug"})
public final class GalleryFragment extends androidx.fragment.app.Fragment {
    
    /**
     * Android ViewBinding
     */
    private com.android.example.cameraxbasic.databinding.FragmentGalleryBinding _fragmentGalleryBinding;
    
    /**
     * AndroidX navigation arguments
     */
    private final androidx.navigation.NavArgsLazy args$delegate = null;
    private java.util.List<com.android.example.cameraxbasic.utils.MediaStoreFile> mediaList;
    private kotlinx.coroutines.CompletableDeferred<java.lang.Boolean> hasMediaItems;
    
    public GalleryFragment() {
        super();
    }
    
    private final com.android.example.cameraxbasic.databinding.FragmentGalleryBinding getFragmentGalleryBinding() {
        return null;
    }
    
    /**
     * AndroidX navigation arguments
     */
    private final com.android.example.cameraxbasic.fragments.GalleryFragmentArgs getArgs() {
        return null;
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    /**
     * Adapter class used to present a fragment containing one photo or video as a page
     */
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0014\u0010\u0012\u001a\u00020\u00132\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/android/example/cameraxbasic/fragments/GalleryFragment$MediaPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "mediaList", "", "Lcom/android/example/cameraxbasic/utils/MediaStoreFile;", "(Lcom/android/example/cameraxbasic/fragments/GalleryFragment;Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V", "containsItem", "", "itemId", "", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "getItemId", "setMediaListAndNotify", "", "app_debug"})
    public final class MediaPagerAdapter extends androidx.viewpager2.adapter.FragmentStateAdapter {
        private java.util.List<com.android.example.cameraxbasic.utils.MediaStoreFile> mediaList;
        
        public MediaPagerAdapter(@org.jetbrains.annotations.NotNull
        androidx.fragment.app.FragmentManager fm, @org.jetbrains.annotations.NotNull
        java.util.List<com.android.example.cameraxbasic.utils.MediaStoreFile> mediaList) {
            super(null);
        }
        
        @java.lang.Override
        public int getItemCount() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public androidx.fragment.app.Fragment createFragment(int position) {
            return null;
        }
        
        @java.lang.Override
        public long getItemId(int position) {
            return 0L;
        }
        
        @java.lang.Override
        public boolean containsItem(long itemId) {
            return false;
        }
        
        public final void setMediaListAndNotify(@org.jetbrains.annotations.NotNull
        java.util.List<com.android.example.cameraxbasic.utils.MediaStoreFile> mediaList) {
        }
    }
}
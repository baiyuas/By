package com.baiyuas.utils.image;

import android.content.Context;
import android.util.Log;

import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory;
import com.bumptech.glide.module.AppGlideModule;

/**
 * @作者: Leo
 * @时间:2018/4/7
 * @描述:https://baiyuas.github.io/
 */
@GlideModule
public class WanAndroidAppModule extends AppGlideModule {

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        int memoryCacheSizeBytes = 1024 * 1024 * 20; // 20mb
//        builder.setMemoryCache(new LruResourceCache(memoryCacheSizeBytes));
        //builder.setDiskCache(new ExternalDiskCacheFactory(context));
        builder.setDiskCache(new ExternalPreferredCacheDiskCacheFactory(context, "wanAppCache", memoryCacheSizeBytes));
        builder.setLogLevel(Log.DEBUG);
    }

    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}

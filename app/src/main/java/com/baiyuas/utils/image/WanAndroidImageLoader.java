package com.baiyuas.utils.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

/**
 * @作者: Leo
 * @时间:2018/4/7
 * @描述:https://baiyuas.github.io/
 */
public class WanAndroidImageLoader {

    /**
     * 基本使用
     *
     * @param context
     * @param iv
     * @param url
     */
    public static void commonload(Context context, ImageView iv, String url) {
        GlideApp.with(context).load(url).into(iv);
    }

    public static void loadAsBimmap(Context context, String url, GlideTarget target) {
        GlideApp.with(context).asBitmap().load(url).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                target.onLoadFinish(resource);
            }
        });
    }

}

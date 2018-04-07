package com.baiyuas.utils.image;

import android.content.Context;
import android.widget.ImageView;

/**
 * @作者: Leo
 * @时间:2018/4/7
 * @描述:https://baiyuas.github.io/
 */
public class WanAndroidImageLoader {

    /**
     * 基本使用
     * @param context
     * @param iv
     * @param url
     */
    public static void commonload(Context context, ImageView iv, String url) {
        GlideApp.with(context).load(url).into(iv);
    }
}

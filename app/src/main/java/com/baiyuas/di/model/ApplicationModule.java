package com.baiyuas.di.model;

import android.content.Context;

import com.baiyuas.app.ByDaggerAndroidApp;

import dagger.Binds;
import dagger.Module;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
@Module
public abstract class ApplicationModule {

    @Binds
    abstract Context bindContext(ByDaggerAndroidApp application);
}

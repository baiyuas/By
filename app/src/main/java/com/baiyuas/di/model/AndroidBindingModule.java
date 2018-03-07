package com.baiyuas.di.model;

import com.baiyuas.di.scope.ActivityScope;
import com.baiyuas.ui.MainActivity;
import com.baiyuas.ui.MainModule;
import com.baiyuas.ui.welcome.WelcomeActivity;
import com.baiyuas.ui.welcome.WelcomeModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/3/7 0007
 * description:
 */
@Module
public abstract class AndroidBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {WelcomeModule.class})
    abstract WelcomeActivity welcomeActivity();

}

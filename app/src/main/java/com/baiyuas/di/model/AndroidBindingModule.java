package com.baiyuas.di.model;

import com.baiyuas.di.scope.ActivityScope;
import com.baiyuas.ui.welcome.WelcomeActivity;
import com.baiyuas.ui.welcome.WelcomeModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
@Module
public abstract class AndroidBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {WelcomeModule.class})
    abstract WelcomeActivity welcomeActivity();

}

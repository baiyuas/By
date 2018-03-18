package com.baiyuas.di.model;

import com.baiyuas.di.scope.ActivityScope;
import com.baiyuas.ui.MainActivity;
import com.baiyuas.ui.MainModule;
import com.baiyuas.ui.login.LoginActivity;
import com.baiyuas.ui.login.LoginModule;
import com.baiyuas.ui.welcome.WelcomeActivity;

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
    @ContributesAndroidInjector(modules = {LoginModule.class})
    abstract LoginActivity loginActivity();

    @ActivityScope
    @ContributesAndroidInjector(modules = {MainModule.class})
    abstract MainActivity mainActivity();

}

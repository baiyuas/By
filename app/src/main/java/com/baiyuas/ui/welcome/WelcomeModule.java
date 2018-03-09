package com.baiyuas.ui.welcome;

import com.baiyuas.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
@Module
public abstract class WelcomeModule {


    @ActivityScope
    @Binds
    abstract WelcomeContact.Presenter takePresenter(WelcomePresenter presenter);

}

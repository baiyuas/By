package com.baiyuas.ui.home;

import com.baiyuas.di.scope.FragmentScope;

import dagger.Binds;
import dagger.Module;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
@Module
public abstract class HomeModule {

    @FragmentScope
    @Binds
    abstract HomeContact.Presenter takeHomePresenter(HomePresenter homePresenter);
}

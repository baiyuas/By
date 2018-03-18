package com.baiyuas.ui.system;

import com.baiyuas.di.scope.FragmentScope;

import dagger.Binds;
import dagger.Module;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
@Module
public abstract class SysModule {

    @FragmentScope
    @Binds
    abstract SysContact.Presenter takeSysPresenter(SysPresenter sysPresenter);
}

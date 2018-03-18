package com.baiyuas.ui.login;

import com.baiyuas.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;

/**
 * @作者: Leo
 * @时间:2018/3/11
 * @描述:https://baiyuas.github.io/
 */
@Module
public abstract class LoginModule {


    @ActivityScope
    @Binds
    abstract LoginContact.Presenter takeLoginPresenter(LoginPresenter presenter);

}

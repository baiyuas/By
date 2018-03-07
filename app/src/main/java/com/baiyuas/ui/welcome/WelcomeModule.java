package com.baiyuas.ui.welcome;

import com.baiyuas.di.scope.ActivityScope;

import dagger.Binds;
import dagger.Module;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/3/7 0007
 * description:
 */
@Module
public abstract class WelcomeModule {


    @ActivityScope
    @Binds
    abstract WelcomeContact.Presenter takePresenter(WelcomePresenter presenter);

}

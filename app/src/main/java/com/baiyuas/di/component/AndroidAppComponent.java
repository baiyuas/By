package com.baiyuas.di.component;

import com.baiyuas.app.ByDaggerAndroidApp;
import com.baiyuas.di.model.AndroidBindingModule;
import com.baiyuas.di.model.NetRepoModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
@Singleton
@Component(modules = {NetRepoModule.class,
        AndroidBindingModule.class,
        AndroidSupportInjectionModule.class})
public interface AndroidAppComponent extends AndroidInjector<ByDaggerAndroidApp>{


    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder plus(ByDaggerAndroidApp app);

        AndroidAppComponent build();
    }

}

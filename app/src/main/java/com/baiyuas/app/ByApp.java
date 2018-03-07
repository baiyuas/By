package com.baiyuas.app;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.baiyuas.BuildConfig;
import com.baiyuas.di.component.AppComponent;
import com.baiyuas.di.component.DaggerAppComponent;
import com.baiyuas.di.model.AppModule;
import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/2/27 0027
 * description:
 */
public class ByApp extends Application {

    private static ByApp instance;
    private static AppComponent appComponent;
    public static synchronized ByApp Ins() {
        return instance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;


        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().name("hbmcc.realm").build();
        Realm.setDefaultConfiguration(config);
        if (BuildConfig.DEBUG) {
            Stetho.initialize(
                    Stetho.newInitializerBuilder(this)
                            .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                            .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                            .build());
        }
    }

    public AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();
        }
        return appComponent;
    }


}

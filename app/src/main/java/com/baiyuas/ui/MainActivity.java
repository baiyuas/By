package com.baiyuas.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.baiyuas.R;
import com.baiyuas.app.ByApp;
import com.baiyuas.databinding.ActivityMainBinding;
import com.baiyuas.di.component.DaggerActivityComponent;
import com.baiyuas.model.bean.local.FloorBean;
import com.baiyuas.model.bean.local.GgItemBean;
import com.baiyuas.model.http.NetRepo;

import java.lang.reflect.Field;
import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    @Inject
    NetRepo mNetRepo;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerActivityComponent.builder().appComponent(ByApp.Ins().getAppComponent()).build().inject(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        List<FloorBean> data = mNetRepo.fetchFloorInfo();
        binding.tvShow.setText(data.toString());
//        binding.vBottomMenu.mod
        binding.vBottomMenu.getMenu().getItem(2).setChecked(true);

    }

    public void addGongGe(View view) {
        Realm realm = Realm.getDefaultInstance();
        String path = realm.getPath();
        Log.d("leo", path);
        GgItemBean item = new GgItemBean();
        item.setId(1);
        item.setImage("life_wzcx");
        item.setClass_name_url("hbmcc://xxx");
        realm.beginTransaction();
        realm.copyToRealm(item);
        realm.commitTransaction();
    }
}

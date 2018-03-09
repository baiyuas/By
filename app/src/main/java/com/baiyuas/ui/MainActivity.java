package com.baiyuas.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.baiyuas.databinding.ActivityMainBinding;
import com.baiyuas.model.http.NetRepo;

import javax.inject.Inject;


/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
public class MainActivity extends AppCompatActivity {

    @Inject
    NetRepo mNetRepo;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public void addGongGe(View view) {

    }
}

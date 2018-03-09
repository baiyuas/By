package com.baiyuas.ui.welcome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.baiyuas.R;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
public class WelcomeActivity extends AppCompatActivity implements WelcomeContact.View{

    @Inject
    WelcomeContact.Presenter mWelcomePresenter;

    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mWelcomePresenter.takeView(this);

        text = findViewById(R.id.tv_welcome_text);
        mWelcomePresenter.reqFloorInfo();
    }

    @Override
    public void showFloorList(List list) {
        text.setText(list.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWelcomePresenter.dropView();
    }
}

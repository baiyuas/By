package com.baiyuas.ui.welcome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.baiyuas.R;
import com.baiyuas.model.bean.local.FloorBean;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

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
    public void showFloorList(List<FloorBean> list) {
        text.setText(list.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWelcomePresenter.dropView();
    }
}

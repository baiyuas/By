package com.baiyuas.ui.welcome;

import com.baiyuas.base.BasePresenter;
import com.baiyuas.base.BaseView;

import java.util.List;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
public interface WelcomeContact {

    interface View extends BaseView<Presenter> {
        void showFloorList(List list);
    }

    interface Presenter extends BasePresenter<View> {
       void reqFloorInfo();
    }

}

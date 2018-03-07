package com.baiyuas.ui.welcome;

import com.baiyuas.base.BasePresenter;
import com.baiyuas.base.BaseView;
import com.baiyuas.model.bean.local.FloorBean;

import java.util.List;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/3/7 0007
 * description:
 */
public interface WelcomeContact {

    interface View extends BaseView<Presenter> {
        void showFloorList(List<FloorBean> list);
    }

    interface Presenter extends BasePresenter<View>{
       void reqFloorInfo();
    }

}

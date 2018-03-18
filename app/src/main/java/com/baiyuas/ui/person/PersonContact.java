package com.baiyuas.ui.person;

import com.baiyuas.base.mvp.BasePresenter;
import com.baiyuas.base.mvp.BaseView;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
public interface PersonContact {

    interface Presenter extends BasePresenter<PersonContact.View> {
    }

    interface View extends BaseView {
    }
}

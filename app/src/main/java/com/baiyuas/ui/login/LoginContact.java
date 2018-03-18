package com.baiyuas.ui.login;

import com.baiyuas.base.mvp.BasePresenter;
import com.baiyuas.base.mvp.BaseView;

/**
 * @作者: Leo
 * @时间:2018/3/11
 * @描述:https://baiyuas.github.io/
 */
public interface LoginContact {

    interface Presenter extends BasePresenter<View> {
        void login(String username, String password);
    }

    interface View extends BaseView {
        void showLoginSuccess();

        void showLoginFail(String error);

        void showUsernameCheck(String tip);

        void showPasswordCheck(String tip);
    }

}

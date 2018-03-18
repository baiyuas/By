package com.baiyuas.ui.login;

import android.content.Context;
import android.text.TextUtils;

import com.baiyuas.R;
import com.baiyuas.app.ByDaggerAndroidApp;
import com.baiyuas.base.mvp.RxPresenter;
import com.baiyuas.model.http.NetRepo;
import com.baiyuas.model.http.exception.NetException;
import com.baiyuas.utils.Utils;
import com.baiyuas.utils.log.ByLogger;

import javax.inject.Inject;

/**
 * @作者: Leo
 * @时间:2018/3/11
 * @描述:https://baiyuas.github.io/
 */
public class LoginPresenter extends RxPresenter<LoginContact.View> implements LoginContact.Presenter {

    private NetRepo netRepo;
    private Context context;

    @Inject
    public LoginPresenter(NetRepo netRepo,
                          ByDaggerAndroidApp context) {
        this.netRepo = netRepo;
        this.context = context;
    }

    @Override
    public void login(String username, String password) {
        ByLogger.log("username ->" + username + "; password-> " + password);
        if (TextUtils.isEmpty(password)
                && !Utils.checkNull(mView.get())) {
            mView.get().showPasswordCheck(context.getResources().getString(R.string.error_field_required));
            return;
        }

        if (!Utils.isValidPassword(password)
                && !Utils.checkNull(mView.get())) {
            mView.get().showPasswordCheck(context.getResources().getString(R.string.error_invalid_password));
            return;
        }

        if (TextUtils.isEmpty(username)
                && !Utils.checkNull(mView.get())) {
            mView.get().showUsernameCheck(context.getResources().getString(R.string.error_field_required));
            return;
        }

        if (!Utils.isValidEmail(username)
                && !Utils.checkNull(mView.get())) {
            mView.get().showUsernameCheck(context.getResources().getString(R.string.error_invalid_email));
            return;
        }

        if (!Utils.checkNull(mView.get())) {
            mView.get().showLoading();
        }

        addSubscribe(netRepo.login(username, password)
                .compose(composeScheduler())
                .flatMap(response -> createData(response))
                .subscribe(userBean -> {
                            ByLogger.log(userBean.toString());
                            if (!Utils.checkNull(mView.get())) {
                                mView.get().dismissLoading();
                                mView.get().showLoginSuccess();
                            }
                        }, throwable -> {
                            String errorMsg = throwable instanceof NetException
                                    ? throwable.getMessage()
                                    : context.getResources().getString(R.string.tip_req_fail);
                            if (!Utils.checkNull(mView.get())) {
                                mView.get().dismissLoading();
                                mView.get().showLoginFail(errorMsg);
                            }
                        }
                ));
    }

}

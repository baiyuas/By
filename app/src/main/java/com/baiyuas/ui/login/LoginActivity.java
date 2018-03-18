package com.baiyuas.ui.login;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import com.baiyuas.R;
import com.baiyuas.base.mvp.MvpActivity;
import com.baiyuas.utils.Utils;

import butterknife.BindView;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
public class LoginActivity extends MvpActivity<LoginPresenter> implements LoginContact.View {

    @BindView(R.id.email)
    AutoCompleteTextView mEmailView;

    @BindView(R.id.password)
    EditText mPasswordView;

    @BindView(R.id.login_progress)
    View mProgressView;

    @BindView(R.id.login_form)
    View mLoginFormView;

    @BindView(R.id.email_sign_in_button)
    Button btnLogin;

    @Override
    protected int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initEvent() {
        mPasswordView.setOnEditorActionListener((textView, id, keyEvent) -> {
            log("id->" + id);
            if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                attemptLogin();
                return true;
            }
            return false;
        });
        btnLogin.setOnClickListener(view -> attemptLogin());
    }

    private void attemptLogin() {
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        mPresenter.login(email, password);
    }

    private void addEmailsToAutoComplete(List<String> emailAddressCollection) {
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(LoginActivity.this,
                        android.R.layout.simple_dropdown_item_1line, emailAddressCollection);

        mEmailView.setAdapter(adapter);
    }

    @Override
    public void showLoginSuccess() {
        toast(getString(R.string.login_tip_success));
    }

    @Override
    public void showLoginFail(String error) {
        toast(error);
    }

    @Override
    public void showUsernameCheck(String tip) {
        mEmailView.setError(tip);
        mEmailView.requestFocus();
    }

    @Override
    public void showPasswordCheck(String tip) {
        mPasswordView.setError(tip);
        mEmailView.requestFocus();
    }

    @Override
    public void showLoading() {
        showProgress(true);
    }

    @Override
    public void dismissLoading() {
        showProgress(false);
    }

    private void showProgress(final boolean show) {
        btnLogin.setText(show ? "" : getString(R.string.action_sign_in));
        int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
        mProgressView.animate().setDuration(shortAnimTime);
    }
}


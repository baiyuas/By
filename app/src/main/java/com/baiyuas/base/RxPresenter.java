package com.baiyuas.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
public class RxPresenter<T extends BaseView> implements BasePresenter<T> {

    WeakReference mView;

    CompositeDisposable compositeDisposable;

    private void unSubscribe() {
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    protected void addSubscribe(Disposable subscription) {
        if (compositeDisposable != null) {
            compositeDisposable.add(subscription);
        }
    }

    @Override
    public void takeView(T view) {
        mView = new WeakReference<>(view);

    }

    @Override
    public void dropView() {
        mView.clear();
        mView = null;

    }
}

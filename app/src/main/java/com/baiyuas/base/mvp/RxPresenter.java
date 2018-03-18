package com.baiyuas.base.mvp;

import com.baiyuas.model.bean.WanResponse;
import com.baiyuas.model.http.exception.NetException;
import com.baiyuas.utils.log.ByLogger;

import java.lang.ref.WeakReference;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
public class RxPresenter<T extends BaseView> implements BasePresenter<T> {

    protected WeakReference<T> mView;

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
        if (mView != null) {
            mView.clear();
        }
        mView = null;
        unSubscribe();

    }

    protected  <T> FlowableTransformer<T, T> composeScheduler() {    //compose简化线程
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    protected <T> Flowable<T> createData(WanResponse<T> response) {
        if (response.getErrorCode() == 0) {
            return Flowable.create(emitter -> {
                ByLogger.log(response.toString());
                try {
                    emitter.onNext(response.getData());
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }, BackpressureStrategy.BUFFER);
        } else {
            return Flowable.error(new NetException(response.getErrorMsg()));
        }
    }
}

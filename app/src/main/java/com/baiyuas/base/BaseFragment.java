package com.baiyuas.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baiyuas.R;
import com.baiyuas.base.inter.ISupport;
import com.baiyuas.utils.StatusBarUtil;
import com.baiyuas.utils.Utils;
import com.baiyuas.utils.log.ByLogger;
import com.baiyuas.utils.toast.Toasty;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:
 */
public abstract class BaseFragment extends Fragment implements ISupport {

    Unbinder unbinder;
    View parentView;

    @Override
    public void toast(String msg) {
        Toasty.show(getContext(), msg);
    }

    @Override
    public void log(String log) {
        ByLogger.log(log);
    }

    public void setToolbar(Toolbar toolbar) {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && getActivity() != null) {
            setStatusBar();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutId = bindLayout();
        if (layoutId == 0) {
            throw new IllegalStateException(
                    "layout id need to set");
        }
        if (isMaintainFragment() && Utils.checkNull(parentView)) {
            parentView = inflater.inflate(layoutId, container, false);
            unbinder = ButterKnife.bind(this, parentView);
            initEvent();
        } else if (!isMaintainFragment()) {
            parentView = inflater.inflate(layoutId, null);
        }
        return parentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (!isMaintainFragment()) {
            unbinder = ButterKnife.bind(this, view);
            initEvent();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (!isMaintainFragment()) {
            unbinder.unbind();
        } else {
            ((ViewGroup) parentView).removeView(parentView);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (isMaintainFragment()) {
            unbinder.unbind();
        }
    }


    protected abstract int bindLayout();

    /**
     * 是否保持Fragment初始化一次View
     *
     * @return
     */
    protected boolean isMaintainFragment() {
        return true;
    }

    protected abstract void initEvent();

    public void setStatusBar() {
        StatusBarUtil.setColor(getActivity(), getResources().getColor(R.color.colorPrimary), 255);
    }
}

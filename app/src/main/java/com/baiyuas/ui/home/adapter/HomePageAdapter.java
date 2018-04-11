package com.baiyuas.ui.home.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.MultipleItemRvAdapter;

import java.util.List;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/4/10 0010
 * description:
 */
public class HomePageAdapter extends MultipleItemRvAdapter<HomeMultiEntity, BaseViewHolder> {

    public HomePageAdapter(@Nullable List<HomeMultiEntity> data) {
        super(data);
        finishInitialize();
    }

    @Override
    protected int getViewType(HomeMultiEntity homeMultiEntity) {
        return homeMultiEntity.type;
    }

    @Override
    public void registerItemProvider() {
        mProviderDelegate.registerProvider(new BannerProvider());
        mProviderDelegate.registerProvider(new ArticleProvider());
    }
}

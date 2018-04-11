package com.baiyuas.ui.home.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.baiyuas.R;
import com.baiyuas.app.Constant;
import com.baiyuas.model.bean.ArticleBean;
import com.baiyuas.ui.adapter.ArticleAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.annotation.ItemProviderTag;
import com.chad.library.adapter.base.provider.BaseItemProvider;

import java.util.Random;

/**
 * Copyright (c)2017
 * 欣网互联网络科技有限公司
 * author: lpc
 * created on: 2018/4/10 0010
 * description:
 */
@ItemProviderTag(viewType = HomeMultiEntity.VIEW_TYPE_ARTICLE, layout = R.layout.home_provider_article)
public class ArticleProvider extends BaseItemProvider<HomeMultiEntity<ArticleBean>, BaseViewHolder> {

    Random mRandom = new Random();

    @Override
    public void convert(BaseViewHolder helper, HomeMultiEntity<ArticleBean> data, int position) {
        ArticleBean articleBean = data.item;
        int colorRandom = mRandom.nextInt(5);
        helper.setText(R.id.tv_article_author, String.format(mContext.getResources().getString(R.string.item_article_author_str), articleBean.getAuthor()))
                .setText(R.id.tv_article_title, articleBean.getTitle())
                .setText(R.id.tv_article_catalog, String.format(mContext.getResources().getString(R.string.item_article_catalog_str), articleBean.getSuperChapterName()))
                .setText(R.id.tv_article_date, articleBean.getNiceDate())
                .setBackgroundColor(R.id.nav_line, mContext.getResources().getColor(Constant.navColors[colorRandom]));

    }

    @Override
    public void onClick(BaseViewHolder helper, HomeMultiEntity<ArticleBean> data, int position) {

    }

    @Override
    public boolean onLongClick(BaseViewHolder helper, HomeMultiEntity<ArticleBean> data, int position) {
        return false;
    }
}

package com.baiyuas.ui.adapter;

import android.support.annotation.Nullable;

import com.baiyuas.R;
import com.baiyuas.app.Constant;
import com.baiyuas.model.bean.ArticleBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;
import java.util.Random;

/**
 * @作者: Leo
 * @时间:2018/4/7
 * @描述:https://baiyuas.github.io/
 */
public class ArticleAdapter extends BaseQuickAdapter<ArticleBean, BaseViewHolder> {

    Random mRandom = new Random();

    public ArticleAdapter(int layoutResId, @Nullable List<ArticleBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ArticleBean item) {
        ArticleBean articleBean = item;
        int colorRandom = mRandom.nextInt(5);
        helper.setText(R.id.tv_article_author, String.format(mContext.getResources().getString(R.string.item_article_author_str), articleBean.getAuthor()))
                .setText(R.id.tv_article_title, articleBean.getTitle())
                .setText(R.id.tv_article_catalog, String.format(mContext.getResources().getString(R.string.item_article_catalog_str), articleBean.getSuperChapterName()))
                .setText(R.id.tv_article_date, articleBean.getNiceDate())
                .setBackgroundColor(R.id.nav_line, mContext.getResources().getColor(Constant.navColors[colorRandom]));
    }
}

package com.baiyuas.ui.system;

import com.baiyuas.base.mvp.BasePresenter;
import com.baiyuas.base.mvp.BaseView;
import com.baiyuas.model.bean.HomeArticleBean;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
public class SysContact {

    interface Presenter extends BasePresenter<SysContact.View> {
        void fetchHierarchyArticleList();
        void fetchMoreHierarchyArticleList(int page);
    }

    interface View extends BaseView {
        void showHierarchyArticle(HomeArticleBean homeArticleBean);
    }
}

package com.baiyuas.ui.project;

import android.support.annotation.IntRange;

import com.baiyuas.base.mvp.BasePresenter;
import com.baiyuas.base.mvp.BaseView;
import com.baiyuas.model.bean.ListBean;
import com.baiyuas.model.bean.ProjectBean;
import com.baiyuas.model.bean.ProjectCatalogBean;

import java.util.List;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
public interface ProjectContact {

    interface Presenter extends BasePresenter<ProjectContact.View> {

        void fetchProjectCatalog();

        void fetchCatUnderProject(@IntRange(from = 0) int catId, @IntRange(from = 0) int page);
    }

    interface View extends BaseView {
        void showProjectCatalog(List<ProjectCatalogBean> projectCatalogBeanList);

        void showCatUnderProject(ListBean<ProjectBean> projectListBean);
    }
}

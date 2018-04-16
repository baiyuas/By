package com.baiyuas.ui.project;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import com.baiyuas.R;
import com.baiyuas.base.mvp.MvpFragment;
import com.baiyuas.model.bean.ListBean;
import com.baiyuas.model.bean.ProjectBean;
import com.baiyuas.model.bean.ProjectCatalogBean;
import com.baiyuas.utils.StatusBarUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
public class ProjectFragment extends MvpFragment<ProjectPresenter> implements ProjectContact.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.rv_project_list)
    RecyclerView mRecyclerView;

    @BindView(R.id.srl_reload)
    RefreshLayout mRefreshLayout;

    private int mCurrentPage = 1;
    private int mCurrentCatalogIndex = 0;
    private boolean isRefresh = false;
    private ProjectAdapter mBaseQuickAdapter;
    private List<ProjectBean> mProjectBeans;
    private List<ProjectCatalogBean> mCatalogBeans;

    @Inject
    public ProjectFragment() {
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_project;
    }

    @Override
    protected void initEvent() {
        mToolbar.setTitle(getString(R.string.tab_project));
        mToolbar.setTitle(R.string.title_project);
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        initRecyclerView();
        mRefreshLayout.setOnLoadMoreListener(refreshLayout -> mPresenter.fetchCatUnderProject(mCatalogBeans.get(mCurrentCatalogIndex).getId(), mCurrentPage));
        mRefreshLayout.setOnRefreshListener(refreshLayout -> {
            isRefresh = true;
            mPresenter.fetchCatUnderProject(mCatalogBeans.get(mCurrentCatalogIndex = 0).getId(), mCurrentPage = 1);
        });
        mPresenter.fetchProjectCatalog();
    }

    private void initRecyclerView() {
        StaggeredGridLayoutManager slm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(slm);
        mProjectBeans = new ArrayList<>();
        mRecyclerView.setAdapter(mBaseQuickAdapter = new ProjectAdapter(mProjectBeans));
    }

    @Override
    public void setStatusBar() {
        StatusBarUtil.setFullStatusbarForFragment(getActivity(), getResources().getColor(R.color.colorPrimary), mToolbar);
    }

    @Override
    public void showProjectCatalog(List<ProjectCatalogBean> projectCatalogBeanList) {
        mCatalogBeans = projectCatalogBeanList;
        mPresenter.fetchCatUnderProject(mCatalogBeans.get(mCurrentCatalogIndex).getId(), mCurrentPage);
    }

    @Override
    public void showCatUnderProject(ListBean<ProjectBean> projectListBean) {
        mRefreshLayout.finishRefresh(true);
        mRefreshLayout.finishLoadMore(true);
        if (isRefresh) {
            mBaseQuickAdapter.setNewData(projectListBean.getDatas());
            isRefresh = false;
        } else {
            mBaseQuickAdapter.addData(projectListBean.getDatas());
        }

        if (mCurrentCatalogIndex < mCatalogBeans.size() - 1) {
            if (projectListBean.getPageCount() >= mCurrentPage + 1) {
                mCurrentPage++;
            } else {
                mCurrentPage = 1;
                mCurrentCatalogIndex++;
            }
        }

        if (projectListBean.getPageCount() == mCurrentPage && mCurrentCatalogIndex == mCatalogBeans.size() - 1) {
            mRefreshLayout.setNoMoreData(true);
            mRefreshLayout.setEnableAutoLoadMore(false);
        }
    }

    @Override
    public void dismissLoading() {
        mRefreshLayout.finishRefresh(true);
        mRefreshLayout.finishLoadMore(true);
    }
}

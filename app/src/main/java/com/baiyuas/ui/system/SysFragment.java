package com.baiyuas.ui.system;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.baiyuas.R;
import com.baiyuas.base.mvp.MvpFragment;
import com.baiyuas.model.bean.HomeArticleBean;
import com.baiyuas.ui.adapter.ArticleAdapter;
import com.baiyuas.utils.StatusBarUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * @作者: Leo
 * @时间:2018/3/18
 * @描述:https://baiyuas.github.io/
 */
public class SysFragment extends MvpFragment<SysPresenter> implements SysContact.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.rv_article_list)
    RecyclerView mRecyclerView;

    @BindView(R.id.srl_reload)
    RefreshLayout mRefreshLayout;


    private int currentPage = 0;
    private boolean isRefresh = false;
    private ArticleAdapter mArticleAdapter;

    @Inject
    public SysFragment() {
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_sys;
    }

    @Override
    protected void initEvent() {
        setToolbar(mToolbar);
        mToolbar.setTitle(R.string.title_system);
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        initRecycleView();

        mPresenter.fetchHierarchyArticleList();

        mRefreshLayout.setOnRefreshListener(refreshLayout -> {
            isRefresh = true;
            mPresenter.fetchHierarchyArticleList();
        });
        mRefreshLayout.setOnLoadMoreListener(refreshLayout -> mPresenter.fetchMoreHierarchyArticleList(++currentPage));
    }

    private void initRecycleView() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);
        mArticleAdapter = new ArticleAdapter();
        mRecyclerView.setAdapter(mArticleAdapter);
    }

    @Override
    public void setStatusBar() {
        StatusBarUtil.setFullStatusbarForFragment(getActivity(), getResources().getColor(R.color.colorPrimary), mToolbar);
    }

    @Override
    public void showHierarchyArticle(HomeArticleBean homeArticleBean) {
        mRefreshLayout.finishRefresh(true);
        mRefreshLayout.finishLoadMore(true);
        if (isRefresh) {
            mArticleAdapter.setNewData(homeArticleBean.getDatas());
        } else {
            mArticleAdapter.addData(homeArticleBean.getDatas());
        }
        if (homeArticleBean.getPageCount() == currentPage + 1) {
            mRefreshLayout.setNoMoreData(true);
            return;
        }
    }
}

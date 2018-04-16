package com.baiyuas.ui.home;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.baiyuas.R;
import com.baiyuas.base.mvp.MvpFragment;
import com.baiyuas.ui.home.adapter.HomeMultiEntity;
import com.baiyuas.ui.home.adapter.HomePageAdapter;
import com.baiyuas.utils.StatusBarUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * @作者: Leo
 * @时间:2018/3/11
 * @描述:https://baiyuas.github.io/
 */
public class HomeFragment extends MvpFragment<HomePresenter> implements HomeContact.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.rv_home_page)
    RecyclerView mRecyclerView;

    @BindView(R.id.srl_reload)
    RefreshLayout mRefreshLayout;

    private int mDistance;
    private int currentPage = 0;
    private HomePageAdapter mHomePageAdapter;

    @Inject
    public HomeFragment() {
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initEvent() {
        setStatusBar();

        initToolbar();
        initRecycleView();
        mPresenter.fetchHomeData();
        mRefreshLayout.setOnRefreshListener(refreshLayout -> mPresenter.fetchHomeData());
        mRefreshLayout.setOnLoadMoreListener(refreshLayout -> mPresenter.fetchHomeArticleList(++currentPage));
    }

    private void initToolbar() {
        setToolbar(mToolbar);
        mToolbar.setTitle("");
        mToolbar.getBackground().setAlpha(0);
        mToolbar.setTitleTextColor(Color.WHITE);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mDistance += dy;
                int actionBarHeight = mToolbar.getBottom();

                if (mDistance <= actionBarHeight) {
                    mToolbar.setTitle("");
                    float alpha = mDistance * 1.0f / actionBarHeight * 255;
                    mToolbar.getBackground().setAlpha((int) alpha);
                } else {
                    mToolbar.setTitle(getString(R.string.app_name));
                    mToolbar.getBackground().setAlpha(255);
                }
            }
        });
    }


    private void initRecycleView() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);
        mHomePageAdapter = new HomePageAdapter(new ArrayList<>());
        mRecyclerView.setAdapter(mHomePageAdapter);
    }

    @Override
    public void setStatusBar() {
        StatusBarUtil.setTransparentForFragment(getActivity(), mToolbar);
    }

    @Override
    public void showHomeArticle(List<HomeMultiEntity> list, boolean isEnd) {
        dismissLoading();

        mHomePageAdapter.addData(list);
        mRefreshLayout.setNoMoreData(isEnd);
    }

    @Override
    public void showHomePageData(List<HomeMultiEntity> data) {
        mRefreshLayout.finishRefresh(true);
        mHomePageAdapter.setNewData(data);
    }

    @Override
    public void dismissLoading() {
        mRefreshLayout.finishRefresh(true);
        mRefreshLayout.finishLoadMore(true);

    }
}

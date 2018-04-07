package com.baiyuas.ui.home;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.baiyuas.R;
import com.baiyuas.base.mvp.MvpFragment;
import com.baiyuas.model.bean.HomeArticleBean;
import com.baiyuas.model.bean.HomeBannerBean;
import com.jaeger.library.StatusBarUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.Observable;

import static com.baiyuas.utils.image.WanAndroidImageLoader.commonload;

/**
 * @作者: Leo
 * @时间:2018/3/11
 * @描述:https://baiyuas.github.io/
 */
public class HomeFragment extends MvpFragment<HomePresenter> implements HomeContact.View {

    @BindView(R.id.banner)
    Banner mBanner;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.rv_article_list)
    RecyclerView mRecycleView;

    private int currentPage = 0;
    private ArticleAdapter mArticleAdapter;

    @Inject
    public HomeFragment() {
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initEvent() {
        setToolbar(mToolbar);
        mToolbar.setAlpha(0.5f);
        mToolbar.setTitle("");
        setStatusBar();

        mPresenter.fetchHomeBannerList();
        mPresenter.fetchHomeArticleList(currentPage);

        initBanner();
        initRecycleView();
    }

    private void initRecycleView() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycleView.setLayoutManager(llm);
        mArticleAdapter = new ArticleAdapter();
        mRecycleView.setAdapter(mArticleAdapter);
    }

    private void initBanner() {
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        mBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                commonload(context, imageView, String.valueOf(path));
            }
        });
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.DepthPage);

        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CENTER);
    }

    @Override
    public void showHomeBannerList(List<HomeBannerBean> list) {
        List<String> images = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        Observable.fromIterable(list)
                .toSortedList((o1, o2) -> o1.getOrder() > o2.getOrder() ? 1 : -1)
                .subscribe(homeBannerBeans -> Observable.fromIterable(homeBannerBeans)
                        .forEach(homeBannerList -> {
                            images.add(homeBannerList.getImagePath());
                            titles.add(homeBannerList.getTitle());
                        }));

        mBanner.setImages(images);
        mBanner.setBannerTitles(titles);
        mBanner.start();
    }

    @Override
    public void showHomeArticle(HomeArticleBean homeArticleBean) {
        if (homeArticleBean.getPageCount() == currentPage + 1) {
            return;
        }
        mArticleAdapter.addData(homeArticleBean.getDatas());
    }

    @Override
    public void onPause() {
        super.onPause();
        mBanner.stopAutoPlay();
    }

    @Override
    public void onResume() {
        super.onResume();
        mBanner.startAutoPlay();
    }

    @Override
    public void setStatusBar() {
        StatusBarUtil.setTransparent(getActivity());
    }
}

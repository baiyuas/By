package com.baiyuas.ui;

import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.baiyuas.R;
import com.baiyuas.base.BaseActivity;
import com.baiyuas.base.mvp.MvpActivity;
import com.baiyuas.base.mvp.MvpFragment;
import com.baiyuas.ui.home.HomeFragment;
import com.baiyuas.ui.navigation.NavFragment;
import com.baiyuas.ui.person.PersonFragment;
import com.baiyuas.ui.project.ProjectFragment;
import com.baiyuas.ui.system.SysFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;


/**
 * @作者: Leo
 * @时间:2018/3/9
 * @描述:https://baiyuas.github.io/
 */
public class MainActivity extends MvpActivity<MainPresenter> implements BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.vp_main_container)
    ViewPager mViewPager;

    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;

    @Inject
    HomeFragment homeFragment;

    @Inject
    NavFragment navFragment;

    @Inject
    SysFragment sysFragment;

    @Inject
    PersonFragment personFragment;

    @Inject
    ProjectFragment projectFragment;

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initEvent() {
        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.home_p, getString(R.string.tab_home))
                        .setInactiveIconResource(R.drawable.home)
                        .setActiveColorResource(R.color.tab_active_color))
                .addItem(new BottomNavigationItem(R.drawable.project_p, getString(R.string.tab_project))
                        .setInactiveIconResource(R.drawable.project)
                        .setActiveColorResource(R.color.tab_active_color))
                .addItem(new BottomNavigationItem(R.drawable.system_p, getString(R.string.tab_system))
                        .setInactiveIconResource(R.drawable.system)
                        .setActiveColorResource(R.color.tab_active_color))
                .addItem(new BottomNavigationItem(R.drawable.navigation_p, getString(R.string.tab_navigation))
                        .setInactiveIconResource(R.drawable.navigation)
                        .setActiveColorResource(R.color.tab_active_color))
                .addItem(new BottomNavigationItem(R.drawable.mine_p, getString(R.string.tab_person))
                        .setInactiveIconResource(R.drawable.mine)
                        .setActiveColorResource(R.color.tab_active_color))
                .setFirstSelectedPosition(0)
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBarBackgroundColor(android.R.color.white)
                .setTabSelectedListener(this)
                .initialise();
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(homeFragment);
        fragmentList.add(projectFragment);
        fragmentList.add(sysFragment);
        fragmentList.add(navFragment);
        fragmentList.add(personFragment);
        log(homeFragment.toString());
        log("---------size" + fragmentList.size());

        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setAdapter(new TabViewPagerAdapter(getSupportFragmentManager() ,fragmentList));
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onTabSelected(int position) {
        mViewPager.setCurrentItem(position, false);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mBottomNavigationBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

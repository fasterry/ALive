package com.zcl.alive.ui.fragments;


import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.zcl.alive.R;
import com.zcl.alive.base.BaseFragment;
import com.zcl.alive.presenter.DiscoverPresenter;
import com.zcl.alive.utils.EventUtil;
import com.zcl.alive.widget.SwipeViewPager;
import com.zcl.alive.widget.theme.ColorRelativeLayout;
import com.zcl.alive.widget.theme.ColorTextView;

import butterknife.BindView;

/**
 * Description: 发现页
 * Creator: fasterry
 * date: $date $time
 */
public class DiscoverFragment extends BaseFragment {

    @BindView(R.id.title)
    ColorRelativeLayout title;
    @BindView(R.id.title_name)
    ColorTextView titleName;

    @BindView(R.id.viewpagertab)
    SmartTabLayout mViewpagertab;
    @BindView(R.id.viewpager)
    SwipeViewPager mViewpager;
    FragmentPagerItemAdapter pagerItemAdapter;


    @Override
    protected void initView(LayoutInflater inflater) {
        titleName.setText("今日新闻");
        pagerItemAdapter = new FragmentPagerItemAdapter(
                getFragmentManager(), FragmentPagerItems.with(mContext)
                .add(R.string.news_top, NewsInfoFragment.class)
                .add(R.string.news_keji, NewsInfoFragment.class)
                .add(R.string.news_caijing,NewsInfoFragment.class)
                .add(R.string.news_guoji,NewsInfoFragment.class)
                .add(R.string.news_shehui,NewsInfoFragment.class)
                .add(R.string.news_shishang,NewsInfoFragment.class)
                .add(R.string.news_tiyu,NewsInfoFragment.class)
                .add(R.string.news_yule,NewsInfoFragment.class)
                .add(R.string.news_junshi,NewsInfoFragment.class)
                .create());
        mViewpager.setAdapter(pagerItemAdapter);
        mViewpagertab.setViewPager(mViewpager);
    }

    @Override
    protected void initEvent() {
        mViewpagertab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                String title = pagerItemAdapter.getPageTitle(position).toString();
                String newsType ="top";
                switch (position){
                    case 0:
                        newsType = "top";
                        break;
                    case 1:
                        newsType = "keji";
                        break;
                    case 2:
                        newsType = "caijing";
                        break;
                    case 3:
                        newsType = "guoji";
                        break;
                    case 4:
                        newsType = "shehui";
                        break;
                    case 5:
                        newsType = "shishang";
                        break;
                    case 6:
                        newsType = "tiyu";
                        break;
                    case 7:
                        newsType = "yule";
                        break;
                    case 8:
                        newsType = "junshi";
                        break;
                }
                DiscoverPresenter.newType = newsType;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (EventUtil.isFastDoubleClick()) {
                    //recyclerView.scrollToPosition(0);
                }
            }
        });

    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_discovery;
    }


}
package com.zcl.alive.ui.fragments;


import android.app.Fragment;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.zcl.alive.R;
import com.zcl.alive.base.BaseMvpFragment;
import com.zcl.alive.model.bean.MovieRes;
import com.zcl.alive.model.bean.NewsInfo;
import com.zcl.alive.model.bean.NewsRes;
import com.zcl.alive.model.bean.VideoType;
import com.zcl.alive.presenter.DiscoverPresenter;
import com.zcl.alive.presenter.contract.DiscovertContract;
import com.zcl.alive.ui.activitys.NewsInfoActivity;
import com.zcl.alive.ui.adapter.DiscoverAdapter;
import com.zcl.alive.ui.adapter.RecommendAdapter;
import com.zcl.alive.utils.EventUtil;
import com.zcl.alive.utils.ScreenUtil;
import com.zcl.alive.widget.theme.ColorRelativeLayout;
import com.zcl.alive.widget.theme.ColorTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Description: 发现页
 * Creator: fasterry
 * date: $date $time
 */
public class DiscoverFragment extends BaseMvpFragment<DiscoverPresenter> implements DiscovertContract.View, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.title)
    ColorRelativeLayout title;
    @BindView(R.id.title_name)
    ColorTextView titleName;
    @BindView(R.id.discoveryrecyclerView)
    EasyRecyclerView recyclerView;
    DiscoverAdapter adapter;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void initView(LayoutInflater inflater) {
        titleName.setText("今日新闻");

        recyclerView.setAdapterWithProgress(adapter = new DiscoverAdapter(getContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setErrorView(R.layout.view_error);
        SpaceDecoration itemDecoration = new SpaceDecoration(ScreenUtil.dip2px(getContext(), 8));
        itemDecoration.setPaddingEdgeSide(true);
        itemDecoration.setPaddingStart(true);
        itemDecoration.setPaddingHeaderFooter(false);
        recyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    protected void initEvent() {
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (EventUtil.isFastDoubleClick()) {
                    recyclerView.scrollToPosition(0);
                }
            }
        });

        recyclerView.setRefreshListener(this);
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (getHeaderScroll() <= ScreenUtil.dip2px(mContext, 150)) {
                    new Handler().postAtTime(new Runnable() {
                        @Override
                        public void run() {
                            float percentage = (float) getHeaderScroll() / ScreenUtil.dip2px(mContext, 150);
                            title.setAlpha(percentage);
                            if (percentage > 0)
                                title.setVisibility(View.VISIBLE);
                            else
                                title.setVisibility(View.GONE);

                        }
                    }, 300);
                } else {
                    title.setAlpha(1.0f);
                    title.setVisibility(View.VISIBLE);
                }
            }
        });

        recyclerView.getErrorView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.showProgress();
                onRefresh();
            }
        });

        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                NewsInfoActivity.start(mContext, adapter.getItem(position));
            }
        });
    }

    private int getHeaderScroll() {
        return 100;
    }

    @Override
    protected void lazyFetchData() {
        super.lazyFetchData();
        mPresenter.onRefresh();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_discovery;
    }

    @Override
    public void showContent(NewsRes newsRes) {
        if (newsRes != null) {
            adapter.clear();
            List<NewsInfo>  newsInfos;
            newsInfos = newsRes.getData();
            if(newsInfos!=null) {
                adapter.addAll(newsInfos);
            }
        }
    }

    @Override
    public void refreshFaild(String msg) {
        if (!TextUtils.isEmpty(msg))
            showError(msg);
        recyclerView.showError();
    }

    @Override
    public void showError(String msg) {
        EventUtil.showToast(mContext, msg);
    }

    @Override
    public void onRefresh() {
        mPresenter.onRefresh();
    }
}
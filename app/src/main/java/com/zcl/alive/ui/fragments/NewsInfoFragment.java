package com.zcl.alive.ui.fragments;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.zcl.alive.R;
import com.zcl.alive.base.BaseMvpFragment;
import com.zcl.alive.model.bean.news.NewsInfo;
import com.zcl.alive.model.bean.news.NewsRes;
import com.zcl.alive.presenter.DiscoverPresenter;
import com.zcl.alive.presenter.contract.DiscovertContract;
import com.zcl.alive.ui.activitys.NewsInfoActivity;
import com.zcl.alive.ui.adapter.DiscoverAdapter;
import com.zcl.alive.utils.EventUtil;
import com.zcl.alive.utils.ScreenUtil;

import java.util.List;

import butterknife.BindView;


public class NewsInfoFragment extends BaseMvpFragment<DiscoverPresenter> implements DiscovertContract.View, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.discoveryrecyclerView)
    EasyRecyclerView recyclerView;
    DiscoverAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_news_intro;
    }

    @Override
    protected void initView(LayoutInflater inflater) {
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
        recyclerView.setRefreshListener(this);
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
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

    @Override
    public void showContent(NewsRes newsRes) {
        if (newsRes != null) {
            adapter.clear();
            List<NewsInfo> newsInfos;
            newsInfos = newsRes.getData();
            if (newsInfos != null) {
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

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void lazyFetchData() {
        super.lazyFetchData();
        mPresenter.onRefresh();
    }
}

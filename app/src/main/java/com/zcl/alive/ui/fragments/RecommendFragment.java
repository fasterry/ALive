package com.zcl.alive.ui.fragments;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.jude.rollviewpager.hintview.IconHintView;
import com.zcl.alive.R;
import com.zcl.alive.base.BaseMvpFragment;
import com.zcl.alive.model.bean.movies.MovieInfo;
import com.zcl.alive.model.bean.movies.MoviesRes;
import com.zcl.alive.presenter.RecommendPresenter;
import com.zcl.alive.presenter.contract.RecommendContract;
import com.zcl.alive.ui.activitys.SearchActivity;
import com.zcl.alive.ui.adapter.BannerAdapter;
import com.zcl.alive.ui.adapter.RecommendAdapter;
import com.zcl.alive.utils.EventUtil;
import com.zcl.alive.utils.ScreenUtil;
import com.zcl.alive.widget.RollPagerView;
import com.zcl.alive.widget.theme.ColorRelativeLayout;
import com.zcl.alive.widget.theme.ColorTextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecommendFragment extends BaseMvpFragment<RecommendPresenter> implements RecommendContract.View, SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {
    @BindView(R.id.recyclerView)
    EasyRecyclerView recyclerView;
    @Nullable
    @BindView(R.id.title)
    ColorRelativeLayout title;
    @BindView(R.id.title_name)
    ColorTextView titleName;
    RollPagerView banner;
    View headerView;
    RecommendAdapter adapter;
    TextView etSearchKey;
    RelativeLayout rlGoSearch;

    @Override
    protected void initView(LayoutInflater inflater) {

        EventBus.getDefault().register(this);
        // title.setVisibility(View.GONE);
        titleName.setText("电影");


        headerView = LayoutInflater.from(mContext).inflate(R.layout.recommend_header, null);
        banner = ButterKnife.findById(headerView, R.id.banner);
        rlGoSearch = ButterKnife.findById(headerView, R.id.rlGoSearch);
        etSearchKey = ButterKnife.findById(headerView, R.id.etSearchKey);
        banner.setPlayDelay(2000);


        recyclerView.setAdapterWithProgress(adapter = new RecommendAdapter(getContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setErrorView(R.layout.view_error);
        SpaceDecoration itemDecoration = new SpaceDecoration(ScreenUtil.dip2px(getContext(), 8));
        itemDecoration.setPaddingEdgeSide(true);
        itemDecoration.setPaddingStart(true);
        itemDecoration.setPaddingHeaderFooter(false);
        recyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    protected void lazyFetchData() {
        super.lazyFetchData();
        mPresenter.onRefresh();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void onResume() {
        super.onResume();
        stopBanner(false);
    }

    @Override
    public void onPause() {
        super.onPause();
        stopBanner(true);
    }


    @Override
    protected void initEvent() {
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                            //   title.setAlpha(percentage);
//                            if (percentage > 0)
//                              //  title.setVisibility(View.VISIBLE);
//                            else
//                              title.setVisibility(View.GONE);

                        }
                    }, 300);
                } else {
                    // title.setAlpha(1.0f);
                    // title.setVisibility(View.VISIBLE);
                }
            }
        });
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // VideoInfoActivity.start(mContext, adapter.getItem(position));
            }
        });
        recyclerView.getErrorView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.showProgress();
                onRefresh();
            }
        });
        rlGoSearch.setOnClickListener(this);
    }

    @Override
    public void showError(String msg) {
        EventUtil.showToast(mContext, msg);
    }

    @Override
    public void showContent(final MoviesRes movieRes) {
        if (movieRes != null) {
            adapter.clear();
            List<MovieInfo> movieInfoList;
            movieInfoList = movieRes.getMovieInfoList();
            if (movieInfoList != null) {
                adapter.addAll(movieInfoList);
            }

            if (adapter.getHeaderCount() == 0) {
                adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
                    @Override
                    public View onCreateView(ViewGroup parent) {
                        banner.setHintView(new IconHintView(getContext(), R.mipmap.ic_page_indicator_focused, R.mipmap.ic_page_indicator, ScreenUtil.dip2px(getContext(), 10)));
                        banner.setHintPadding(0, 0, 0, ScreenUtil.dip2px(getContext(), 8));
                        banner.setAdapter(new BannerAdapter(getContext(), null));
                        return headerView;
                    }

                    @Override
                    public void onBindView(View headerView) {

                    }
                });
            }
        }

    }

    @Override
    public void refreshFaild(String msg) {
        if (!TextUtils.isEmpty(msg))
            showError(msg);
        recyclerView.showError();
    }

    @Subscribe
    public void stopBanner(boolean stop) {
        if (stop) {
            banner.pause();
        } else {
            banner.resume();
        }
    }

    @Override
    public void onRefresh() {
        mPresenter.onRefresh();
    }

    private int getHeaderScroll() {
        if (headerView == null) {
            return 0;
        }
        int distance = headerView.getTop();
        distance = Math.abs(distance);
        return distance;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rlGoSearch:
                Intent intent = new Intent(mContext, SearchActivity.class);
                mContext.startActivity(intent);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }
}


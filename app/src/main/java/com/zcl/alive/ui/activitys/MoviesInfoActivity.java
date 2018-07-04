package com.zcl.alive.ui.activitys;

import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;

import com.zcl.alive.R;
import com.zcl.alive.base.SwipeBackActivity;
import com.zcl.alive.model.bean.movies.MovieInfo;
import com.zcl.alive.model.bean.news.NewsInfo;
import com.zcl.alive.presenter.MoviesInfoPresenter;
import com.zcl.alive.presenter.NewsInfoPresenter;
import com.zcl.alive.presenter.contract.MoviesInfoContract;
import com.zcl.alive.presenter.contract.NewsInfoContract;
import com.zcl.alive.widget.theme.ColorTextView;

import butterknife.BindView;

public class MoviesInfoActivity extends SwipeBackActivity<MoviesInfoPresenter> implements MoviesInfoContract.View{

    @BindView(R.id.title_name)
    ColorTextView titleName;
    @BindView(R.id.webView_news)
    WebView webView;

    MovieInfo newsInfo;
    private Animation animation;
    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_movies_info;
    }

    @Override
    protected void getIntentData() {
        newsInfo = (MovieInfo)getIntent().getSerializableExtra("moviesinfo");
    }

    @Override
    protected void initView() {
//        webView.loadUrl(newsInfo.getUrl());
//        titleName.setText(newsInfo.getTitle());

    }

    @Override
    public void showError(String msg) {

    }

    public static void start(Context context, MovieInfo movieInfo) {
        Intent starter = new Intent(context, MoviesInfoActivity.class);
        starter.putExtra("moviesinfo", movieInfo);
        context.startActivity(starter);
    }
}

package com.zcl.alive.ui.activitys;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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
    @BindView(R.id.webView_movies)
    WebView webView;

    MovieInfo movieInfo;

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
        movieInfo = (MovieInfo)getIntent().getSerializableExtra("movieinfo");
    }

    @Override
    protected void initView() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setSupportMultipleWindows(true);
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl(movieInfo.getAlt());
        titleName.setText(movieInfo.getTitle());

    }

    @Override
    public void showError(String msg) {

    }

    public static void start(Context context, MovieInfo movieInfo) {
        Intent starter = new Intent(context, MoviesInfoActivity.class);
        starter.putExtra("movieinfo", movieInfo);
        context.startActivity(starter);
    }
}

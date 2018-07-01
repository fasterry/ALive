package com.zcl.alive.ui.activitys;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.TextView;


import com.zcl.alive.R;
import com.zcl.alive.base.BaseMvpActivity;
import com.zcl.alive.base.SwipeBackActivity;
import com.zcl.alive.model.bean.NewsInfo;
import com.zcl.alive.presenter.NewsInfoPresenter;
import com.zcl.alive.presenter.contract.NewsInfoContract;
import com.zcl.alive.widget.theme.ColorTextView;

import butterknife.BindView;

public class NewsInfoActivity extends SwipeBackActivity<NewsInfoPresenter> implements NewsInfoContract.View{

    @BindView(R.id.title_name)
    ColorTextView titleName;
    @BindView(R.id.webView_news)
    WebView webView;

    NewsInfo newsInfo;
    private Animation animation;
    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_news_info;
    }

    @Override
    protected void getIntentData() {
        newsInfo = (NewsInfo)getIntent().getSerializableExtra("newsinfo");
    }

    @Override
    protected void initView() {
        webView.loadUrl(newsInfo.getUrl());
        titleName.setText(newsInfo.getTitle());
        animation = AnimationUtils.loadAnimation(mContext, R.anim.view_hand);
    }

    @Override
    public void showError(String msg) {

    }

    public static void start(Context context, NewsInfo newsInfo) {
        Intent starter = new Intent(context, NewsInfoActivity.class);
        starter.putExtra("newsinfo", newsInfo);
        context.startActivity(starter);
    }
}

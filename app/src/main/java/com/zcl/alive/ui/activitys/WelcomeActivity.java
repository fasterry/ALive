package com.zcl.alive.ui.activitys;

import android.widget.ImageView;


import com.zcl.alive.R;
import com.zcl.alive.base.BaseMvpActivity;
import com.zcl.alive.component.ImageLoader;
import com.zcl.alive.presenter.WelcomePresenter;
import com.zcl.alive.presenter.contract.WelcomeContract;
import com.zcl.alive.utils.EventUtil;
import com.zcl.alive.utils.StringUtils;

import java.util.List;

import butterknife.BindView;


public class WelcomeActivity extends BaseMvpActivity<WelcomePresenter> implements WelcomeContract.View {

    @BindView(R.id.iv_welcome_bg)
    ImageView ivWelcomeBg;

    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
        mPresenter.getWelcomeData();
    }

    @Override
    public void showError(String msg) {
        EventUtil.showToast(mContext, msg);
    }

    @Override
    public void showContent(List<String> list) {
        if (list != null) {
            int page = StringUtils.getRandomNumber(0, list.size() - 1);
            ImageLoader.load(mContext, list.get(page), ivWelcomeBg);
            ivWelcomeBg.animate().scaleX(1.12f).scaleY(1.12f).setDuration(2000).setStartDelay(100).start();
        }
    }

    @Override
    public void jumpToMain() {
        MainActivity.start(this);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }
}
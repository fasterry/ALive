package com.zcl.alive.ui.fragments;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.daprlabs.cardstack.SwipeFrameLayout;
import com.zcl.alive.R;
import com.zcl.alive.base.BaseMvpFragment;
import com.zcl.alive.model.bean.girls.GirlsInfo;
import com.zcl.alive.model.bean.girls.GirlsRes;
import com.zcl.alive.presenter.GirlsPresenter;
import com.zcl.alive.presenter.contract.GirlsContract;
import com.zcl.alive.ui.adapter.SwipeDeckAdapter;
import com.zcl.alive.utils.EventUtil;
import com.zcl.alive.utils.ScreenUtil;
import com.zcl.alive.widget.LVGhost;
import com.zcl.alive.widget.SwipeDeck;
import com.zcl.alive.widget.theme.ColorTextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class GirlsFragment extends BaseMvpFragment<GirlsPresenter> implements GirlsContract.View{
    @BindView(R.id.title_name)
    ColorTextView colorTextView;
    @BindView(R.id.swipe_deck)
    SwipeDeck swipeDeck;
    @BindView(R.id.swipeLayout)
    SwipeFrameLayout swipeLayout;
    @BindView(R.id.loading)
    LVGhost loading;
    @BindView(R.id.btn_next)
    Button btn_next;
    @BindView(R.id.tv_nomore)
    TextView tvNomore;

    private SwipeDeckAdapter adapter;
    private List<GirlsInfo> girlsInfos = new ArrayList<>();
    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void initView(LayoutInflater inflater) {
        colorTextView.setText("妹子");
        ViewGroup.LayoutParams lp = swipeDeck.getLayoutParams();
        lp.height = ScreenUtil.getScreenHeight(getContext()) / 3 * 2;
        swipeDeck.setLayoutParams(lp);
        swipeDeck.setHardwareAccelerationEnabled(true);
    }

    @Override
    protected void initEvent() {
        swipeDeck.setEventCallback(new SwipeDeck.SwipeEventCallback() {
            @Override
            public void cardSwipedLeft(int position) {

            }

            @Override
            public void cardSwipedRight(int position) {

            }

            @Override
            public void cardsDepleted() {
                swipeDeck.setVisibility(View.GONE);
            }

            @Override
            public void cardActionDown() {

            }

            @Override
            public void cardActionUp() {

            }
        });
        mPresenter.getGilrsInfo();
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_girls;
    }

    @Override
    public void showContent(GirlsRes girlsRes) {
        if (girlsRes != null) {
            girlsInfos.clear();
            girlsInfos.addAll(girlsRes.getResults());
            swipeDeck.removeAllViews();
            swipeDeck.removeAllViews();
            adapter = new SwipeDeckAdapter(girlsInfos, getContext());
            swipeDeck.setAdapter(adapter);
            tvNomore.setVisibility(View.VISIBLE);
        }
    }
    @OnClick({R.id.btn_next, R.id.tv_nomore})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
            case R.id.tv_nomore:
                nextGirls();
                break;
        }
    }
    private void nextGirls() {
        swipeDeck.setVisibility(View.VISIBLE);
        loading.setVisibility(View.VISIBLE);
        tvNomore.setVisibility(View.GONE);
        mPresenter.setNum((int)Math.random()*20);
        mPresenter.setPage((int)Math.random()*20);
        mPresenter.getGilrsInfo();
    }

    @Override
    public void refreshFaild(String msg) {
        hidLoading();
        if (!TextUtils.isEmpty(msg))
            EventUtil.showToast(mContext, msg);
    }

    @Override
    public void hidLoading() {
        loading.setVisibility(View.GONE);
    }

    @Override
    public void showError(String msg) {

    }
}

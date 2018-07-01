package com.zcl.alive.presenter.contract;


import com.zcl.alive.base.BasePresenter;
import com.zcl.alive.base.BaseView;
import com.zcl.alive.model.bean.NewsRes;
import com.zcl.alive.model.bean.VideoType;

import java.util.List;


public interface DiscovertContract {

    interface View extends BaseView {

        void showContent(NewsRes newsRes);
        void refreshFaild(String msg);

    }

    interface Presenter extends BasePresenter<View> {
        void getTopNews();
        void onRefresh();
    }
}

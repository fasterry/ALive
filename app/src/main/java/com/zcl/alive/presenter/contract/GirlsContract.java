package com.zcl.alive.presenter.contract;

import com.zcl.alive.base.BasePresenter;
import com.zcl.alive.base.BaseView;
import com.zcl.alive.model.bean.girls.GirlsRes;

public interface GirlsContract {

    interface View extends BaseView {
        void showContent(GirlsRes girlsRes);
        void refreshFaild(String msg);
        void hidLoading();

    }

    interface Presenter extends BasePresenter<View> {
        void getGilrsInfo();
        void onRefresh();
    }
}

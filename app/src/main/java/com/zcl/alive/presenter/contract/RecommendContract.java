package com.zcl.alive.presenter.contract;


import com.zcl.alive.base.BasePresenter;
import com.zcl.alive.base.BaseView;
import com.zcl.alive.model.bean.MovieRes;


/**
 * Description: RecommendContract
 * Creator: zcl
 * date: 2018-06-18
 */
public interface RecommendContract {

    interface View extends BaseView {

        void showContent(MovieRes videoRes);

        void refreshFaild(String msg);

    }

    interface Presenter extends BasePresenter<View> {
        void onRefresh();
    }
}

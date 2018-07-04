package com.zcl.alive.presenter.contract;


import com.zcl.alive.base.BasePresenter;
import com.zcl.alive.base.BaseView;
import com.zcl.alive.model.bean.movies.MoviesRes;


/**
 * Description: RecommendContract
 * Creator: zcl
 * date: 2018-06-18
 */
public interface RecommendContract {

    interface View extends BaseView {

        void showContent(MoviesRes moviesRes);

        void refreshFaild(String msg);

    }

    interface Presenter extends BasePresenter<View> {
        void onRefresh();
    }
}

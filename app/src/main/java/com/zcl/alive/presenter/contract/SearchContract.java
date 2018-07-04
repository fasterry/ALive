package com.zcl.alive.presenter.contract;

import com.zcl.alive.base.BasePresenter;
import com.zcl.alive.base.BaseView;
import com.zcl.alive.model.bean.movies.MoviesRes;
import com.zcl.alive.model.bean.news.NewsInfo;


public interface SearchContract {

    interface View extends BaseView {
        void showContent(MoviesRes moviesRes);
        void refreshFaild(String msg);
        void hidLoading();

    }

    interface Presenter extends BasePresenter<View> {

    }
}

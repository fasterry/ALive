package com.zcl.alive.presenter.contract;


import com.zcl.alive.base.BasePresenter;
import com.zcl.alive.base.BaseView;
import com.zcl.alive.model.bean.NewsRes;


public interface NewsInfoContract {

    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View> {
    }
}

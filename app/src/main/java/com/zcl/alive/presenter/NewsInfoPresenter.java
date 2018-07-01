package com.zcl.alive.presenter;

import com.zcl.alive.base.RxPresenter;
import com.zcl.alive.model.db.RealmHelper;
import com.zcl.alive.presenter.contract.MineContract;
import com.zcl.alive.presenter.contract.NewsInfoContract;

import javax.inject.Inject;


public class NewsInfoPresenter extends RxPresenter<NewsInfoContract.View> implements NewsInfoContract.Presenter {
    public static final int maxSize = 30;

    @Inject
    public NewsInfoPresenter() {
    }
}

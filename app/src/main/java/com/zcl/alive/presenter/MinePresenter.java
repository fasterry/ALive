package com.zcl.alive.presenter;

import com.zcl.alive.base.RxPresenter;
import com.zcl.alive.model.db.RealmHelper;
import com.zcl.alive.presenter.contract.MineContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class MinePresenter extends RxPresenter<MineContract.View> implements MineContract.Presenter {
    public static final int maxSize = 30;

    @Inject
    public MinePresenter() {
    }

    @Override
    public void getHistoryData() {
    }

    @Override
    public void delAllHistory() {
        RealmHelper.getInstance().deleteAllRecord();
    }

}

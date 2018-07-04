package com.zcl.alive.presenter;

import com.zcl.alive.base.RxPresenter;
import com.zcl.alive.presenter.contract.MoviesInfoContract;
import com.zcl.alive.presenter.contract.NewsInfoContract;

import javax.inject.Inject;


public class MoviesInfoPresenter extends RxPresenter<MoviesInfoContract.View> implements MoviesInfoContract.Presenter {


    @Inject
    public MoviesInfoPresenter() {
    }
}

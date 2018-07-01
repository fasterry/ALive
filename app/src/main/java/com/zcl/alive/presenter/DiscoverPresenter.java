package com.zcl.alive.presenter;

import com.zcl.alive.base.RxPresenter;
import com.zcl.alive.model.bean.MovieRes;
import com.zcl.alive.model.bean.NewsRes;
import com.zcl.alive.model.db.RealmHelper;
import com.zcl.alive.model.http.api.NewsApis;
import com.zcl.alive.model.http.response.NewsHttpResponse;
import com.zcl.alive.model.net.RetrofitHelper;
import com.zcl.alive.presenter.contract.DiscovertContract;
import com.zcl.alive.presenter.contract.MineContract;
import com.zcl.alive.utils.RxUtil;
import com.zcl.alive.utils.StringUtils;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


public class DiscoverPresenter extends RxPresenter<DiscovertContract.View> implements DiscovertContract.Presenter {
    public static final int maxSize = 30;

    @Inject
    public DiscoverPresenter() {
    }

    @Override
    public void onRefresh(){
        getTopNews();
    }
    @Override
    public void getTopNews() {
        Disposable rxSubscription = RetrofitHelper.getNewsApis().getTypeNews("top",NewsApis.APPKEY)
                .compose(RxUtil.<NewsHttpResponse<NewsRes>>rxSchedulerHelper())
                .compose(RxUtil.<NewsRes> handleNewsResult())
                .subscribe(new Consumer<NewsRes>() {
                    @Override
                    public void accept(final NewsRes res) {
                        if (res != null) {
                            mView.showContent(res);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        mView.refreshFaild(StringUtils.getErrorMsg(throwable.getMessage()));
                    }
                });
        addSubscribe(rxSubscription);
    }

}

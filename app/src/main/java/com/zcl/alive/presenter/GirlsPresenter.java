package com.zcl.alive.presenter;

import com.zcl.alive.base.RxPresenter;
import com.zcl.alive.model.bean.girls.GirlsRes;
import com.zcl.alive.model.net.RetrofitHelper;
import com.zcl.alive.presenter.contract.GirlsContract;
import com.zcl.alive.utils.RxUtil;
import com.zcl.alive.utils.StringUtils;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


public class GirlsPresenter extends RxPresenter<GirlsContract.View> implements GirlsContract.Presenter {

    // num <=20
    private int num = 10;

    //page <=30
    private int page =2 ;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Inject
    public GirlsPresenter() {
    }


    @Override
    public void getGilrsInfo() {
        getNextGirlsInfo();
    }

    private void getNextGirlsInfo(){
        Disposable rxSubscription =  RetrofitHelper.getGilsApi().getGilsInfo(num,page)
                .compose(RxUtil.<GirlsRes>rxSchedulerHelper())
                .compose(RxUtil.<GirlsRes> handleGirlsResult())
                .subscribe(new Consumer<GirlsRes>() {
                               @Override
                               public void accept(final GirlsRes res) {
                                   if (res != null) {
                                       mView.showContent(res);
                                   }
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) {

                                   mView.refreshFaild(StringUtils.getErrorMsg(throwable.getMessage()));
                               }
                           }, new Action() {
                               @Override
                               public void run() {
                                   mView.hidLoading();
                               }
                           }
                );

        addSubscribe(rxSubscription);
    }

    @Override
    public void onRefresh() {

    }
}

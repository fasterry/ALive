package com.zcl.alive.presenter;



import com.zcl.alive.base.RxPresenter;
import com.zcl.alive.model.bean.movies.MoviesRes;
import com.zcl.alive.model.net.RetrofitHelper;
import com.zcl.alive.presenter.contract.RecommendContract;
import com.zcl.alive.utils.RxUtil;
import com.zcl.alive.utils.StringUtils;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Description: RecommendPresenter
 * Creator: yxc
 * date: 2016/9/21 16:26
 */
public class RecommendPresenter extends RxPresenter<RecommendContract.View> implements RecommendContract.Presenter {

    int page = 0;

    @Inject
    public RecommendPresenter() {
    }

    @Override
    public void onRefresh() {
        page = 0;
        getTopMovies();
    }

    private void getTopMovies() {
        Disposable rxSubscription = RetrofitHelper.getMoviesApis().getTopMovies()
                .compose(RxUtil.<MoviesRes> rxSchedulerHelper())
                .compose(RxUtil.<MoviesRes>handleMoviesResult())
                .subscribe(new Consumer<MoviesRes>() {
                    @Override
                    public void accept(final MoviesRes res) {
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



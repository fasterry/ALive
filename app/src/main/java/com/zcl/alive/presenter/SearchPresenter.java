package com.zcl.alive.presenter;

import com.zcl.alive.base.RxPresenter;
import com.zcl.alive.model.bean.movies.MoviesRes;
import com.zcl.alive.model.net.RetrofitHelper;
import com.zcl.alive.presenter.contract.SearchContract;
import com.zcl.alive.utils.RxUtil;
import com.zcl.alive.utils.StringUtils;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;


public class SearchPresenter extends RxPresenter<SearchContract.View> implements SearchContract.Presenter {
    private String keyword ="";

    @Inject
    public SearchPresenter() {
    }

    public void onRefresh(){
        getSearchMovies();
    }

    public void setSearchKey(String keyword) {
        this.keyword = keyword;
    }
    private void getSearchMovies() {
        Disposable disposable = RetrofitHelper.getMoviesApis().getSearchMovies(keyword)
                .compose(RxUtil.<MoviesRes>rxSchedulerHelper())
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
        addSubscribe(disposable);
    }
}

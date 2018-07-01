package com.zcl.alive.utils;

import android.text.TextUtils;

import com.zcl.alive.model.bean.MovieRes;
import com.zcl.alive.model.bean.NewsRes;
import com.zcl.alive.model.http.exception.ApiException;
import com.zcl.alive.model.http.response.NewsHttpResponse;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxUtil {
    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return new ObservableTransformer<T, T>() {
            @Override
            public Observable<T> apply(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<MovieRes, T> handleResult() {   //compose判断结果
        return new ObservableTransformer<MovieRes, T>() {
            @Override
            public Observable<T> apply(Observable<MovieRes> movieResObservable) {
                return movieResObservable.flatMap(new Function<MovieRes, Observable<T>>() {
                    @Override
                    public Observable<T> apply(MovieRes movieRes) throws Exception{
                        if (movieRes.getTotal() == 250) {
                            return (Observable<T>) createData(movieRes);
                        } else if (!TextUtils.isEmpty(movieRes.getCount()+"")) {
                            return Observable.error(new ApiException("*" + movieRes.getTitle()));
                        } else {
                            return Observable.error(new ApiException("*" + "服务器返回error"));
                        }
                    }
                });
            }
        };
    }
    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
    public static <T> ObservableTransformer<NewsHttpResponse<T>, T> handleNewsResult() {   //compose判断结果
        return new ObservableTransformer<NewsHttpResponse<T>, T>() {
            @Override
            public Observable<T> apply(Observable<NewsHttpResponse<T>> newsResObservable) {
                return newsResObservable.flatMap(new Function<NewsHttpResponse<T>, Observable<T>>() {
                    @Override
                    public Observable<T> apply(NewsHttpResponse<T> newsHttpResponse) throws Exception{
                        if (newsHttpResponse.getCode() == 0) {
                            return (createData(newsHttpResponse.getResult()));
                        } else if (!TextUtils.isEmpty(newsHttpResponse.getReason())) {
                            return Observable.error(new ApiException("*" + newsHttpResponse.getReason()));
                        } else {
                            return Observable.error(new ApiException("*" + "服务器返回error"));
                        }
                    }
                });
            }
        };
    }
    /**
     * 生成Observable
     *
     * @param <T>
     * @return
     */
    public static <T> Observable<T> createData(final T t) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> subscriber) throws Exception {
                try {
                    subscriber.onNext(t);
                    subscriber.onComplete();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}


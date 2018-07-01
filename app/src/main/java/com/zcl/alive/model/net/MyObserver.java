package com.zcl.alive.model.net;

import com.zcl.alive.model.http.exception.ApiException;

import io.reactivex.Observer;

/**
 * Created by 12262 on 2016/5/30.
 */
public abstract class MyObserver<T> implements Observer<T> {

   /* @Override
    public void onError(Throwable e) {
//        e.printStackTrace();
        if (e instanceof ApiException) {
            onError((ApiException) e);
        } else {
            onError(new ApiException(e, 123));
        }
    }

    /**
     * 错误回调
     */
   protected abstract void onError(ApiException ex);
}

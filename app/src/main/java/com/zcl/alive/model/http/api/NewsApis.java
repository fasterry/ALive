package com.zcl.alive.model.http.api;

import com.zcl.alive.model.bean.MovieRes;
import com.zcl.alive.model.bean.NewsRes;
import com.zcl.alive.model.http.response.NewsHttpResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NewsApis {
    String HOST ="http://v.juhe.cn/";
    String APPKEY ="323f62e0ac62f8120c0d85e2cbbc9861";


    //类型,,top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
    @GET("toutiao/index")
    Observable<NewsHttpResponse<NewsRes>> getTypeNews(@Query("type")String type,@Query("key")String key);
}

package com.zcl.alive.model.http.api;

import com.zcl.alive.model.bean.girls.GirlsRes;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GilsApi {
    String HOST = "http://gank.io/api/";

    @GET("data/福利/{num}/{page}")
    Observable<GirlsRes> getGilsInfo(@Path("num") int num,@Path("page") int page );
}

package com.zcl.alive.model.http.api;

import com.zcl.alive.model.bean.MovieRes;


import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MoviesApis {
    String HOST ="http://api.douban.com/";

    @GET("v2/movie/top250")
    Observable<MovieRes> getTopMovies();
}

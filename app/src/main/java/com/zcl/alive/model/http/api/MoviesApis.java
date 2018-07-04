package com.zcl.alive.model.http.api;

import com.zcl.alive.model.bean.movies.MoviesRes;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesApis {
    String HOST ="http://api.douban.com/";

    @GET("v2/movie/top250")
    Observable<MoviesRes> getTopMovies();

    @GET("v2/movie/search")
    Observable<MoviesRes> getSearchMovies(@Query("q") String keyword);
}

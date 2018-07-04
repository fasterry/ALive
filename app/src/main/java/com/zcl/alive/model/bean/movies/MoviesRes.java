package com.zcl.alive.model.bean.movies;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesRes {
    int count;
    int start;
    int total;
    String title;

    @SerializedName("subjects")
    List<MovieInfo> movieInfoList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MovieInfo> getMovieInfoList() {
        return movieInfoList;
    }

    public void setMovieInfoList(List<MovieInfo> movieInfoList) {
        this.movieInfoList = movieInfoList;
    }
}

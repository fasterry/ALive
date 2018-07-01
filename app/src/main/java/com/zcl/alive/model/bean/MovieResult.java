package com.zcl.alive.model.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResult {
    private int code;
    private int total;
    private String title;
    private String msg;
    public
    @SerializedName("subjects")
    List<MovieRes> ret;
}

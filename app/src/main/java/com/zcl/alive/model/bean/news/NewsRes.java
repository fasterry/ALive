package com.zcl.alive.model.bean.news;

import com.google.gson.annotations.SerializedName;
import com.zcl.alive.model.bean.news.NewsInfo;

import java.util.List;

public class NewsRes {

    @SerializedName("data")
    private List<NewsInfo> data;

    public List<NewsInfo> getData() {
        return data;
    }

    public void setData(List<NewsInfo> data) {
        this.data = data;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    private String stat;
}

package com.zcl.alive.model.bean.news;

import com.google.gson.annotations.SerializedName;

public class NewsHttpResponse<T> {
    private String reason;
    @SerializedName("error_code")
    private int code;
    private T result;
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }



}

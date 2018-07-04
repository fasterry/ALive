package com.zcl.alive.model.bean;

import io.realm.RealmObject;



public class SearchKey extends RealmObject {
    public String searchKey;
    public long insertTime;

    public SearchKey() {
    }

    public SearchKey(String searchKey, long insertTime) {
        this.searchKey = searchKey;
        this.insertTime = insertTime;
    }

    public String getSearchKey() {
        return searchKey;
    }
}

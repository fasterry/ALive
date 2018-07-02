package com.zcl.alive.model;




import com.zcl.alive.model.bean.Collection;
import com.zcl.alive.model.bean.Record;
import com.zcl.alive.model.bean.SearchKey;
import com.zcl.alive.model.db.DBHelper;
import com.zcl.alive.model.http.HttpHelper;

import java.util.List;

import io.realm.Realm;


/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @desciption:
 */

public class DataManager implements HttpHelper, DBHelper {

    HttpHelper mHttpHelper;
    DBHelper mDbHelper;

    public DataManager(HttpHelper httpHelper, DBHelper dbHelper) {
        mHttpHelper = httpHelper;
        mDbHelper = dbHelper;
    }


    @Override
    public Realm getRealm() {
        return mDbHelper.getRealm();
    }

    @Override
    public void insertCollection(Collection bean) {
        mDbHelper.insertCollection(bean);
    }

    @Override
    public void deleteCollection(String id) {
        mDbHelper.deleteCollection(id);
    }

    @Override
    public void deleteAllCollection() {
        mDbHelper.deleteAllCollection();
    }

    @Override
    public boolean queryCollectionId(String id) {
        return mDbHelper.queryCollectionId(id);
    }

    @Override
    public List<Collection> getCollectionList() {
        return mDbHelper.getCollectionList();
    }

    @Override
    public void insertRecord(Record bean, int maxSize) {
        mDbHelper.insertRecord(bean, maxSize);
    }

    @Override
    public void deleteRecord(String id) {
        mDbHelper.deleteRecord(id);
    }

    @Override
    public boolean queryRecordId(String id) {
        return mDbHelper.queryRecordId(id);
    }

    @Override
    public List<Record> getRecordList() {
        return mDbHelper.getRecordList();
    }

    @Override
    public void deleteAllRecord() {
        mDbHelper.deleteAllRecord();
    }

    @Override
    public void insertSearchHistory(SearchKey bean) {
        mDbHelper.insertSearchHistory(bean);
    }

    @Override
    public List<SearchKey> getSearchHistoryList(String value) {
        return mDbHelper.getSearchHistoryList(value);
    }

    @Override
    public void deleteSearchHistoryList(String value) {
        mDbHelper.deleteSearchHistoryList(value);
    }

    @Override
    public void deleteSearchHistoryAll() {
        mDbHelper.deleteSearchHistoryAll();
    }

    @Override
    public List<SearchKey> getSearchHistoryListAll() {
        return mDbHelper.getSearchHistoryListAll();
    }


}

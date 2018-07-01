package com.zcl.alive.di.component;




import com.zcl.alive.app.App;
import com.zcl.alive.di.module.AppModule;
import com.zcl.alive.di.module.HttpModule;
import com.zcl.alive.model.DataManager;
import com.zcl.alive.model.db.RealmHelper;
import com.zcl.alive.model.http.RetrofitHelper1;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    App getContext();  // 提供App的Context

    DataManager getDataManager(); //数据中心

    RetrofitHelper1 retrofitHelper();  //提供http的帮助类

    RealmHelper realmHelper();    //提供数据库帮助类

}

package com.zcl.alive.di.component;




import com.zcl.alive.app.App;
import com.zcl.alive.di.module.AppModule;
import com.zcl.alive.di.module.HttpModule;
import com.zcl.alive.model.db.RealmHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by codeest on 16/8/7.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    App getContext();  // 提供App的Context


    RealmHelper realmHelper();    //提供数据库帮助类

}

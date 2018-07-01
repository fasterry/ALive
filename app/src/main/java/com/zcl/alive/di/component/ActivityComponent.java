package com.zcl.alive.di.component;

import android.app.Activity;

import com.zcl.alive.di.module.ActivityModule;
import com.zcl.alive.di.scope.ActivityScope;
import com.zcl.alive.ui.activitys.NewsInfoActivity;
import com.zcl.alive.ui.activitys.WelcomeActivity;


import dagger.Component;

/**
 * Description:
 * Creator: yxc
 * date: $date $time
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {
    Activity getActivity();
    void inject(WelcomeActivity welcomeActivity);
    void inject(NewsInfoActivity newsInfoActivity);

}

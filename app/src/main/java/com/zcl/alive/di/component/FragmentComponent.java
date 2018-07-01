package com.zcl.alive.di.component;

import android.app.Activity;


import com.zcl.alive.di.module.FragmentModule;
import com.zcl.alive.di.scope.FragmentScope;
import com.zcl.alive.ui.fragments.ClassificationFragment;
import com.zcl.alive.ui.fragments.DiscoverFragment;
import com.zcl.alive.ui.fragments.MineFragment;
import com.zcl.alive.ui.fragments.RecommendFragment;

import dagger.Component;

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();
    void inject(RecommendFragment recommendFragment);

    void inject(MineFragment mineFragment);
    void inject(DiscoverFragment discoverFragment);

    void inject(ClassificationFragment dailyFragment);



}

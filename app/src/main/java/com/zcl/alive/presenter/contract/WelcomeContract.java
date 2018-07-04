package com.zcl.alive.presenter.contract;




import com.zcl.alive.base.BasePresenter;
import com.zcl.alive.base.BaseView;

import java.util.List;


public interface WelcomeContract {

    interface View extends BaseView {

        void showContent(List<String> list);

        void jumpToMain();
    }

    interface Presenter extends BasePresenter<View> {
        void getWelcomeData();
    }
}

package com.zcl.alive.presenter.contract;


import com.zcl.alive.base.BasePresenter;
import com.zcl.alive.base.BaseView;
import com.zcl.alive.model.bean.VideoType;


import java.util.List;

/**
 * Description: CollectionContract
 * Creator: cp
 * date: 2016/9/29 12:19
 */
public interface MineContract {

    interface View extends BaseView {

        void showContent(List<VideoType> list);

    }

    interface Presenter extends BasePresenter<View> {
        void getHistoryData();

        void delAllHistory();
    }
}

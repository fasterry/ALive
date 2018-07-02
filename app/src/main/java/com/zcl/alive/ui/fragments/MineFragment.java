package com.zcl.alive.ui.fragments;




import com.zcl.alive.R;
import com.zcl.alive.base.BaseMvpFragment;
import com.zcl.alive.presenter.MinePresenter;
import com.zcl.alive.presenter.contract.MineContract;

/**
 * Description:
 * Creator: yxc
 * date: $date $time
 */
public class MineFragment extends BaseMvpFragment<MinePresenter> implements MineContract.View {

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError(String msg) {

    }
}
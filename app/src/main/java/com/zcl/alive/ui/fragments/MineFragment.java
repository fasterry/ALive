package com.zcl.alive.ui.fragments;




import android.view.LayoutInflater;

import com.zcl.alive.R;
import com.zcl.alive.base.BaseMvpFragment;
import com.zcl.alive.presenter.MinePresenter;
import com.zcl.alive.presenter.contract.MineContract;
import com.zcl.alive.widget.theme.ColorTextView;

import butterknife.BindView;

/**
 * Description:
 * Creator: yxc
 * date: $date $time
 */
public class MineFragment extends BaseMvpFragment<MinePresenter> implements MineContract.View {
    @BindView(R.id.title_name)
    ColorTextView titleName;

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
    protected void initView(LayoutInflater inflater) {
        titleName.setText(R.string.person_center);
    }

    @Override
    public void showError(String msg) {

    }
}
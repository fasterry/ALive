package com.zcl.alive.ui.fragments;


import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;
import com.zcl.alive.R;
import com.zcl.alive.base.BaseMvpFragment;
import com.zcl.alive.presenter.MinePresenter;
import com.zcl.alive.presenter.contract.MineContract;
import com.zcl.alive.ui.activitys.SettingActivity;
import com.zcl.alive.utils.EventUtil;
import com.zcl.alive.utils.ThemeUtils;
import com.zcl.alive.widget.theme.ColorTextView;

import butterknife.BindView;
import butterknife.OnClick;


public class MineFragment extends BaseMvpFragment<MinePresenter> implements MineContract.View, View.OnClickListener {

    @BindView(R.id.title_name)
    ColorTextView titleName;

    @BindView(R.id.rl_settings)
    RelativeLayout rlSettings;

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
    protected void initEvent() {
        rlSettings.setOnClickListener(this);
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_settings:
                mContext.startActivity(new Intent(mContext, SettingActivity.class));
                break;
        }
    }
}
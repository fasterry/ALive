package com.zcl.alive.ui.activitys;

import android.content.ClipboardManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;
import com.zcl.alive.R;
import com.zcl.alive.base.SwipeBackActivity;
import com.zcl.alive.widget.theme.ColorTextView;


import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description: 设置
 * Creator: yxc
 * date: 2017/9/6 14:57
 */
public class SettingActivity extends SwipeBackActivity {
    @BindView(R.id.title_name)
    ColorTextView titleName;
    @Override
    protected int getLayout() {
        return R.layout.activity_settings;
    }


    @Override
    protected void initInject() {

    }

    @Override
    protected void initView() {
        titleName.setText(R.string.setting);
    }

    @Override
    public void showError(String msg) {

    }
}

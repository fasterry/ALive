package com.zcl.alive.ui.activitys;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
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
import com.zcl.alive.utils.EventUtil;
import com.zcl.alive.utils.ThemeUtils;
import com.zcl.alive.widget.theme.ColorTextView;


import butterknife.BindView;
import butterknife.OnClick;


public class SettingActivity extends SwipeBackActivity implements View.OnClickListener {
    @BindView(R.id.rl_recommend)
    RelativeLayout rlRecommend;
    @BindView(R.id.rl_about)
    RelativeLayout rlAbout;
    @BindView(R.id.rl_feedback)
    RelativeLayout rlFeedback;
    @BindView(R.id.title_name)
    ColorTextView titleName;
    @BindView(R.id.tv_cache)
    TextView tvCache;
    @BindView(R.id.rl_clearcache)
    RelativeLayout rlClearCache;

    @Override
    protected int getLayout() {
        return R.layout.activity_settings;
    }


    @Override
    protected void initInject() {

    }

    @Override
    protected void initEvent() {
        rlRecommend.setOnClickListener(this);
        rlAbout.setOnClickListener(this);
        rlFeedback.setOnClickListener(this);
        rlClearCache.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        titleName.setText(R.string.setting);
        tvCache.setText(EventUtil.getFormatSize(Glide.getPhotoCacheDir(this).length()));
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_recommend:
                new MaterialDialog.Builder(this)
                        .content(R.string.setting_recommend_content)
                        .contentColor(ThemeUtils.getThemeColor(this, R.attr.colorPrimary))
                        .positiveText(R.string.close)
                        .negativeText(R.string.setting_recommend_copy).onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        ClipboardManager cmb = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clipData = ClipData.newPlainText(null,R.string.setting_recommend_url+"");
                        cmb.setPrimaryClip(clipData);
                        EventUtil.showToast(SettingActivity.this, "已复制到粘贴板");
                    }
                }).show();
                break;
            case R.id.rl_about:
                new MaterialDialog.Builder(this)
                        .title(R.string.about)
                        .titleColor(ThemeUtils.getThemeColor(this, R.attr.colorPrimary))
                        .icon(new IconicsDrawable(this)
                                .color(ThemeUtils.getThemeColor(this, R.attr.colorPrimary))
                                .icon(MaterialDesignIconic.Icon.gmi_account)
                                .sizeDp(20))
                        .content(R.string.about_me)
                        .contentColor(ThemeUtils.getThemeColor(this, R.attr.colorPrimary))
                        .positiveText(R.string.close)
                        .show();
                break;
            case R.id.rl_feedback:
//                PgyerDialog.setDialogTitleBackgroundColor(PreUtils.getString(this, Constants.PRIMARYCOLOR, "#000000"));
//                PgyerDialog.setDialogTitleTextColor(PreUtils.getString(this, Constants.TITLECOLOR, "#0aa485"));
//                PgyFeedback.getInstance().showDialog(this);
//                PgyFeedback.getInstance().showDialog(this).d().setChecked(false);
                break;
            case R.id.rl_clearcache:
                tvCache.setText("0kb");
                clearImageDiskCache(this);
                clearImageMemoryCache(this);
                EventUtil.showToast(this, "已清理缓存");
                break;
        }
    }

    /**
     * 清除图片磁盘缓存
     */
    public void clearImageDiskCache(final Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.get(context).clearDiskCache();

                    }
                }).start();
            } else {
                Glide.get(context).clearDiskCache();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 清除图片内存缓存
     */
    public void clearImageMemoryCache(Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) { //只能在主线程执行
                Glide.get(context).clearMemory();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

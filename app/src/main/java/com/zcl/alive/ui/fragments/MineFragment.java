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

/**
 * Description:
 * Creator: yxc
 * date: $date $time
 */
public class MineFragment extends BaseMvpFragment<MinePresenter> implements MineContract.View,View.OnClickListener {
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
        tvCache.setText(EventUtil.getFormatSize(Glide.getPhotoCacheDir(getActivity()).length()));
    }

    @Override
    protected void initEvent() {
        rlRecommend.setOnClickListener(this);
        rlAbout.setOnClickListener(this);
        rlFeedback.setOnClickListener(this);
        rlClearCache.setOnClickListener(this);
        rlSettings.setOnClickListener(this);
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_recommend:
                new MaterialDialog.Builder(getActivity())
                        .content(R.string.setting_recommend_content)
                        .contentColor(ThemeUtils.getThemeColor(getActivity(), R.attr.colorPrimary))
                        .positiveText(R.string.close)
                        .negativeText(R.string.setting_recommend_copy).onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        ClipboardManager cmb = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                        cmb.setText(getResources().getString(R.string.setting_recommend_url));
                         EventUtil.showToast(getActivity(), "已复制到粘贴板");
                    }
                }).show();
                break;
            case R.id.rl_about:
                new MaterialDialog.Builder(getActivity())
                        .title(R.string.about)
                        .titleColor(ThemeUtils.getThemeColor(getActivity(), R.attr.colorPrimary))
                        .icon(new IconicsDrawable(getActivity())
                                .color(ThemeUtils.getThemeColor(getActivity(), R.attr.colorPrimary))
                                .icon(MaterialDesignIconic.Icon.gmi_account)
                                .sizeDp(20))
                        .content(R.string.about_me)
                        .contentColor(ThemeUtils.getThemeColor(getActivity(), R.attr.colorPrimary))
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
                EventUtil.showToast(getActivity(), "已清理缓存");
                break;
            case R.id.rl_settings:
                mContext.startActivity(new Intent(mContext,SettingActivity.class));
                break;
        }
    }
}
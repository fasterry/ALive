package com.zcl.alive.base;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;


import com.orhanobut.logger.Logger;
import com.zcl.alive.R;
import com.zcl.alive.app.App;
import com.zcl.alive.di.component.ActivityComponent;
import com.zcl.alive.di.component.DaggerActivityComponent;
import com.zcl.alive.di.module.ActivityModule;
import com.zcl.alive.utils.PreUtils;
import com.zcl.alive.utils.ScreenUtil;
import com.zcl.alive.widget.theme.ColorRelativeLayout;
import com.zcl.alive.widget.theme.Theme;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;


public abstract class BaseActivity extends SupportActivity {

    protected Activity mContext;
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.t(this.getClass().getName()).d("->onCreate");
        init();

        setContentView(getLayout());
        getIntentData();
        mContext = this;
        mUnBinder = ButterKnife.bind(this);
        initView();
        initEvent();
    }

    protected void init() {
        setTranslucentStatus(true);
        onPreCreate();
        App.getInstance().registerActivity(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.t(this.getClass().getName()).d("->onStart");
        setTitleHeight(getRootView(this));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.t(this.getClass().getName()).d("->onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.t(this.getClass().getName()).d("->onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.t(this.getClass().getName()).d("->onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.t(this.getClass().getName()).d("->onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.t(this.getClass().getName()).d("->onDestroy");
        if (mUnBinder != null)
            mUnBinder.unbind();
        App.getInstance().unregisterActivity(this);
    }

    private void onPreCreate() {
        Theme theme = PreUtils.getCurrentTheme(this);
        switch (theme) {
            case Blue:
                setTheme(R.style.BlueTheme);
                break;
            case Red:
                setTheme(R.style.RedTheme);
                break;
            case Brown:
                setTheme(R.style.BrownTheme);
                break;
            case Green:
                setTheme(R.style.GreenTheme);
                break;
            case Purple:
                setTheme(R.style.PurpleTheme);
                break;
            case Teal:
                setTheme(R.style.TealTheme);
                break;
            case Pink:
                setTheme(R.style.PinkTheme);
                break;
            case DeepPurple:
                setTheme(R.style.DeepPurpleTheme);
                break;
            case Orange:
                setTheme(R.style.OrangeTheme);
                break;
            case Indigo:
                setTheme(R.style.IndigoTheme);
                break;
            case LightGreen:
                setTheme(R.style.LightGreenTheme);
                break;
            case Lime:
                setTheme(R.style.LimeTheme);
                break;
            case DeepOrange:
                setTheme(R.style.DeepOrangeTheme);
                break;
            case Cyan:
                setTheme(R.style.CyanTheme);
                break;
            case BlueGrey:
                setTheme(R.style.BlueGreyTheme);
                break;
            case Black:
                setTheme(R.style.BlackTheme);
                break;
        }

    }

    /**
     * 设置沉浸式
     *
     * @param on
     */
    protected void setTranslucentStatus(boolean on) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }
    }

    private void setTitleHeight(View view) {
        if (view != null) {
            ColorRelativeLayout title = (ColorRelativeLayout) view.findViewById(R.id.title);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                if (title != null) {
                    ViewGroup.LayoutParams lp = title.getLayoutParams();
                   lp.height = ScreenUtil.dip2px(this, 48);
                    title.setLayoutParams(lp);
                    title.setPadding(0, 0, 0, 0);
                }
            }
        }
    }

    protected static View getRootView(Activity context) {
        return ((ViewGroup) context.findViewById(android.R.id.content)).getChildAt(0);
    }


    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
    protected abstract int getLayout();

    protected void initView() {
    }

    protected void initEvent() {
    }

    protected void getIntentData() {
    }
}

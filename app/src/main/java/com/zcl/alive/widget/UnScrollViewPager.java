package com.zcl.alive.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Scroller;

import com.orhanobut.logger.Logger;



public class UnScrollViewPager extends ViewPager {

    private boolean isScrollable = false;
    private Context mContext;

    public UnScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UnScrollViewPager(Context context) {
        super(context);
        this.mContext = context;
        Scroller scroller = new Scroller(mContext);

    }

    public void setScrollable(boolean scrollable) {
        isScrollable = scrollable;
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        if (isScrollable)
            return super.onTouchEvent(arg0);
        boolean b = super.onTouchEvent(arg0);
        Logger.e(this.getClass().getName()+"onTouchEvent" + b);
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (isScrollable)
            return super.onInterceptTouchEvent(arg0);
        return false;
    }
}
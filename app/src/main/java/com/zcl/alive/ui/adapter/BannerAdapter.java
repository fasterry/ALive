package com.zcl.alive.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.zcl.alive.R;
import com.zcl.alive.component.ImageLoader;
import com.zcl.alive.model.bean.MovieRes;



import java.util.List;


public class BannerAdapter extends StaticPagerAdapter {

    private Context ctx;
    private List<MovieRes.Subjects> list;

    private int[] image = {R.mipmap.banner_one, R.mipmap.banner_two, R.mipmap.banner_three, R.mipmap.banner_four};

    public BannerAdapter(Context ctx, List<MovieRes.Subjects> list) {
        this.ctx = ctx;
        this.list = list;
    }



    @Override
    public View getView(ViewGroup container, final int position) {
        ImageView imageView = new ImageView(ctx);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setBackgroundResource(R.mipmap.default_320);
        imageView.setImageResource(image[position]);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return imageView;
    }

    @Override
    public int getCount() {
        return image.length;
    }
}
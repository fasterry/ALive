package com.zcl.alive.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.zcl.alive.R;
import com.zcl.alive.component.ImageLoader;
import com.zcl.alive.model.bean.MovieRes;


/**
 * Description: 推荐
 * Creator: yxc
 * date: 2016/9/30 11:10
 */
public class RecommendAdapter extends RecyclerArrayAdapter<MovieRes.Subjects> {

    public RecommendAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecommendViewHolder(parent);
    }

    class RecommendViewHolder extends BaseViewHolder<MovieRes.Subjects> {
        ImageView imgPicture;
        TextView tv_title;

        public RecommendViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_movie);
            imgPicture = $(R.id.img_video);
            tv_title = $(R.id.tv_title);
            imgPicture.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        @Override
        public void setData(MovieRes.Subjects data) {
            tv_title.setText(data.getTitle());
            ImageLoader.load(getContext(), data.getImages().getLarge(), imgPicture);
        }
    }
}

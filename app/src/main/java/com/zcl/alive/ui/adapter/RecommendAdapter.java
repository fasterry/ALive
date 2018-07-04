package com.zcl.alive.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.zcl.alive.R;
import com.zcl.alive.component.ImageLoader;
import com.zcl.alive.model.bean.movies.MovieInfo;


/**
 * Description: 推荐
 * Creator: yxc
 * date: 2016/9/30 11:10
 */
public class RecommendAdapter extends RecyclerArrayAdapter<MovieInfo> {

    public RecommendAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecommendViewHolder(parent);
    }

    class RecommendViewHolder extends BaseViewHolder<MovieInfo> {
        ImageView imgPicture;
        TextView tv_title;
        TextView tv_director;
        TextView tv_screenwriter;
        TextView tv_actor;
        TextView tv_region;
        TextView tv_language;
        TextView tv_date;
        TextView tv_time;

        public RecommendViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_movie);
            imgPicture = $(R.id.img_video);
            tv_title = $(R.id.tv_title);
            tv_director = $(R.id.tv_director);
            tv_screenwriter = $(R.id.tv_screenwriter);
            tv_actor = $(R.id.tv_actor);
            tv_date = $(R.id.tv_date);

            imgPicture.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        @Override
        public void setData(MovieInfo data) {
            tv_title.setText("片名："+data.getTitle());
            tv_director.setText("导演： " + data.getDirectors().get(0).getName());
            tv_screenwriter.setText("评分：" + data.getRating().getAverage()+"");
            tv_actor.setText("主演：" +data.getCasts().get(0).getName());
            tv_date.setText("年份：" +data.getYear());
            ImageLoader.load(getContext(), data.getImages().getMedium(), imgPicture);
        }
    }
}

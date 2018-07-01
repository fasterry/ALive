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
import com.zcl.alive.model.bean.NewsInfo;
import com.zcl.alive.model.bean.NewsRes;


/**
 * Description: 推荐
 * Creator: yxc
 * date: 2016/9/30 11:10
 */
public class DiscoverAdapter extends RecyclerArrayAdapter<NewsInfo> {

    public DiscoverAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new DiscoverViewHolder(parent);
    }

    class DiscoverViewHolder extends BaseViewHolder<NewsInfo> {
        ImageView imgPicture;
        TextView tv_title;

        public DiscoverViewHolder(ViewGroup parent) {
            super(parent, R.layout.item_news);
            imgPicture = $(R.id.img_news);
            tv_title = $(R.id.tv_title);
            imgPicture.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        @Override
        public void setData(NewsInfo data) {
            tv_title.setText(data.getTitle());
            ImageLoader.load(getContext(), data.getThumbnail_pic_s(), imgPicture);
        }
    }

}

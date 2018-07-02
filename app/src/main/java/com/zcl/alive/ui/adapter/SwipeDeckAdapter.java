package com.zcl.alive.ui.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.zcl.alive.R;
import com.zcl.alive.component.ImageLoader;
import com.zcl.alive.model.bean.girls.GirlsInfo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SwipeDeckAdapter extends BaseAdapter {

    private List<GirlsInfo> data;
    private Context context;
    private LayoutInflater inflater;
    private GirlsInfo girlsInfo;

    public SwipeDeckAdapter(List<GirlsInfo> data, Context context) {
        this.data = data;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void refresh(List<GirlsInfo> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.girls_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ImageLoader.load(context, data.get(position).getUrl(), holder.offerImage);
        String intro = "\t\t\t" + data.get(position).getPublishedAt();
        holder.tvIntroduction.setText("");
        holder.tv_title.setText("你来自天空");

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchData(data.get(position));
              //  VideoInfoActivity.start(context, videoInfo);
            }
        });
        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.offer_image)
        RoundedImageView offerImage;
        @BindView(R.id.tv_introduction)
        TextView tvIntroduction;
        @BindView(R.id.card_view)
        CardView cardView;
        @BindView(R.id.tv_title)
        TextView tv_title;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    private void switchData(GirlsInfo girls) {
        if (girlsInfo == null)
            girlsInfo = new GirlsInfo();
        girlsInfo.setCreatedAt(girls.getCreatedAt());
        girlsInfo.setUrl(girls.getUrl());
    }

}
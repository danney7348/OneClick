package com.example.zsd.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dou361.ijkplayer.widget.IjkVideoView;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.example.zsd.R;
import com.example.zsd.entity.GetHotVideos;

import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/12/5.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class MyShipinRemenAdapter extends RecyclerView.Adapter<MyShipinRemenAdapter.ViewHolder>{


    private Activity context;
    private List<GetHotVideos.DataBean> list;

    public MyShipinRemenAdapter(Activity context, List<GetHotVideos.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.shipin_remen_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        /*String s = list.get(position).videoUrl.replaceAll("https://www.zhaoapi.cn", "http://120.27.23.105");
        View player = View.inflate(context, R.layout.simple_player_view_player, holder.ivv);
        PlayerView playerView = new PlayerView(context,player)
                .setTitle(list.get(position).workDesc)
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource(s)
                .startPlay();*/
        Glide.with(context).load(list.get(position).cover).into(holder.cover);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView cover;

        public ViewHolder(View itemView) {
            super(itemView);
            cover = itemView.findViewById(R.id.shipin_iv_cover);
        }
    }
}

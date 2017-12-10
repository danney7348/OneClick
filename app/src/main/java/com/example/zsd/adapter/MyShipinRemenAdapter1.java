package com.example.zsd.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.IjkVideoView;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.example.zsd.R;
import com.example.zsd.activity.ShipinXiangqingActivity;
import com.example.zsd.entity.GetHotVideos;
import com.example.zsd.entity.GetNearVideos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 作者： 张少丹
 * 时间：  2017/12/5.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class MyShipinRemenAdapter1 extends RecyclerView.Adapter<MyShipinRemenAdapter1.ViewHolder>{


    private Activity context;
    private List<GetNearVideos.DataBean> list;

    public MyShipinRemenAdapter1(Activity context, List<GetNearVideos.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    public void refreshData(List<GetNearVideos.DataBean> data){
        if(list != null){
            list.clear();
            list.addAll(data);
            notifyDataSetChanged();
        }
    }
    public void loadmoreData(List<GetNearVideos.DataBean> data){
        if(list != null){
            list.addAll(data);
            notifyDataSetChanged();
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.shipin_remen_item1, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String s = list.get(position).videoUrl.replaceAll("https://www.zhaoapi.cn", "http://120.27.23.105");
        /*View player = View.inflate(context, R.layout.simple_player_view_player, holder.ivv);
        PlayerView playerView = new PlayerView(context,player)
                .setTitle(list.get(position).workDesc)
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource(s)
                .startPlay()
                .showThumbnail(new OnShowThumbnailListener() {
            @Override
            public void onShowThumbnail(ImageView ivThumbnail) {
                Glide.with(context).load(list.get(position).cover).into(ivThumbnail);
            }
        });*/

        ViewGroup.LayoutParams params = holder.img.getLayoutParams();
        params.height=list.get(position).height;
        holder.img.setLayoutParams(params);
       Glide.with(context).load(list.get(position).cover).into(holder.img);
       holder.img.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(context, ShipinXiangqingActivity.class);
               intent.putExtra("videoUrl",s);
               intent.putExtra("workDesc",list.get(position).workDesc);
               intent.putExtra("icon",list.get(position).user.icon);
               context.startActivity(intent);
           }
       });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.shipin_img1);
        }
    }
}

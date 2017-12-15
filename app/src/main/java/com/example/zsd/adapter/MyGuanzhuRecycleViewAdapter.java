package com.example.zsd.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zsd.R;
import com.example.zsd.activity.MyGuanzhuActivity;
import com.example.zsd.entity.GetFollowUsers;

import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/12/14.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class MyGuanzhuRecycleViewAdapter extends RecyclerView.Adapter<MyGuanzhuRecycleViewAdapter.ViewHolder>{
    private Context context;
    private List<GetFollowUsers.DataBean> data;
    public MyGuanzhuRecycleViewAdapter(Context context, List<GetFollowUsers.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.guanzhu_rv_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.nickname.setText(data.get(position).nickname);
        holder.des.setText(data.get(position).username);
        holder.time.setText(data.get(position).createtime);
        Glide.with(context).load(data.get(position).icon).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView icon;
        private final TextView nickname;
        private final TextView des;
        private final TextView time;

        public ViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.guanzhu_iv_icon);
            nickname = itemView.findViewById(R.id.guanzhu_tv_nickname);
            des = itemView.findViewById(R.id.guanzhu_tv_des);
            time = itemView.findViewById(R.id.guanzhu_tv_time);
        }
    }
}

package com.example.zsd.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zsd.R;
import com.example.zsd.activity.FindFriendsActivity;
import com.example.zsd.entity.SearchFriends;

import java.util.List;

import static com.example.zsd.R.id.find_tv_guanzhu;

/**
 * 作者： 张少丹
 * 时间：  2017/12/15.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class SearchFriendsRecycleViewAdapter extends RecyclerView.Adapter<SearchFriendsRecycleViewAdapter.ViewHolder>{
    private Context context;
    private List<SearchFriends.DataBean> data;

    public SearchFriendsRecycleViewAdapter(Context context, List<SearchFriends.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    public void refreshData(List<SearchFriends.DataBean> list){
        if(data != null){
            data.clear();
            data.addAll(list);
            notifyDataSetChanged();
        }
    }
    public void loadmoreData(List<SearchFriends.DataBean> list){
        if(data != null){
            data.addAll(list);
            notifyDataSetChanged();
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.find_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Glide.with(context).load(data.get(position).icon).into(holder.icon);
        holder.des.setText(data.get(position).mobile);
        holder.nickname.setText(data.get(position).nickname);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView icon;
        private final TextView nickname;
        private final TextView des;
        private final TextView guanzhu;

        public ViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.find_iv_icon);
            nickname = itemView.findViewById(R.id.find_tv_nickname);
            des = itemView.findViewById(R.id.find_tv_des);
            guanzhu = itemView.findViewById(R.id.find_tv_guanzhu);
        }
    }
}

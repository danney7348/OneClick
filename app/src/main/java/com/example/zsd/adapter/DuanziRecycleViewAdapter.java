package com.example.zsd.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zsd.R;
import com.example.zsd.entity.GetJokes;

import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/11/26.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class DuanziRecycleViewAdapter extends RecyclerView.Adapter<DuanziRecycleViewAdapter.ViewHolder>{

    private Context context;
    private  List<GetJokes.DataBean> data;
    public DuanziRecycleViewAdapter(Context context, List<GetJokes.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.duanzi_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.content.setText(data.get(position).content);
        holder.name.setText(data.get(position).user.nickname);
        holder.time.setText(data.get(position).createTime);
        Glide.with(context).load(data.get(position).user.icon).into(holder.touxiang);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView time;
        private final TextView content;
        private final TextView name;
        private final ImageView touxiang;
        private final ImageView bianji;

        public ViewHolder(View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.duanzi_item_tv_time);
            content = itemView.findViewById(R.id.duanzi_tv_content);
            name = itemView.findViewById(R.id.duanziz_item_tv_name);
            touxiang = itemView.findViewById(R.id.iv_touxiang);
            bianji = itemView.findViewById(R.id.duanzi_item_iv_bianji);
        }
    }
}

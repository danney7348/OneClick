package com.example.zsd.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zsd.R;
import com.example.zsd.entity.GetWorkInfo;

import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/12/15.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class YiShangchuanRecycleViewAdapter extends RecyclerView.Adapter<YiShangchuanRecycleViewAdapter.ViewHolder>{

    private Context context;
    private List<GetWorkInfo.DataBean.WorksEntitiesBean> worksEntities;

    public YiShangchuanRecycleViewAdapter(Context context, List<GetWorkInfo.DataBean.WorksEntitiesBean> worksEntities) {
        this.context = context;
        this.worksEntities = worksEntities;
    }

    public void removeData(int position) {
        worksEntities.remove(position);
        //删除动画
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.yishangchuan_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Glide.with(context).load(worksEntities.get(position).cover).into(holder.img);
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                onLongClickListener.setOnLongClickListener(view,position);
                return false;

            }
        });
    }

    @Override
    public int getItemCount() {
        return worksEntities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.yishangchuan_iv_img);
        }
    }
    private OnLongClickListener onLongClickListener;

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public interface OnLongClickListener{
        void setOnLongClickListener(View view,int position);
    }
}

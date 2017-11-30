package com.example.zsd.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zsd.R;

import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/11/30.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class MyImgUrlsAdapter1 extends RecyclerView.Adapter<MyImgUrlsAdapter1.ViewHolder> {
    private List<String> imgUrls;
    private Context context;
    public MyImgUrlsAdapter1(Context context, List<String> imgUrls) {
        this.context = context;
        this.imgUrls = imgUrls;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.images_item1, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Glide.with(context).load(imgUrls.get(position)).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return imgUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
        }
    }
}

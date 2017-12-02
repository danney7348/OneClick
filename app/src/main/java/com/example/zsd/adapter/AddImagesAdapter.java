package com.example.zsd.adapter;

import com.bumptech.glide.request.RequestOptions;
import com.example.zsd.R;
import com.example.zsd.activity.BianxieDuanziActivity;

import java.util.ArrayList;

/**
 * 作者： 张少丹
 * 时间：  2017/11/29.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Adapter
 * Created by Yancy on 2015/12/4.
 */
public class AddImagesAdapter extends RecyclerView.Adapter<AddImagesAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<String> result;
    private final static String TAG = "Adapter";

    public AddImagesAdapter(Context context, List<String> result) {
        mLayoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.result = result;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.images_item, null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        RequestOptions options = new RequestOptions();
        options.placeholder(R.drawable.ic_launcher_foreground);
        Glide.with(context).load(result.get(position)).apply(options).into(holder.image);
        /*Glide.with(context)
                .load(result.get(position))
                .centerCrop()
                .into(holder.image);*/
        holder.image.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder ad = new AlertDialog.Builder(context)
                        .setTitle("是否删除")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                result.remove(position);
                                notifyDataSetChanged();
                            }
                        }).setNegativeButton("取消",null);
                ad.show();

                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
        }

    }


}

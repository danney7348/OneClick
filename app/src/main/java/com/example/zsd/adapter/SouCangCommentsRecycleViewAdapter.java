package com.example.zsd.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zsd.R;
import com.example.zsd.entity.GetFavorites;
import com.example.zsd.entity.GetUserInfo;
import com.example.zsd.entity.GetVideos;
import com.example.zsd.presenter.GetUserInfoPresenter;
import com.example.zsd.view.GetUserInfoView;

import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/12/18.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class SouCangCommentsRecycleViewAdapter extends RecyclerView.Adapter<SouCangCommentsRecycleViewAdapter.ViewHolder>{
    private Context context;
    private List<GetFavorites.DataBean.CommentsBean> comments;

    public SouCangCommentsRecycleViewAdapter(Context context,List<GetFavorites.DataBean.CommentsBean> comments) {
        this.context = context;
        this.comments = comments;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.comments_item,null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.content.setText(comments.get(position).content);
        holder.name.setText(comments.get(position).nickname+":");
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        private final TextView content;
        private final TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.comments_tv_name);
            content = itemView.findViewById(R.id.comments_tv_content);
        }
    }
}

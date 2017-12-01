package com.example.zsd.adapter;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.zsd.R;
import com.example.zsd.activity.UserInfoActivity;
import com.example.zsd.entity.GetVideos;
import com.example.zsd.utils.GlideCircleTransform;

import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/12/1.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class RemenRecycleViewAdapter extends RecyclerView.Adapter<RemenRecycleViewAdapter.ViewHolder>{
    private ObjectAnimator animator;
    private ObjectAnimator fanimator;
    private ObjectAnimator animator1;
    private ObjectAnimator fanimator1;
    private ObjectAnimator animator2;
    private ObjectAnimator fanimator2;
    private ObjectAnimator animator3;
    private ObjectAnimator fanimator3;
    private Context context;
    private List<GetVideos.DataBean> list;
    public RemenRecycleViewAdapter(Context context, List<GetVideos.DataBean> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.videos_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.name.setText(list.get(position).user.nickname);
        holder.content.setText(list.get(position).workDesc);
        holder.time.setText(list.get(position).createTime);
        Glide.with(context).load(list.get(position).user.icon).bitmapTransform(new GlideCircleTransform(context,360)).into(holder.touxiang);
        Glide.with(context).load(list.get(position).cover).bitmapTransform(new GlideCircleTransform(context,360)).into(holder.iv);
        holder.touxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UserInfoActivity.class);
                context.startActivity(intent);
            }
        });
        holder.iv_animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ObjectAnimator animator0 = ObjectAnimator.ofFloat(holder.iv_shutdown, "rotation", 0, -180);

                animator1 = ObjectAnimator.ofFloat(holder.iv_animation1, "translationX", 0, -330);
                animator2 = ObjectAnimator.ofFloat(holder.iv_animation2, "translationX", 0, -220);
                animator3 = ObjectAnimator.ofFloat(holder.iv_animation3, "translationX", 0, -110);

                holder.iv_shutdown.setVisibility(View.VISIBLE);
                holder.iv_animation.setVisibility(View.GONE);
                AnimatorSet set = new AnimatorSet();
                set.play(animator0).with(animator1).with(animator2).with(animator3);
                set.setDuration(500);
                set.start();
                holder.tv1.setVisibility(View.VISIBLE);
                holder.tv2.setVisibility(View.VISIBLE);
                holder.tv3.setVisibility(View.VISIBLE);
            }
        });
        holder.iv_shutdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.iv_shutdown.setVisibility(View.GONE);
                holder.iv_animation.setVisibility(View.VISIBLE);

                //伸出的动画
                final ObjectAnimator animator = ObjectAnimator.ofFloat(holder.iv_animation, "rotation", 0, 180);

                //缩回的动画

                fanimator = ObjectAnimator.ofFloat(holder.iv_animation, "rotation", 0, -180);
                fanimator1 = ObjectAnimator.ofFloat(holder.iv_animation3, "translationX", -110, 0);
                fanimator2 = ObjectAnimator.ofFloat(holder.iv_animation2, "translationX", -220, 0);
                fanimator3 = ObjectAnimator.ofFloat(holder.iv_animation1, "translationX", -330, 0);

                AnimatorSet set = new AnimatorSet();
                set.play(animator).with(fanimator1).with(fanimator2).with(fanimator3);
                set.setDuration(500);
                set.start();
                holder.tv1.setVisibility(View.GONE);
                holder.tv2.setVisibility(View.GONE);
                holder.tv3.setVisibility(View.GONE);
            }
        });


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "点击了", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private int a=0;
        private final TextView time;
        private final TextView content;
        private final TextView name;
        private final ImageView touxiang;
        private final ImageView iv;
        private final ImageView iv_animation;
        private final ImageView iv_shutdown;
        private final LinearLayout iv_animation1;
        private final LinearLayout iv_animation2;
        private final LinearLayout iv_animation3;
        private final TextView tv1;
        private final  TextView tv2;
        private final  TextView tv3;
        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.imgurlsRecycler1);
            time = itemView.findViewById(R.id.duanzi_item_tv_time1);
            content = itemView.findViewById(R.id.duanzi_tv_content1);
            name = itemView.findViewById(R.id.duanziz_item_tv_name1);
            touxiang = itemView.findViewById(R.id.iv_touxiang1);
            iv_animation = itemView.findViewById(R.id.iv_animation1);
            iv_animation1 = itemView.findViewById(R.id.iv_animation11);
            iv_animation2 = itemView.findViewById(R.id.iv_animation21);
            iv_animation3 = itemView.findViewById(R.id.iv_animation31);
            iv_shutdown=itemView.findViewById(R.id.iv_shutdown1);
            tv1 = itemView.findViewById(R.id.tv11);
            tv2 = itemView.findViewById(R.id.tv21);
            tv3 = itemView.findViewById(R.id.tv31);
        }
    }
}

package com.example.zsd.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
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
import com.example.zsd.entity.GetJokes;
import com.example.zsd.utils.GlideCircleTransform;

import java.util.ArrayList;
import java.util.List;

import static com.example.zsd.R2.id.recycler;

/**
 * 作者： 张少丹
 * 时间：  2017/11/26.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class DuanziRecycleViewAdapter extends RecyclerView.Adapter<DuanziRecycleViewAdapter.ViewHolder>{

    private ObjectAnimator animator;
    private ObjectAnimator fanimator;
    private ObjectAnimator animator1;
    private ObjectAnimator fanimator1;
    private ObjectAnimator animator2;
    private ObjectAnimator fanimator2;
    private ObjectAnimator animator3;
    private ObjectAnimator fanimator3;
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
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.name.setText(data.get(position).user.nickname);
        holder.content.setText(data.get(position).content);
        holder.time.setText(data.get(position).createTime);
        if(data.get(position).imgUrls != null){
            String string = data.get(position).imgUrls.toString();
            String[] split1 = string.split("\\|");
            List<String> imgUrls = new ArrayList<>();
            for (int i = 0; i < split1.length; i++) {
                imgUrls.add(split1[i]);
                System.out.println("i = " + split1[i]);
            }
            if(imgUrls.size()==4||imgUrls.size()==2){
                GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
                MyImgUrlsAdapter adapter = new MyImgUrlsAdapter(context,imgUrls);
                holder.recycler.setLayoutManager(gridLayoutManager);
                holder.recycler.setAdapter(adapter);
            }else if(imgUrls.size()==1){
                GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 1);
                MyImgUrlsAdapter adapter = new MyImgUrlsAdapter(context,imgUrls);
                holder.recycler.setLayoutManager(gridLayoutManager);
                holder.recycler.setAdapter(adapter);
            }else {
                GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
                MyImgUrlsAdapter adapter = new MyImgUrlsAdapter(context, imgUrls);
                holder.recycler.setLayoutManager(gridLayoutManager);
                holder.recycler.setAdapter(adapter);
            }
        }
        Glide.with(context).load(data.get(position).user.icon).bitmapTransform(new GlideCircleTransform(context,360)).into(holder.touxiang);
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
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private int a=0;
        private final TextView time;
        private final TextView content;
        private final TextView name;
        private final ImageView touxiang;
        private final RecyclerView recycler;
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
            recycler = itemView.findViewById(R.id.imgurlsRecycler);
            time = itemView.findViewById(R.id.duanzi_item_tv_time);
            content = itemView.findViewById(R.id.duanzi_tv_content);
            name = itemView.findViewById(R.id.duanziz_item_tv_name);
            touxiang = itemView.findViewById(R.id.iv_touxiang);
            iv_animation = itemView.findViewById(R.id.iv_animation);
            iv_animation1 = itemView.findViewById(R.id.iv_animation1);
            iv_animation2 = itemView.findViewById(R.id.iv_animation2);
            iv_animation3 = itemView.findViewById(R.id.iv_animation3);
            iv_shutdown=itemView.findViewById(R.id.iv_shutdown);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
        }
    }
}

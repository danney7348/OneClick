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
import android.widget.TextView;

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
        holder.content.setText(data.get(position).content);
        holder.name.setText(data.get(position).user.nickname);
        holder.time.setText(data.get(position).createTime);
        if(data.get(position).imgUrls != null){
            String string = data.get(position).imgUrls.toString();
            System.out.println("string = " + string);
            String[] split1 = string.split("\\|");
            List<String> imgUrls = new ArrayList<>();
            for (int i = 0; i < split1.length; i++) {
                imgUrls.add(split1[i]);
                System.out.println("i = " + split1[i]);
            }
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
            MyImgUrlsAdapter adapter = new MyImgUrlsAdapter(context,imgUrls);
            holder.recycler.setLayoutManager(gridLayoutManager);
            holder.recycler.setAdapter(adapter);
        }
        Glide.with(context).load(data.get(position).user.icon).bitmapTransform(new GlideCircleTransform(context,360)).into(holder.touxiang);
        holder.touxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UserInfoActivity.class);
                context.startActivity(intent);
            }
        });
        animator = ObjectAnimator.ofFloat(holder.bianji, "rotation", 0f, 180f);
        animator1 = ObjectAnimator.ofFloat(holder.bianji5, "translationX", 0f,-80f);
        animator2 = ObjectAnimator.ofFloat(holder.bianji3, "translationX", 0f,-160f);
        animator3 = ObjectAnimator.ofFloat(holder.bianji4, "translationX", 0f,-240f);

        fanimator = ObjectAnimator.ofFloat(holder.bianji, "rotation", 0f, -180f);
        fanimator1 = ObjectAnimator.ofFloat(holder.bianji5, "translationX", -80f,0f);
        fanimator2 = ObjectAnimator.ofFloat(holder.bianji3, "translationX", -160f,0f);
        fanimator3 = ObjectAnimator.ofFloat(holder.bianji4, "translationX", -240f,0f);

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                holder.bianji.setImageResource(R.drawable.icon_packup);//动画结束改变图片

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        //给缩回动画设置监听

        fanimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                holder.bianji.setImageResource(R.drawable.icon_open);//改变图片
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });


        holder.bianji.setOnClickListener(new View.OnClickListener() {//图片的点击事件
            @Override
            public void onClick(View view) {
                holder.a++;
                if(holder.a%2==1){//第一次点击是实现伸出效果
                    AnimatorSet animSet = new AnimatorSet();//动画集合
                    animSet.play(animator).with(animator1).with(animator2).with(animator3);
                    animSet.setDuration(500);
                    animSet.start();

                }else{//再点击一次实现缩回效果
                    AnimatorSet animSet1 = new AnimatorSet();//动画集合
                    animSet1.play(fanimator).with(fanimator1).with(fanimator2).with(fanimator3);
                    animSet1.setDuration(500);
                    animSet1.start();
                }
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
        private final ImageView bianji,bianji2,bianji3,bianji4,bianji5;
        private final RecyclerView recycler;

        public ViewHolder(View itemView) {
            super(itemView);
            recycler = itemView.findViewById(R.id.imgurlsRecycler);
            time = itemView.findViewById(R.id.duanzi_item_tv_time);
            content = itemView.findViewById(R.id.duanzi_tv_content);
            name = itemView.findViewById(R.id.duanziz_item_tv_name);
            touxiang = itemView.findViewById(R.id.iv_touxiang);
            bianji = itemView.findViewById(R.id.duanzi_item_iv_bianji);
            bianji2 = itemView.findViewById(R.id.duanzi_item_iv_bianji2);
            bianji3 = itemView.findViewById(R.id.duanzi_item_iv_bianji3);
            bianji4 = itemView.findViewById(R.id.duanzi_item_iv_bianji4);
            bianji5 = itemView.findViewById(R.id.duanzi_item_iv_bianji5);
        }
    }
}

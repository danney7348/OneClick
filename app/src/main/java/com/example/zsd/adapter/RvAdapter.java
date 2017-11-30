package com.example.zsd.adapter;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zsd.R;
import com.example.zsd.entity.GetJokes;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by DELL on 2017/11/28.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder>{

    private Context context;
    private List<GetJokes.DataBean> list;
    private ObjectAnimator rotation;
    private ObjectAnimator animator1;
    private ObjectAnimator animator2;
    private ObjectAnimator animator3;
    private ObjectAnimator fanimator;
    private ObjectAnimator fanimator1;
    private ObjectAnimator fanimator2;
    private ObjectAnimator fanimator3;
    private final int atype=0;
    private final int btype=1;
    private int length;

    public RvAdapter(Context context, List<GetJokes.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.rv_item2, null);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.setIsRecyclable(false);
        holder.tv_date.setText(list.get(position).createTime);
        holder.tv_name.setText(list.get(position).user.nickname);
        //holder.iv.setImageURI(list.get(position).user.icon);
        holder.tv.setText(list.get(position).content);
        /*String imgUrls = (String) list.get(position).imgUrls;
        if(imgUrls!=null)
        {
            String[] split = imgUrls.split("\\|");
            int length = split.length;

            if(length==2||length==4)
            {
                GridLayoutManager gridLayoutManager=new GridLayoutManager(context,2);
                gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
                holder.rv_duanzi.setLayoutManager(gridLayoutManager);
                RvAdapter2 rvAdapter2=new RvAdapter2(context,split);
                ((ViewHolder) holder).rv_duanzi.setAdapter(rvAdapter2);
            }
            else if(length==1)
            {
                GridLayoutManager gridLayoutManager=new GridLayoutManager(context,1);
                gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
                holder.rv_duanzi.setLayoutManager(gridLayoutManager);
                RvAdapter2 rvAdapter2=new RvAdapter2(context,split);
                ((ViewHolder) holder).rv_duanzi.setAdapter(rvAdapter2);
            }
            else
            {
                GridLayoutManager gridLayoutManager=new GridLayoutManager(context,3);
                gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
                holder.rv_duanzi.setLayoutManager(gridLayoutManager);
                RvAdapter2 rvAdapter2=new RvAdapter2(context,split);
                ((ViewHolder) holder).rv_duanzi.setAdapter(rvAdapter2);
            }
        }
        else
        {
            holder.rv_duanzi.setVisibility(View.GONE);
        }*/
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
    public int getItemViewType(int position) {
        if(list.get(position).imgUrls!=null)
        {
            String imgUrls = (String) list.get(position).imgUrls;

            String[] split = imgUrls.split("\\|");
            length = split.length;
        }


        if(length==1)
        {
            return  atype;
        }
        else
        {
            return btype;
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        //private final SimpleDraweeView iv;
        private final TextView tv_name;
        private final TextView tv_date;
        private final TextView tv;
        private final ImageView iv_animation;
        private final ImageView iv_shutdown;
        private final LinearLayout iv_animation1;
        private final LinearLayout iv_animation2;
        private final LinearLayout iv_animation3;
        private final TextView tv1;

        private final  TextView tv2;
        private final  TextView tv3;
        private final RecyclerView rv_duanzi;

        public ViewHolder(View itemView) {
            super(itemView);
         //   iv = itemView.findViewById(R.id.iv);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_date = itemView.findViewById(R.id.tv_date);
            tv = itemView.findViewById(R.id.tv);
            iv_animation = itemView.findViewById(R.id.iv_animation);
            iv_animation1 = itemView.findViewById(R.id.iv_animation1);
            iv_animation2 = itemView.findViewById(R.id.iv_animation2);
            iv_animation3 = itemView.findViewById(R.id.iv_animation3);
            iv_shutdown=itemView.findViewById(R.id.iv_shutdown);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
            rv_duanzi = itemView.findViewById(R.id.rv_duanzi);

        }
    }
}

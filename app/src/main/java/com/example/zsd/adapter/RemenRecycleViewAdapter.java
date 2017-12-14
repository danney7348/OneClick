package com.example.zsd.adapter;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.dou361.ijkplayer.listener.OnShowThumbnailListener;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.example.zsd.R;
import com.example.zsd.activity.UserInfoActivity;
import com.example.zsd.entity.AddFavourite;
import com.example.zsd.entity.CancelFavourite;
import com.example.zsd.entity.Comment;
import com.example.zsd.entity.GetVideos;
import com.example.zsd.entity.Praise;
import com.example.zsd.presenter.AddFavouritePresenter;
import com.example.zsd.presenter.CancelFavouritePresenter;
import com.example.zsd.presenter.CommentPresenter;
import com.example.zsd.presenter.PraisePresenter;
import com.example.zsd.utils.GlideCircleTransform;
import com.example.zsd.view.AddFavouriteView;
import com.example.zsd.view.CancelFavouriteView;
import com.example.zsd.view.CommentView;
import com.example.zsd.view.PraiseView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者： 张少丹
 * 时间：  2017/12/1.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class RemenRecycleViewAdapter extends RecyclerView.Adapter<RemenRecycleViewAdapter.ViewHolder> implements AddFavouriteView, CancelFavouriteView, PraiseView, CommentView {

    private ObjectAnimator fanimator;
    private ObjectAnimator animator1;
    private ObjectAnimator fanimator1;
    private ObjectAnimator animator2;
    private ObjectAnimator fanimator2;
    private ObjectAnimator animator3;
    private ObjectAnimator fanimator3;
    private Activity context;
    private List<GetVideos.DataBean> list;
    private View view;

    private OnLongItemClickListener onLongItemClickListener;
    private AddFavouritePresenter addFavouritePresenter;
    private CancelFavouritePresenter cancelFavouritePresenter;
    private PraisePresenter praisePresenter;
    private int uid;
    private int wid;
    private CommentPresenter commentPresenter;

    public RemenRecycleViewAdapter(Activity context, List<GetVideos.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.videos_item, null);
        ViewHolder holder = new ViewHolder(view);
        addFavouritePresenter = new AddFavouritePresenter(this);
        cancelFavouritePresenter = new CancelFavouritePresenter(this);
        praisePresenter = new PraisePresenter(this);
        commentPresenter = new CommentPresenter(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.name.setText(list.get(position).user.nickname);
        holder.content.setText(list.get(position).workDesc);
        holder.time.setText(list.get(position).createTime);
        String s = list.get(position).videoUrl.replaceAll("https://www.zhaoapi.cn", "http://120.27.23.105");
        final View player = View.inflate(context, R.layout.simple_player_view_player, holder.player);
        PlayerView playerView = new PlayerView(context, player)
                .setTitle(list.get(position).workDesc)
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource(s)
                .startPlay()
                .showThumbnail(new OnShowThumbnailListener() {
                    @Override
                    public void onShowThumbnail(ImageView ivThumbnail) {
                        Glide.with(context).load(list.get(position).cover).into(ivThumbnail);
                    }
                });
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .priority(Priority.HIGH)
                .transform(new GlideCircleTransform());
        Glide.with(context).load(list.get(position).user.icon).apply(options).into(holder.touxiang);
        holder.touxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UserInfoActivity.class);
                intent.putExtra("uid", list.get(position).uid + "");
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

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                System.out.println("=======================" + position);
                onLongItemClickListener.setOnLongItemClickListener(position);
                return true;
            }
        });
        holder.xihuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                praisePresenter.getPraiseData(list.get(position).uid+"",list.get(position).wid+"");
                holder.xihuan.setImageResource(R.drawable.raw_1499933215);
            }
        });
        holder.shoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.shoucang1.setVisibility(View.VISIBLE);
                holder.shoucang.setVisibility(View.GONE);
                addFavouritePresenter.getAddFavouriteData(list.get(position).uid+"",list.get(position).wid+"");
            }
        });
        holder.shoucang1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.shoucang1.setVisibility(View.GONE);
                holder.shoucang.setVisibility(View.VISIBLE);
                cancelFavouritePresenter.getAddFavouriteData(list.get(position).uid+"",list.get(position).wid+"");
            }
        });
        holder.fenxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.xiaoxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void refreshData(List<GetVideos.DataBean> data) {
        if (list != null) {
            list.clear();
            list.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void loadmoreData(List<GetVideos.DataBean> data) {
        if (list != null) {
            list.addAll(data);
            notifyDataSetChanged();
        }
    }


    @Override
    public void success(Object o) {

    }

    @Override
    public void error(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failure(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addFavouriteSuccess(AddFavourite addFavourite) {

        Toast.makeText(context, addFavourite.msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addFavouriteFailure(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void cancelFavouriteSuccess(CancelFavourite cancelFavourite) {
        Toast.makeText(context, cancelFavourite.msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void cancelFavouriteFailure(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getPraiseSuccess(Praise praise) {
        Toast.makeText(context, praise.msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getPraiseFailure(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getCommentSuccess(Comment comment) {
        Toast.makeText(context, comment.msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getCommentFailure(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int a = 0;
        private final TextView time;
        private final TextView content;
        private final TextView name;
        private final ImageView touxiang;
        private final ImageView iv_animation;
        private final ImageView iv_shutdown;
        private final LinearLayout iv_animation1;
        private final LinearLayout iv_animation2;
        private final LinearLayout iv_animation3;
        private final TextView tv1;
        private final TextView tv2;
        private final TextView tv3;
        private final RelativeLayout player;
        private final ImageView xihuan,shoucang,shoucang1,xiaoxi,fenxiang;

        public ViewHolder(View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.duanzi_item_tv_time1);
            content = itemView.findViewById(R.id.duanzi_tv_content1);
            name = itemView.findViewById(R.id.duanziz_item_tv_name1);
            touxiang = itemView.findViewById(R.id.iv_touxiang1);
            iv_animation = itemView.findViewById(R.id.iv_animation1);
            iv_animation1 = itemView.findViewById(R.id.iv_animation11);
            iv_animation2 = itemView.findViewById(R.id.iv_animation21);
            iv_animation3 = itemView.findViewById(R.id.iv_animation31);
            iv_shutdown = itemView.findViewById(R.id.iv_shutdown1);
            tv1 = itemView.findViewById(R.id.tv11);
            tv2 = itemView.findViewById(R.id.tv21);
            tv3 = itemView.findViewById(R.id.tv31);
            player = itemView.findViewById(R.id.video_rl_player);
            shoucang = itemView.findViewById(R.id.videos_iv_shoucang);
            xihuan = itemView.findViewById(R.id.videos_iv_xihuan);
            shoucang1 = itemView.findViewById(R.id.videos_iv_shoucang1);
            xiaoxi = itemView.findViewById(R.id.videos_iv_xiaoxi);
            fenxiang = itemView.findViewById(R.id.videos_iv_fenxiang);
        }
    }


    public void setOnLongItemClickListener(OnLongItemClickListener onLongItemClickListener) {
        this.onLongItemClickListener = onLongItemClickListener;
    }

    public interface OnLongItemClickListener {
        void setOnLongItemClickListener(int position);
    }
}

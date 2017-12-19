package com.example.zsd.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.example.zsd.R;
import com.example.zsd.adapter.CommentsRecycleViewAdapter;
import com.example.zsd.adapter.CommentsRecycleViewAdapter1;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.Comment;
import com.example.zsd.entity.GetVideos;
import com.example.zsd.entity.GetVideosDetail;
import com.example.zsd.presenter.CommentPresenter;
import com.example.zsd.presenter.GetVideosDetailPresenter;
import com.example.zsd.utils.ShareprefrensUtils;
import com.example.zsd.view.CommentView;
import com.example.zsd.view.GetVideosDetailView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShipinXiangqingActivity1 extends BaseActivity<GetVideosDetailPresenter> implements GetVideosDetailView, CommentView {

    private TextView desc;
    private ImageView icon;
    private RelativeLayout ivv;
    private XRecyclerView rv;
    private TextView des;
    private ImageView img;
    private CommentsRecycleViewAdapter1 adapter;
    private List<GetVideosDetail.DataBean.CommentsBean> comments;
    private CommentPresenter presenter;
    private String wid;
    private TextView pinglun;

    @Override
    public int bindLayout() {
        return R.layout.activity_shipin_xiangqing;
    }

    @Override
    public void setListener() {

    }

    @Override
    public void Click(View view) throws PackageManager.NameNotFoundException {

    }

    @Override
    public void initView() {
        presenter = new CommentPresenter(this);
        comments = new ArrayList<>();
        ivv = findViewById(R.id.xiangqing_player);
        desc = findViewById(R.id.xiangqing_tv_title);
        icon = findViewById(R.id.xiangqing_iv_icon);
        ivv = findViewById(R.id.xiangqing_player);
        pinglun = findViewById(R.id.xiangwing_woyaopinglun);
        rv = findViewById(R.id.xiangqing_rv);
        des = findViewById(R.id.xiangqing_tv_des);
        img = findViewById(R.id.xiangqing_iv_img);
        Intent intent1 = getIntent();
        wid = intent1.getStringExtra("wid");
        showToast(wid);
        t.getVideosDetailData(wid);
        pinglun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText et = new EditText(ShipinXiangqingActivity1.this);
                new AlertDialog.Builder(ShipinXiangqingActivity1.this).setTitle("评论")
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .setView(et)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                String input = et.getText().toString();
                                if (input.equals("")) {
                                    Toast.makeText(ShipinXiangqingActivity1.this, "评论内容不能为空！" + input, Toast.LENGTH_LONG).show();
                                }
                                else {
                                    String uid = (String) ShareprefrensUtils.get(ShipinXiangqingActivity1.this, "uid", "");
                                    presenter.getCommentData(uid,wid,et.getText().toString());
                                }
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }

    @Override
    public GetVideosDetailPresenter binView() {
        return new GetVideosDetailPresenter(this);
    }


    @Override
    public void success(Object o) {

    }

    @Override
    public void error(String msg) {

    }

    @Override
    public void failure(String msg) {

        showToast(msg);
    }

    @Override
    public void getVideosDetailSuccess(final GetVideosDetail getVideosDetail) {
        comments = getVideosDetail.data.comments;
        if(comments.size() > 0){
            des.setVisibility(View.GONE);
            img.setVisibility(View.GONE);
            rv.setVisibility(View.VISIBLE);
            rv.setLayoutManager(new LinearLayoutManager(this));
            if(adapter == null){
                adapter = new CommentsRecycleViewAdapter1(this, this.comments);
                rv.setAdapter(adapter);
            }else {
                adapter.refresh(comments);
            }
        }
        if(comments.size() == 0){
            des.setVisibility(View.VISIBLE);
            img.setVisibility(View.VISIBLE);
            rv.setVisibility(View.GONE);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final EditText et = new EditText(ShipinXiangqingActivity1.this);
                    new AlertDialog.Builder(ShipinXiangqingActivity1.this).setTitle("评论")
                            .setIcon(android.R.drawable.ic_dialog_info)
                            .setView(et)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    String input = et.getText().toString();
                                    if (input.equals("")) {
                                        Toast.makeText(ShipinXiangqingActivity1.this, "评论内容不能为空！" + input, Toast.LENGTH_LONG).show();
                                    }
                                    else {
                                        String uid = (String) ShareprefrensUtils.get(ShipinXiangqingActivity1.this, "uid", "");
                                        presenter.getCommentData(uid,getVideosDetail.data.wid+"",et.getText().toString());
                                    }
                                }
                            })
                            .setNegativeButton("取消", null)
                            .show();
                }
            });
        }
        showToast(getVideosDetail.msg);
        desc.setText(getVideosDetail.data.workDesc);
        String s = getVideosDetail.data.videoUrl.replaceAll("https://www.zhaoapi.cn", "http://120.27.23.105");
        Glide.with(this).load(getVideosDetail.data.user.icon).into(icon);
        View player = View.inflate(this, R.layout.simple_player_view_player, ivv);
        PlayerView playerView = new PlayerView(this,player)
                .setTitle(getVideosDetail.data.videoUrl)
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource(s)
                .startPlay();
    }

    @Override
    public void getVideosDetailFailure(String msg) {

        showToast(msg);
    }

    @Override
    public void getCommentSuccess(Comment comment) {

        showToast(comment.msg);
        t.getVideosDetailData(wid);
    }

    @Override
    public void getCommentFailure(String msg) {
        showToast(msg);
    }
}

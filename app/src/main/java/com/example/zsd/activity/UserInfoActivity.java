package com.example.zsd.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zsd.R;
import com.example.zsd.adapter.UserInfoRecycleAdapter;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.Follow;
import com.example.zsd.entity.GetUserInfo;
import com.example.zsd.entity.GetUserVideos;
import com.example.zsd.presenter.FollowPresenter;
import com.example.zsd.presenter.GetUserInfoPresenter;
import com.example.zsd.presenter.GetUserVideosPresenter;
import com.example.zsd.utils.ShareprefrensUtils;
import com.example.zsd.view.FollowView;
import com.example.zsd.view.GetUserInfoView;
import com.example.zsd.view.GetUserVideosView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserInfoActivity extends BaseActivity implements GetUserVideosView {

    private XRecyclerView lv;
    private List<GetUserVideos.DataBean> list;
    private UserInfoRecycleAdapter adapter;
    private GetUserVideosPresenter getUserVideosPresenter;
    private int page = 1;
    private String uid;
    private GetUserInfoPresenter presenter;
    private ImageView touxiang;
    private TextView nickname;
    private Button guanzhu;
    private FollowPresenter followPresenter;

    @Override
    public int bindLayout() {
        return R.layout.activity_user_info;
    }

    @Override
    public void setListener() {

    }

    @Override
    public void Click(View view) {

    }

    @Override
    public void initView() {
        View view = View.inflate(this, R.layout.user_info_item, null);
        view.findViewById(R.id.user_info_dianzan);
        guanzhu = view.findViewById(R.id.user_info_button_guanzhu);
        touxiang = view.findViewById(R.id.user_info_touxaing);
        view.findViewById(R.id.user_info_tv_fensi);
        nickname = view.findViewById(R.id.user_info_tv_name);
        lv = findViewById(R.id.user_info_xlv);
        Intent intent = getIntent();
        uid = intent.getStringExtra("uid");
        showToast(uid);
        lv.addHeaderView(view);

        list = new ArrayList();
        getUserVideosPresenter = new GetUserVideosPresenter(this);
        followPresenter = new FollowPresenter(new FollowView() {
            @Override
            public void success(Follow follow) {
                showToast(follow.msg);
            }

            @Override
            public void error(String msg) {
                showToast(msg);
            }

            @Override
            public void failure(String msg) {
                showToast(msg);
            }
        });
        presenter = new GetUserInfoPresenter(new GetUserInfoView() {
            @Override
            public void getUserInfoSuccess(GetUserInfo value) {
                showToast(value.data.uid+"");
                nickname.setText(value.data.nickname);
                Glide.with(UserInfoActivity.this).load(value.data.icon).into(touxiang);
                getUserVideosPresenter.getUserVideosData(uid,page+"");
            }

            @Override
            public void getUserInfoFaile(String string) {

            }

            @Override
            public void success(Object o) {

            }

            @Override
            public void error(String msg) {

            }

            @Override
            public void failure(String msg) {

            }
        });

    }

    @Override
    public void initData() {
        presenter.getUserInfoData(uid,"");
        guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guanzhu.setBackgroundColor(Color.parseColor("#29B6F6"));
                guanzhu.setText("已关注");
                guanzhu.setTextColor(Color.parseColor("#ffffff"));
                String uid1 = (String) ShareprefrensUtils.get(UserInfoActivity.this, "uid", "");
                followPresenter.getFollowData(uid1,uid);
            }
        });
    }

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }

    @Override
    public BasePresenter binView() {
        return null;
    }

    @Override
    public void success(GetUserVideos getUserVideos) {
        List<GetUserVideos.DataBean> data = getUserVideos.data;
        list.addAll(data);
        if(adapter == null){
            lv.setLayoutManager(new LinearLayoutManager(this));
            adapter = new UserInfoRecycleAdapter(UserInfoActivity.this,list);
            lv.setAdapter(adapter);
        }else {
            adapter.notifyDataSetChanged();
        }
        lv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                showToast("上拉刷新");
                page = 1;
                list.clear();
                getUserVideosPresenter.getUserVideosData(uid,page+"");
                lv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                showToast("下拉加载");
                page++;
                getUserVideosPresenter.getUserVideosData(uid,page+"");
                lv.loadMoreComplete();
            }
        });
    }

    @Override
    public void error(String msg) {

        showToast(msg);
    }

    @Override
    public void failure(String msg) {
        showToast(msg);
    }
}

package com.example.zsd.activity;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.zsd.R;
import com.example.zsd.adapter.MyGuanzhuRecycleViewAdapter;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.GetFollowUsers;
import com.example.zsd.presenter.GetFollowUsersPresenter;
import com.example.zsd.utils.ShareprefrensUtils;
import com.example.zsd.view.GetFollowUsersView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class MyGuanzhuActivity extends BaseActivity<GetFollowUsersPresenter> implements GetFollowUsersView {

    private String uid;
    private XRecyclerView rv;
    private MyGuanzhuRecycleViewAdapter adapter;
    private TextView back;

    @Override
    public int bindLayout() {
        return R.layout.activity_my_guanzhu;
    }

    @Override
    public void setListener() {

    }

    @Override
    public void Click(View view) throws PackageManager.NameNotFoundException {

    }

    @Override
    public void initView() {
        uid = (String) ShareprefrensUtils.get(this, "uid", "");
        t.getFollowUsersData(uid);
        rv = findViewById(R.id.guanzhu_follow_rv);
        back = findViewById(R.id.guanzhu_tv_back);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void initData() {

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }

    @Override
    public GetFollowUsersPresenter binView() {
        return new GetFollowUsersPresenter(this);
    }

    @Override
    public void success(GetFollowUsers getFollowUsers) {
        List<GetFollowUsers.DataBean> data = getFollowUsers.data;
        if(adapter == null){
            adapter = new MyGuanzhuRecycleViewAdapter(this,data);
            rv.setAdapter(adapter);
        }else{
            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void error(String msg) {

    }

    @Override
    public void failure(String msg) {

    }
}

package com.example.zsd.activity;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.zsd.R;
import com.example.zsd.adapter.SoucangRecycleViewAdapter;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.GetFavorites;
import com.example.zsd.presenter.GetFavouritePresenter;
import com.example.zsd.utils.ShareprefrensUtils;
import com.example.zsd.view.GetFavouriteView;

import java.util.List;

public class MyShoucangActivity extends BaseActivity<GetFavouritePresenter> implements GetFavouriteView {

    private RecyclerView rv;
    private TextView delete;
    private TextView back;

    @Override
    public int bindLayout() {
        return R.layout.activity_my_shoucang;
    }

    @Override
    public void setListener() {

    }

    @Override
    public void Click(View view) throws PackageManager.NameNotFoundException {

    }

    @Override
    public void initView() {
        rv = findViewById(R.id.shoucang_rv);
        delete = findViewById(R.id.shoucang_tv_delete);
        back = findViewById(R.id.shoucang_tv_back);
        rv.setLayoutManager(new LinearLayoutManager(this));
        String uid = (String) ShareprefrensUtils.get(this, "uid", "");
        t.getFavouriteData(uid);
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
    public GetFavouritePresenter binView() {
        return new GetFavouritePresenter(this);
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

    @Override
    public void getFavoritesSuccess(GetFavorites getFavorites) {
        showToast(getFavorites.msg);
        SoucangRecycleViewAdapter adapter = new SoucangRecycleViewAdapter(this,getFavorites.data);
        rv.setAdapter(adapter);
    }

    @Override
    public void getFavoritesFailure(String msg) {

        showToast(msg);
    }
}

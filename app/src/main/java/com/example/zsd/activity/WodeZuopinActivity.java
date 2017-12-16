package com.example.zsd.activity;

import android.content.pm.PackageManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zsd.R;
import com.example.zsd.adapter.MyTuijianFragmentAdapter;
import com.example.zsd.adapter.MyZuoPinFragmentAdapter;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.base.BasePresenter;
import com.example.zsd.fragment.GuanzhuFragment;
import com.example.zsd.fragment.LocalFragment;
import com.example.zsd.fragment.RemenFragment;
import com.example.zsd.fragment.YiShangchuanFragment;

import java.util.ArrayList;
import java.util.List;

public class WodeZuopinActivity extends BaseActivity {

    private TabLayout tablayout;
    private ViewPager vp;

    @Override
    public int bindLayout() {
        return R.layout.activity_wode_zuopin;
    }

    @Override
    public void setListener() {

    }

    @Override
    public void Click(View view) throws PackageManager.NameNotFoundException {

    }

    @Override
    public void initView() {
        tablayout = findViewById(R.id.wodezuopin_tablayout);
        vp = findViewById(R.id.wodezuopin_vp);
    }

    @Override
    public void initData() {
        List<String> menus = new ArrayList<>();
        menus.add("本地作品");
        menus.add("已上传");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new LocalFragment());
        fragments.add(new YiShangchuanFragment());
        MyZuoPinFragmentAdapter mypager = new MyZuoPinFragmentAdapter(getSupportFragmentManager(), menus, fragments);
        vp.setAdapter(mypager);
        tablayout.setupWithViewPager(vp);
    }

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }

    @Override
    public BasePresenter binView() {
        return null;
    }
}

package com.example.zsd;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zsd.activity.ChuangzuoActivity;
import com.example.zsd.activity.GaodeActivity;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.base.BasePresenter;
import com.example.zsd.fragment.DuanziFragment;
import com.example.zsd.fragment.LeftFragment;
import com.example.zsd.fragment.ShipinFragment;
import com.example.zsd.fragment.TuijianFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.img_icon)
    ImageView imgIcon;
    @BindView(R.id.img_biji)
    ImageView imgBiji;
    @BindView(R.id.include)
    RelativeLayout include;
    @BindView(R.id.frame_main)
    FrameLayout frameMain;
    @BindView(R.id.main_img_tuijian)
    ImageView mainImgTuijian;
    @BindView(R.id.main_tv_tuijain)
    TextView mainTvTuijain;
    @BindView(R.id.main_ll_tuijian)
    LinearLayout mainLlTuijian;
    @BindView(R.id.main_img_duanzi)
    ImageView mainImgDuanzi;
    @BindView(R.id.main_tv_dianzi)
    TextView mainTvDianzi;
    @BindView(R.id.main_ll_duanzi)
    LinearLayout mainLlDuanzi;
    @BindView(R.id.main_img_shiping)
    ImageView mainImgShiping;
    @BindView(R.id.main_tv_shipin)
    TextView mainTvShipin;
    @BindView(R.id.main_ll_shipin)
    LinearLayout mainLlShipin;
    @BindView(R.id.linearlaout)
    LinearLayout linearlaout;
    @BindView(R.id.main_fl)
    FrameLayout mainFl;
    @BindView(R.id.main_dl)
    DrawerLayout mainDl;
    @BindView(R.id.main_tv_title)
    TextView mainTvTitle;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setListener() {

    }

    @OnClick({R.id.img_icon, R.id.img_biji, R.id.main_ll_tuijian, R.id.main_ll_duanzi, R.id.main_ll_shipin})
    @Override
    public void Click(View view) {
        switch (view.getId()) {
            case R.id.img_icon:
                mainDl.openDrawer(Gravity.LEFT);
                break;
            case R.id.img_biji:
                startActivity(ChuangzuoActivity.class);
                break;
            case R.id.main_ll_tuijian:
                mainTvTitle.setText("推荐");
                mainImgTuijian.setImageResource(R.drawable.tuijian2);
                mainTvTuijain.setTextColor(Color.parseColor("#1296DB"));
                mainImgDuanzi.setImageResource(R.drawable.duanzi1);
                mainTvDianzi.setTextColor(Color.parseColor("#C5C5C5"));
                mainImgShiping.setImageResource(R.drawable.shiping1);
                mainTvShipin.setTextColor(Color.parseColor("#C5C5C5"));
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, new TuijianFragment()).commit();
                break;
            case R.id.main_ll_duanzi:
                mainTvTitle.setText("段子");
                mainImgTuijian.setImageResource(R.drawable.tuijian1);
                mainTvTuijain.setTextColor(Color.parseColor("#C5C5C5"));
                mainImgDuanzi.setImageResource(R.drawable.duanzi2);
                mainTvDianzi.setTextColor(Color.parseColor("#1296DB"));
                mainImgShiping.setImageResource(R.drawable.shiping1);
                mainTvShipin.setTextColor(Color.parseColor("#C5C5C5"));
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, new DuanziFragment()).commit();
                break;
            case R.id.main_ll_shipin:
                mainTvTitle.setText("视频");
                mainImgTuijian.setImageResource(R.drawable.tuijian1);
                mainTvTuijain.setTextColor(Color.parseColor("#C5C5C5"));
                mainImgDuanzi.setImageResource(R.drawable.duanzi1);
                mainTvDianzi.setTextColor(Color.parseColor("#C5C5C5"));
                mainImgShiping.setImageResource(R.drawable.shiping2);
                mainTvShipin.setTextColor(Color.parseColor("#1296DB"));
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, new ShipinFragment()).commit();
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void initView() {
        initStatusBar(Color.parseColor("#03A9F4"));
        ButterKnife.bind(this);
        mainImgTuijian.setImageResource(R.drawable.tuijian2);
        mainTvTuijain.setTextColor(Color.parseColor("#1296DB"));
        mainImgDuanzi.setImageResource(R.drawable.duanzi1);
        mainTvDianzi.setTextColor(Color.parseColor("#C5C5C5"));
        mainImgShiping.setImageResource(R.drawable.shiping1);
        mainTvShipin.setTextColor(Color.parseColor("#C5C5C5"));
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, new TuijianFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fl, new LeftFragment()).commit();
        mainDl.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                drawerView.setClickable(true);

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

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
    public BasePresenter binView() {
        return null;
    }
}

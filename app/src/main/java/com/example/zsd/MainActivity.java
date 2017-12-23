package com.example.zsd;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.example.zsd.activity.ChuangzuoActivity;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.base.BasePresenter;
import com.example.zsd.fragment.DuanziFragment;
import com.example.zsd.fragment.FaxianFragment;
import com.example.zsd.fragment.LeftFragment;
import com.example.zsd.fragment.ShipinFragment;
import com.example.zsd.fragment.TuijianFragment;
import com.example.zsd.utils.GlideCircleTransform;
import com.example.zsd.utils.ShareprefrensUtils;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    private ImageView iconImg;
    private DrawerLayout mainDl;
    private TextView title;
    private Fragment currentFragment;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setListener() {

    }

    @Override
    public void Click(View view) {
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void initView() {
        final DuanziFragment duanziFragment = new DuanziFragment();
        final ShipinFragment shipinFragment = new ShipinFragment();
        final TuijianFragment tuijianFragment = new TuijianFragment();
        final FaxianFragment faxianFragment = new FaxianFragment();
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        title = findViewById(R.id.main_tv_title);
        iconImg = findViewById(R.id.img_icon);
        final FrameLayout fl = findViewById(R.id.main_fl);
        mainDl = findViewById(R.id.main_dl);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fl, new LeftFragment()).commit();
        iconImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainDl.openDrawer(Gravity.LEFT);
                String icon = (String) ShareprefrensUtils.get(MainActivity.this, "icon", "");
                System.out.println("icon ================= " + icon);
                RequestOptions options = new RequestOptions()
                        .centerCrop()
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .priority(Priority.HIGH)
                        .transform(new GlideCircleTransform());
                //调用glide显示图片：
                Glide.with(MainActivity.this).load(icon).apply(options).into(iconImg);
            }
        });
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_favorites) {
                    // The tab with id R.id.tab_favorites was selected,
                    // change your content accordingly.
                    title.setText("段子");
                    switchFragment(duanziFragment).commit();
                }
                if (tabId == R.id.tab_recents) {
                    // The tab with id R.id.tab_favorites was reselected,
                    // change your content accordingly.
                    title.setText("推荐");
                    switchFragment(tuijianFragment).commit();
                }
                if (tabId == R.id.tab_nearby) {
                    // The tab with id R.id.tab_favorites was reselected,
                    // change your content accordingly.
                    title.setText("视频");
                    switchFragment(shipinFragment).commit();
                }
                if (tabId == R.id.tab_friends) {
                    // The tab with id R.id.tab_favorites was reselected,
                    // change your content accordingly.
                    title.setText("发现");
                    switchFragment(faxianFragment).commit();
                }
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
    private FragmentTransaction switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        if (!targetFragment.isAdded()) {
            //第一次使用switchFragment()时currentFragment为null，所以要判断一下
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
            transaction.add(R.id.frame_main, targetFragment, targetFragment.getClass().getName());
        } else {
            transaction
                    .hide(currentFragment)
                    .show(targetFragment);
        }
        currentFragment = targetFragment;
        return transaction;
    }

}

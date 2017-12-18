package com.example.zsd.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.example.zsd.R;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.GetVideosDetail;
import com.example.zsd.presenter.GetVideosDetailPresenter;
import com.example.zsd.view.GetVideosDetailView;

import java.util.List;

public class ShipinXiangqingActivity1 extends BaseActivity<GetVideosDetailPresenter> implements GetVideosDetailView {

    private TextView desc;
    private ImageView icon;
    private RelativeLayout ivv;

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
        ivv = findViewById(R.id.xiangqing_player);
        desc = findViewById(R.id.xiangqing_tv_title);
        icon = findViewById(R.id.xiangqing_iv_icon);
        ivv = findViewById(R.id.xiangqing_player);
        Intent intent1 = getIntent();
        String wid = intent1.getStringExtra("wid");
        showToast(wid);
        t.getVideosDetailData(wid);
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
    public void getVideosDetailSuccess(GetVideosDetail getVideosDetail) {
        showToast(getVideosDetail.msg);
        desc.setText(getVideosDetail.data.workDesc);
        Glide.with(this).load(getVideosDetail.data.user.icon).into(icon);
        View player = View.inflate(this, R.layout.simple_player_view_player, ivv);
        PlayerView playerView = new PlayerView(this,player)
                .setTitle(getVideosDetail.data.videoUrl)
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource(getVideosDetail.data.videoUrl)
                .startPlay();
    }

    @Override
    public void getVideosDetailFailure(String msg) {

        showToast(msg);
    }
}

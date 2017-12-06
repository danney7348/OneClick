package com.example.zsd.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.example.zsd.R;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.base.BasePresenter;

import java.util.List;

public class YuLanActivity extends BaseActivity {
    private RelativeLayout rl;
    private Button bt_xiayibu;
    private String videourl;
    @Override
    public int bindLayout() {
        return R.layout.activity_yu_lan;
    }

    @Override
    public void setListener() {

    }

    @Override
    public void Click(View view) {
        switch (view.getId())
        {
            case R.id.bt_xiayibu:
                Bundle bundle=new Bundle();
                bundle.putString("videourl",videourl);
                startActivity(SelectCoverActivity.class,bundle);
                break;
        }
    }

    @Override
    public void initView() {
        rl = findViewById(R.id.rl);
        bt_xiayibu = findViewById(R.id.bt_xiayibu);
        Intent intent = getIntent();
        videourl = intent.getStringExtra("videourl");
        View player = View.inflate(this, R.layout.simple_player_view_player,rl);

        PlayerView playerView = new PlayerView(this, player);
        playerView.setScaleType(PlayStateParams.fitparent);
        playerView.hideMenu(true);
        playerView.forbidTouch(false);
        playerView.setPlaySource(videourl);
        playerView.startPlay();

        bt_xiayibu.setOnClickListener(this);
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

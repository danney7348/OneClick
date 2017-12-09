package com.example.zsd.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dou361.ijkplayer.widget.IjkVideoView;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.example.zsd.R;

public class ShipinXiangqingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipin_xiangqing);
        IjkVideoView ivv = findViewById(R.id.shipin_ivv);
        Intent intent = getIntent();
        String videoUrl = intent.getStringExtra("videoUrl");
        View player = View.inflate(this, R.layout.simple_player_view_player, ivv);
        PlayerView playerView = new PlayerView(this,player)
                .setTitle(videoUrl)
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource(videoUrl)
                .startPlay();
    }

}

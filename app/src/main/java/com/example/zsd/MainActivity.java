package com.example.zsd;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zsd.base.BaseActivity;

public class MainActivity extends BaseActivity {

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

        initStatusBar(Color.parseColor("#ff0000"));
    }

    @Override
    public void initData() {

    }

}

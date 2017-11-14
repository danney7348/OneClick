package com.example.zsd.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zsd.R;
import com.umeng.analytics.MobclickAgent;

public class QiDongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qi_dong);
    }
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}

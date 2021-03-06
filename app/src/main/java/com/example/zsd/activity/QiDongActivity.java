package com.example.zsd.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zsd.MainActivity;
import com.example.zsd.R;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.base.BasePresenter;
import com.example.zsd.utils.ShareprefrensUtils;
import com.squareup.haha.perflib.Main;
import com.umeng.analytics.MobclickAgent;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

public class QiDongActivity extends BaseActivity {
    int i = 3;


    @Override
    public int bindLayout() {
        setStatus(true);
        setFullScreen(true);
        return R.layout.activity_qi_dong;
    }

    @Override
    public void setListener() {

    }

    @Override
    public void Click(View view) {


    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {

        System.out.println(" ============= " );
        final Timer timer = new Timer();
        final TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("i = " + i);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(i > 0){
                            i--;
                        }else if(i == 0){
                            startActivity(LoginActivity.class);
                            finish();
                            timer.cancel();
                        }else {
                            timer.cancel();
                        }
                    }
                });

            }
        };
        timer.schedule(task,1000,1000);
    }

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }

    @Override
    public BasePresenter binView() {
        return null;
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

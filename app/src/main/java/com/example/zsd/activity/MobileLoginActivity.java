package com.example.zsd.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.zsd.MainActivity;
import com.example.zsd.R;
import com.example.zsd.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MobileLoginActivity extends BaseActivity {

    @BindView(R.id.tv_zhucezhanghao)
    TextView tvZhucezhanghao;

    @Override
    public int bindLayout() {
        return R.layout.activity_mobilelogin;
    }

    @Override
    public void setListener() {

    }
    @OnClick({R.id.tv_zhucezhanghao, R.id.login_btn_login})
    @Override
    public void Click(View view) {
        switch (view.getId()) {
            case R.id.tv_zhucezhanghao:
                startActivity(MobileZhuceActivity.class);
                break;
            case R.id.login_btn_login:
                startActivity(MainActivity.class);
                break;
        }
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {

    }

}

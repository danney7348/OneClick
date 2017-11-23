package com.example.zsd.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zsd.R;
import com.example.zsd.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.relativeLayout2)
    RelativeLayout relativeLayout2;
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;
    @BindView(R.id.login_tv)
    TextView loginTv;

    @Override
    public int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void setListener() {

    }
    @OnClick({R.id.iv_back, R.id.relativeLayout2, R.id.relativeLayout, R.id.login_tv})
    @Override
    public void Click(View view) {
            switch (view.getId()) {
                case R.id.iv_back:
                    showToast("返回");
                    break;
                case R.id.relativeLayout2:
                    showToast("微信支付");
                    break;
                case R.id.relativeLayout:
                    showToast("扣扣登陆");
                    break;
                case R.id.login_tv:
                    startActivity(ZhuceActivity.class);
                    break;
        }
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        setFullScreen(true);
        setStatus(true);
    }

    @Override
    public void initData() {

    }

}

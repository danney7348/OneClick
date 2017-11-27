package com.example.zsd.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zsd.MainActivity;
import com.example.zsd.R;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.base.BasePresenter;
import com.example.zsd.presenter.UserLoginPresenter;
import com.example.zsd.view.UserLoginView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MobileLoginActivity extends BaseActivity implements UserLoginView {

    @BindView(R.id.tv_zhucezhanghao)
    TextView tvZhucezhanghao;
    @BindView(R.id.login_et_zhanghao)
    EditText loginEtZhanghao;
    @BindView(R.id.login_et_mima)
    EditText loginEtMima;
    private UserLoginPresenter userLoginPresenter;

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
                String pass = loginEtZhanghao.getText().toString();
                String user = loginEtMima.getText().toString();
                if(TextUtils.isEmpty(user)||TextUtils.isEmpty(pass)){
                    showToast("用户名或密码为空");
                    return;
                }
                userLoginPresenter.getUserLoginData(loginEtZhanghao.getText().toString(), loginEtMima.getText().toString(), null);
                break;
        }
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        userLoginPresenter = new UserLoginPresenter(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public List<BasePresenter> initPresenter() {
        List<BasePresenter> list = new ArrayList<>();
        list.add(userLoginPresenter);
        return list;
    }

    @Override
    public void success() {

    }

    @Override
    public void failure() {

    }

    @Override
    public void userloginSuccess(String value) {
        showToast(value);
        startActivity(MainActivity.class);
    }

    @Override
    public void userloginFailue(String value) {
        showToast(value);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

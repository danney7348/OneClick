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
import com.example.zsd.entity.LoginBean;
import com.example.zsd.presenter.UserLoginPresenter;
import com.example.zsd.view.UserLoginView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MobileLoginActivity extends BaseActivity<UserLoginPresenter> implements UserLoginView {

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
                t.getUserLoginData(loginEtZhanghao.getText().toString(), loginEtMima.getText().toString());
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
    public UserLoginPresenter binView() {
        return new UserLoginPresenter(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void success(LoginBean loginBean) {

        showToast(loginBean.msg);
        showToast(loginBean.msg);
        getSharedPreferences("TOKEN",MODE_PRIVATE).edit().putString("token",loginBean.data.token).commit();
        System.out.println("getSharedPreferences"+getSharedPreferences("TOKEN",MODE_PRIVATE).getString("token",null));
        startActivity(MainActivity.class);

    }

    @Override
    public void failure(String msg) {
        showToast(msg);
        System.out.println("=====failure========"+msg+"=============");
    }

    @Override
    public void error(String msg) {
        System.out.println("======error======="+msg+"=============");
        showToast(msg);
    }
}

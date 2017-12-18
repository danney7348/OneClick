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
import com.example.zsd.utils.ShareprefrensUtils;
import com.example.zsd.view.UserLoginView;
import com.squareup.haha.perflib.Main;

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

    private boolean isFirst = false;

    @Override
    public int bindLayout() {

        return R.layout.activity_mobilelogin;
    }

    @Override
    public void setListener() {

    }

    @OnClick({R.id.tv_zhucezhanghao, R.id.login_btn_login,R.id.login_tv_youkelogin})
    @Override
    public void Click(View view) {
        switch (view.getId()) {
            case R.id.tv_zhucezhanghao:
                startActivity(MobileZhuceActivity.class);
                finish();
                break;
            case R.id.login_tv_youkelogin:
                startActivity(MainActivity.class);
                finish();
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
        Boolean first = (Boolean) ShareprefrensUtils.get(this, "isFirst", this.isFirst);
        System.out.println("first ============== " + first);
        if(first){
            startActivity(MainActivity.class);
            finish();
        }
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
    public void success(LoginBean loginBean) {
        isFirst = true;
        ShareprefrensUtils.put(this,"isFirst",isFirst);

        showToast(loginBean.msg);
        ShareprefrensUtils.put(this,"token",loginBean.data.token);
        ShareprefrensUtils.put(this,"uid",loginBean.data.uid+"");
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

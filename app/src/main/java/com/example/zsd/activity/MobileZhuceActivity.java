package com.example.zsd.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zsd.MainActivity;
import com.example.zsd.R;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.base.BasePresenter;
import com.example.zsd.presenter.UserRegPresenter;
import com.example.zsd.view.UserRegView;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MobileZhuceActivity extends BaseActivity implements UserRegView {

    @BindView(R.id.zhuce_mobile)
    EditText zhuceMobile;
    @BindView(R.id.zhuce_mima)
    EditText zhuceMima;
    @BindView(R.id.zhuce_btn)
    Button zhuceBtn;
    private UserRegPresenter userRegPresenter;

    @Override
    public int bindLayout() {
        return R.layout.activity_mobile_zhuce;
    }

    @Override
    public void setListener() {

    }
    @OnClick(R.id.zhuce_btn)
    @Override
    public void Click(View view) {
        switch (view.getId()){
            case R.id.zhuce_btn:
                String pass = zhuceMobile.getText().toString();
                String user = zhuceMima.getText().toString();
                if(TextUtils.isEmpty(user)||TextUtils.isEmpty(pass)){
                    showToast("用户名或密码为空");
                    return;
                }
                userRegPresenter.getUserRegData(0+"",zhuceMobile.getText().toString(),zhuceMima.getText().toString(),null);
                signup();
                showToast("走完了");
                break;
        }
    }

    private void signup() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    EMClient.getInstance().createAccount(zhuceMobile.getText().toString().trim(),zhuceMima.getText().toString().trim());
                    System.out.println("注册成功");
                    showToast("注册成功");
                } catch (HyphenateException e) {
                    e.printStackTrace();
                    showToast("注册失败");
                }

            }
        }).start();
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        userRegPresenter = new UserRegPresenter(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public List<BasePresenter> initPresenter() {
        List<BasePresenter> list = new ArrayList<>();
        list.add(userRegPresenter);
        return list;
    }

    @Override
    public BasePresenter binView() {
        return null;
    }



    @Override
    public void userregSuccess(String string) {
        showToast(string+zhuceMobile.getText().toString()+"成功了！");
    }

    @Override
    public void userregFailue(String string) {
        showToast(string+zhuceMobile.getText().toString()+"失败了！");
    }

    @Override
    public void success(Object o) {

    }

    @Override
    public void failure(String msg) {

    }

    @Override
    public void error(String msg) {

    }
}

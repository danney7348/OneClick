package com.example.zsd.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.zsd.R;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.base.BasePresenter;
import com.example.zsd.utils.ShareprefrensUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShezhiActivity extends BaseActivity {

    @BindView(R.id.shezhi_rl_check_version)
    RelativeLayout shezhiRlCheckVersion;
    @BindView(R.id.shezhi_rl_yijianfankui)
    RelativeLayout shezhiRlYijianfankui;
    @BindView(R.id.shezhi_rl_about_querter)
    RelativeLayout shezhiRlAboutQuerter;
    @BindView(R.id.shezhi_rl_clear_huncun)
    RelativeLayout shezhiRlClearHuncun;
    @BindView(R.id.shezhi_login_clear)
    Button shezhiLoginClear;

    @Override
    public int bindLayout() {
        return R.layout.activity_shezhi;
    }

    @Override
    public void setListener() {

    }
    @OnClick({R.id.shezhi_rl_check_version, R.id.shezhi_rl_yijianfankui, R.id.shezhi_rl_about_querter, R.id.shezhi_rl_clear_huncun, R.id.shezhi_login_clear})
    @Override
    public void Click(View view) {
        switch (view.getId()) {
            case R.id.shezhi_rl_check_version:
                break;
            case R.id.shezhi_rl_yijianfankui:
                break;
            case R.id.shezhi_rl_about_querter:
                break;
            case R.id.shezhi_rl_clear_huncun:
                break;

            case R.id.shezhi_login_clear:
                AlertDialog.Builder ad = new AlertDialog.Builder(this)
                        .setTitle("是否清除数据")
                        .setNegativeButton("取消",null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ShareprefrensUtils.clear(ShezhiActivity.this);
                            }
                        });
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

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }

    @Override
    public BasePresenter binView() {
        return null;
    }

}

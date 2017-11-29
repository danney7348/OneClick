package com.example.zsd.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zsd.R;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.PublishJoke;
import com.example.zsd.fragment.DuanziFragment;
import com.example.zsd.presenter.GetPublishJokePresenter;
import com.example.zsd.view.GetPublishJokeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class BianxieDuanziActivity extends BaseActivity<GetPublishJokePresenter> implements GetPublishJokeView {

    private PopupWindow mPopWindow;
    private RelativeLayout rl;
    private EditText ed_fabiao;

    @Override
    public int bindLayout() {
        return R.layout.activity_bianxie_duanzi;
    }

    @Override
    public void setListener() {

    }

    @OnClick({R.id.bianxie_tv_duanzi_quxiao, R.id.bianxie_tv_fabiao})
    @Override
    public void Click(View view) {
        switch (view.getId()) {
            case R.id.bianxie_tv_duanzi_quxiao:
                View rootview = LayoutInflater.from(this).inflate(R.layout.activity_bianxie_duanzi, null);
                mPopWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);
                //实例化一个ColorDrawable颜色为半透明
                ColorDrawable dw = new ColorDrawable(0xb0000000);
                //设置SelectPicPopupWindow弹出窗体的背景
                rl.setBackgroundDrawable(dw);
                break;
            case R.id.bianxie_tv_fabiao:
                System.out.println(getSharedPreferences("TOKEN", MODE_PRIVATE).getString("uid", null) + "++++++++++++");
                t.getPublishJokeData("170", ed_fabiao.getText().toString());
                showToast("我走了");
                break;
            case R.id.pop_finish:
                ColorDrawable dw1 = new ColorDrawable(0000000);
                //设置SelectPicPopupWindow弹出窗体的背景
                rl.setBackgroundDrawable(dw1);
                mPopWindow.dismiss();
                break;
        }
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        View contentView = LayoutInflater.from(BianxieDuanziActivity.this).inflate(R.layout.popw_layout, null);
        mPopWindow = new PopupWindow(contentView);
        mPopWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        TextView tv1 = contentView.findViewById(R.id.pop_baocun);
        TextView tv2 = contentView.findViewById(R.id.pop_bubaocun);
        TextView tv3 = contentView.findViewById(R.id.pop_finish);
        TextView tv = findViewById(R.id.bianxie_tv_fabiao);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        TextView tv_duanzi_quxiao = findViewById(R.id.bianxie_tv_duanzi_quxiao);
        rl = findViewById(R.id.rl1);
        tv_duanzi_quxiao.setOnClickListener(this);
        tv.setOnClickListener(this);
        ed_fabiao = findViewById(R.id.ed_fabiao);
    }

    @Override
    public void initData() {

    }

    @Override
    public List<BasePresenter> initPresenter() {
        List<BasePresenter> list = new ArrayList<>();
        return list;
    }

    @Override
    public GetPublishJokePresenter binView() {
        return new GetPublishJokePresenter(this);
    }

    @Override
    public void getPublishJokeSuccess(PublishJoke value) {
        showToast(value.msg + "=============");
        Intent intent = new Intent(this, DuanziFragment.class);
        startActivity(intent);
    }

    @Override
    public void getPublishJokeFaliure(String s) {

        showToast(s + "////////////////");
    }

    @Override
    public void getPublishJokeTokenFaliure(String s) {
        showToast(s + "===============");
    }

    @Override
    public void success(Object o) {

    }

    @Override
    public void failure(String msg) {

        showToast(msg + "++++++++++++++");
    }

    @Override
    public void error(String msg) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bianxie_iv_add)
    public void onViewClicked() {
    }
}

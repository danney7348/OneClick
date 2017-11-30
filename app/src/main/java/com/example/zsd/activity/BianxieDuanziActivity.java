package com.example.zsd.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zsd.R;
import com.example.zsd.adapter.AddImagesAdapter;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.PublishJoke;
import com.example.zsd.fragment.DuanziFragment;
import com.example.zsd.presenter.GetPublishJokePresenter;
import com.example.zsd.utils.GlideLoader;
import com.example.zsd.view.GetPublishJokeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.yancy.imageselector.ImageConfig;
import com.yancy.imageselector.ImageSelector;
import com.yancy.imageselector.ImageSelectorActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BianxieDuanziActivity extends BaseActivity<GetPublishJokePresenter> implements GetPublishJokeView {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    private PopupWindow mPopWindow;
    private RelativeLayout rl;
    private EditText ed_fabiao;
    private ImageView bianxie_iv_add;
    private ArrayList<String> path = new ArrayList<>();
    private AddImagesAdapter adapter;
    private List<String> pathList;

    @Override
    public int bindLayout() {
        return R.layout.activity_bianxie_duanzi;
    }

    @Override
    public void setListener() {

    }

    @OnClick({R.id.bianxie_tv_duanzi_quxiao, R.id.bianxie_tv_fabiao, R.id.bianxie_iv_add})
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
                t.getPublishJokeData("170", ed_fabiao.getText().toString(),path);
                showToast("我走了");
                break;
            case R.id.pop_finish:
                ColorDrawable dw1 = new ColorDrawable(0000000);
                //设置SelectPicPopupWindow弹出窗体的背景
                rl.setBackgroundDrawable(dw1);
                mPopWindow.dismiss();
                break;
            case R.id.bianxie_iv_add:
                ImageConfig imageConfig
                        = new ImageConfig.Builder(
                        // GlideLoader 可用自己用的缓存库
                        new GlideLoader())
                        // 如果在 4.4 以上，则修改状态栏颜色 （默认黑色）
                        .steepToolBarColor(getResources().getColor(R.color.blue))
                        // 标题的背景颜色 （默认黑色）
                        .titleBgColor(getResources().getColor(R.color.blue))
                        // 提交按钮字体的颜色  （默认白色）
                        .titleSubmitTextColor(getResources().getColor(R.color.white))
                        // 标题颜色 （默认白色）
                        .titleTextColor(getResources().getColor(R.color.white))
                        // 开启多选   （默认为多选）  (单选 为 singleSelect)
                       // .singleSelect()
//                        .crop()
                        // 多选时的最大数量   （默认 9 张）
                        .mutiSelectMaxSize(9)
                        // 已选择的图片路径
                        .pathList(path)
                        // 拍照后存放的图片路径（默认 /temp/picture）
                        .filePath("/ImageSelector/Pictures")
                        // 开启拍照功能 （默认开启）
                        .showCamera()
                        .requestCode(REQUEST_CODE)
                        .build();
                ImageSelector.open(BianxieDuanziActivity.this, imageConfig); // 开启图片选择器
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
                recycler.setLayoutManager(gridLayoutManager);
                adapter = new AddImagesAdapter(this, path);
                recycler.setAdapter(adapter);
                break;
        }
    }
    public static final int REQUEST_CODE = 1000;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            pathList = data.getStringArrayListExtra(ImageSelectorActivity.EXTRA_RESULT);
           /* List<File> listFile = new ArrayList<>();
            for (int i = 0; i < pathList.size(); i++) {
                File file = new File(pathList.get(i));
                listFile.add(file);
            }*/
            for (String path : pathList) {
                Log.i("ImagePathList", path);
            }
            path.clear();
            path.addAll(pathList);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        bianxie_iv_add = findViewById(R.id.bianxie_iv_add);
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
        /*Intent intent = new Intent(this, DuanziFragment.class);
        startActivity(intent);*/
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

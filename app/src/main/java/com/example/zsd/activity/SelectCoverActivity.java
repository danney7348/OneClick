package com.example.zsd.activity;

import android.graphics.Color;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.zsd.R;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.PublishVideo;
import com.example.zsd.presenter.PublishVideoPresenter;
import com.example.zsd.utils.GlideLoader;
import com.example.zsd.utils.ShareprefrensUtils;
import com.example.zsd.view.PublishVideoView;
import com.yancy.imageselector.ImageConfig;
import com.yancy.imageselector.ImageSelector;
import com.yancy.imageselector.ImageSelectorActivity;

import java.util.List;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import java.io.File;
import java.util.ArrayList;

public class SelectCoverActivity extends BaseActivity<PublishVideoPresenter> implements PublishVideoView {
    private Button bt_cover;
    private ArrayList<String> path = new ArrayList<>();
    private ImageView cover_iv_head;
    private EditText et_desc;
    private String desc;
    private Button bt_publish;
    private File cover;
    private File video;
    private String videourl;
    private String latitude;
    private String longitude;

    @Override
    public int bindLayout() {
        return R.layout.activity_select_cover;
    }

    @Override
    public void setListener() {

    }

    @Override
    public void Click(View view) {
        switch (view.getId())
        {
            case R.id.bt_cover:
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
                         .singleSelect()
                         .crop()
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
                ImageSelector.open(SelectCoverActivity.this, imageConfig); // 开启图片选择器
                break;

            case R.id.bt_publish:
                desc = et_desc.getText().toString();
                System.out.println(video+"             "+cover);
                String uid = (String) ShareprefrensUtils.get(SelectCoverActivity.this, "uid", "");
                if(path!=null){
                    File fileVideo = new File(videourl);
                    t.getPublishVideosData(uid,fileVideo,cover,desc,latitude+"",longitude+"");
                }
                showToast("点击了");
                break;
        }
    }
    public static final int REQUEST_CODE = 1000;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            List<String> pathList = data.getStringArrayListExtra(ImageSelectorActivity.EXTRA_RESULT);
            for (String s : pathList) {
                Glide.with(this).load(s).into(cover_iv_head);
                cover = new File(s);
                System.out.println("s ======================================= " + s);
            }
            path.clear();
            path.addAll(pathList);


        }
    }
    @Override
    public void initView() {
        //ImmersionUtil.TransparentStatusbar(this);
        Intent intent = getIntent();
        videourl = intent.getStringExtra("videourl");
        latitude = intent.getStringExtra("latitude");
        longitude = intent.getStringExtra("longitude");
        video = new File(videourl);
        System.out.println("=======传过来的视频路径======="+ video);
        bt_cover = findViewById(R.id.bt_cover);
        cover_iv_head = findViewById(R.id.cover_iv_head);
        et_desc = findViewById(R.id.et_desc);
        bt_publish = findViewById(R.id.bt_publish);
        bt_publish.setOnClickListener(this);

        bt_cover.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }

    @Override
    public PublishVideoPresenter binView() {
        return new PublishVideoPresenter(this);
    }

    @Override
    public void success(PublishVideo publishVideo) {
        showToast(publishVideo.msg);
        startActivity(FabiaoSuccessActivity.class);
    }

    @Override
    public void error(String msg) {

    }

    @Override
    public void failure(String msg) {

    }
}

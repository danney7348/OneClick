package com.example.zsd.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.zsd.R;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.GetVersion;
import com.example.zsd.presenter.GetVersionPresenter;
import com.example.zsd.utils.UpdateManager;
import com.example.zsd.view.GetVersionView;

import java.io.File;
import java.util.List;

import android.content.Context;
import android.view.View.OnClickListener;

public class CheckVersionActivity extends BaseActivity<GetVersionPresenter> implements GetVersionView {
    private TextView textView;
    public static int version,serverVersion;
    public static String versionName,serverVersionName,downloadResult;
    private Button btn;
    private ProgressBar proBar;
    public static receiveVersionHandler handler;
    private UpdateManager manager = UpdateManager.getInstance();
    private String apkUrl;
    private String versionCode;
    private String versionName1;

    @Override
    public int bindLayout() {
        return R.layout.activity_check_version;
    }

    @Override
    public void setListener() {

    }

    @Override
    public void Click(View view) {

    }

    @Override
    public void initView() {
        textView = findViewById(R.id.textview_id);
        btn = findViewById(R.id.version_btn);
        proBar=findViewById(R.id.progressBar_id);
        t.getVersionData();
        Context c = this;
        version = manager.getVersion(c);
        versionName = manager.getVersionName(c);

        textView.setText("当前版本号:"+versionCode);

        handler = new receiveVersionHandler();

        //检查更新按钮点击事件
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.compareVersion(CheckVersionActivity.this,apkUrl);
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }

    @Override
    public GetVersionPresenter binView() {
        return new GetVersionPresenter(this);
    }

    @Override
    public void success(GetVersion getVersion) {
        showToast(getVersion.msg);
        apkUrl = getVersion.data.apkUrl;
        versionCode = getVersion.data.versionCode;
        versionName1 = getVersion.data.versionName;
    }

    @Override
    public void error(String msg) {
        showToast(msg);
    }

    @Override
    public void failure(String msg) {
        showToast(msg);
    }

    public class receiveVersionHandler extends Handler {
        @SuppressLint("WrongConstant")
        @Override
        public void handleMessage(Message msg) {
            proBar.setProgress(msg.arg1);
            proBar.setVisibility(View.VISIBLE);
            textView.setText("下载进度："+msg.arg1);
            if(msg.arg1 == 100){
                Intent intent = new Intent(Intent.ACTION_VIEW);
                String path = Environment.getExternalStorageDirectory()+"/AndroidUpdateDemo.apk";
                intent.setDataAndType(Uri.fromFile(new File(path)),
                        "application/vnd.android.package-archive");
                startActivity(intent);
            }
            proBar.setVisibility(View.VISIBLE);
        }

    }
}

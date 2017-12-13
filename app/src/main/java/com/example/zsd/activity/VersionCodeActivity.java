package com.example.zsd.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zsd.R;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.GetVersion;
import com.example.zsd.presenter.GetVersionPresenter;
import com.example.zsd.utils.Config;
import com.example.zsd.view.GetVersionView;

import junit.runner.Version;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.util.List;

public class VersionCodeActivity extends BaseActivity<GetVersionPresenter> implements GetVersionView {
    private ProgressDialog progressDialog;//加载框
    private Callback.Cancelable cancelable;//请求任务对象
    private String apkUrl;
    private String versionCode;
    private String versionName;
    private Button version_btn;

    @Override
    public int bindLayout() {
        return R.layout.activity_version_code;
    }

    @Override
    public void setListener() {

    }

    @Override
    public void Click(View view)  {

    }

    private void downloadApk(String apkUrl) {
        final RequestParams request = new RequestParams(apkUrl);
        request.setAutoResume(true);//设置是否支持断点下载
        request.setCancelFast(true);//设置是否立即取消
        //判断sdcard是否可用
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {//判断sdcard存在并且可用

            request.setSaveFilePath(Config.VERSION_PATH);//自己创建的一个类，里面存放了下载路径public static final String VERSION_PATH = Environment.getExternalStorageDirectory()+"/danney/versions.apk";
        }

        cancelable = x.http().get(request, new Callback.ProgressCallback<File>() {
            @Override
            public void onSuccess(File result) {

                progressDialog.dismiss();

                System.out.println("filepath====" + result.getAbsolutePath());

                install(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public void onWaiting() {

            }

            @Override
            public void onStarted() {
                progressDialog.show();

            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                if (isDownloading) {
                    progressDialog.setMax((int) total);
                    progressDialog.setProgress((int) current);
                    progressDialog.setTitle("下载进度");
                    System.out.println("current:" + (int) current * 100 / total);
                }
            }
        });
    }

    @Override
    public void initView() {
        t.getVersionData();
        version_btn = findViewById(R.id.version_btn);
        version_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("走了================");
                PackageManager manager = getPackageManager();
                PackageInfo info  = null;
                try {
                    info = manager.getPackageInfo(getPackageName(), 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                int versionCode1 = info.versionCode;
                System.out.println("versionCode1 = " + versionCode1);
                System.out.println("versionCode = " + versionCode);
                if (versionCode1 < Integer.parseInt(versionCode)) {
                    // File file = new File(Config.VERSION_PATH);
                    //System.out.println("file = " + file.getAbsolutePath());
                    downloadApk(apkUrl);
                }else {
                    showToast("当前为最新版本");
                }
            }
        });

    }

    @Override
    public void initData() {
        initDialog();
    }

    private void initDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        progressDialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "暂停", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //取消下载任务
                cancelable.cancel();
            }
        });
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
        System.out.println("apkUrl ============================= " + apkUrl);
        versionCode = getVersion.data.versionCode;
        versionName = getVersion.data.versionName;

    }

    @Override
    public void error(String msg) {

    }

    @Override
    public void failure(String msg) {

    }
    private void install(File file) {
        //调用系统安装器
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.parse("file://" + file.getAbsolutePath()), "application/vnd.android.package-archive");
        startActivity(intent);
    }
}

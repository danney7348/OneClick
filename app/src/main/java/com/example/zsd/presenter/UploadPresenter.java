package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.base.BaseView;
import com.example.zsd.entity.Upload;
import com.example.zsd.model.UploadModel;
import com.example.zsd.view.UploadView;

/**
 * 作者： 张少丹
 * 时间：  2017/11/30.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class UploadPresenter extends BasePresenter implements UploadModel.GetUpload {
    private UploadModel uploadModel;
    private UploadView uploadView;

    public UploadPresenter(BaseView mView) {
        super(mView);
        this.uploadView = uploadView;
        if(uploadModel == null){
            uploadModel = new UploadModel();
        }
        uploadModel.setGetUpload(this);
    }


    public void getUploadData(String uid,String path){
        uploadModel.getUpload(uid,path);
    }
    @Override
    public void getUploadSuccess(Upload value) {
        mView.success(value);
    }

    @Override
    public void getUploadFailure(String msg) {
        mView.failure(msg);
    }
}

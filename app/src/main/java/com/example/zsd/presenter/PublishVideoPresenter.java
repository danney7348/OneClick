package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.PublishVideo;
import com.example.zsd.model.PublishVideoModel;
import com.example.zsd.view.PublishVideoView;

import java.io.File;

/**
 * 作者： 张少丹
 * 时间：  2017/12/4.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class PublishVideoPresenter extends BasePresenter<PublishVideoView> implements PublishVideoModel.GetPublishVideoMessage {
    private PublishVideoModel publishVideoModel;
    public PublishVideoPresenter(PublishVideoView mView) {
        super(mView);
        if(publishVideoModel == null){
            publishVideoModel = new PublishVideoModel();
        }
        publishVideoModel.setGetPublishVideoMessage(this);
    }

    public void getPublishVideosData(String uid, File videoFile, File coverFile, String videoDesc, String latitude, String longitude){
        publishVideoModel.getPublishVideoData(uid,videoFile,coverFile,videoDesc,latitude,longitude);
    }
    @Override
    public void getPublishVideoSuccess(PublishVideo publishVideo) {
        mView.success(publishVideo);
    }

    @Override
    public void getPublishVideoFailure(String msg) {
        mView.failure(msg);
    }
}

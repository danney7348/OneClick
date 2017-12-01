package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.Follow;
import com.example.zsd.model.FollowModel;
import com.example.zsd.view.FollowView;

/**
 * 作者： 张少丹
 * 时间：  2017/12/1.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class FollowPresenter extends BasePresenter<FollowView> implements FollowModel.GetFollowMessage {
    private FollowModel followModel;
    public FollowPresenter(FollowView mView) {
        super(mView);
        if(followModel == null){
            followModel = new FollowModel();
        }
        followModel.setGetFollowMessage(this);
    }

    @Override
    public void getFollowSuccess(Follow value) {
        mView.success(value);
    }

    @Override
    public void getFollowFailure(String msg) {
        mView.failure(msg);
    }
}

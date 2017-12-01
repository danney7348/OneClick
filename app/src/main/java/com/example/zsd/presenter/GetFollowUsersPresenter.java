package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.GetFollowUsers;
import com.example.zsd.model.GetFollowUsersModel;
import com.example.zsd.view.GetFollowUsersView;

/**
 * 作者： 张少丹
 * 时间：  2017/12/1.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetFollowUsersPresenter extends BasePresenter<GetFollowUsersView> implements GetFollowUsersModel.GetFollowUsersMessage {
    private GetFollowUsersModel getFollowUsersModel;
    public GetFollowUsersPresenter(GetFollowUsersView mView) {
        super(mView);
        if(getFollowUsersModel == null){
            getFollowUsersModel = new GetFollowUsersModel();
        }
        getFollowUsersModel.setFollowUsersMessage(this);
    }

    @Override
    public void getFollowUsersSuccess(GetFollowUsers value) {
        mView.success(value);
    }

    @Override
    public void getFollowUsersFailure(String msg) {
        mView.failure(msg);
    }
}

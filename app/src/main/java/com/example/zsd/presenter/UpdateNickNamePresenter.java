package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.UpdateNickName;
import com.example.zsd.model.UpdateNickNameModel;
import com.example.zsd.view.UpdateNickNameView;

/**
 * 作者： 张少丹
 * 时间：  2017/11/30.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class UpdateNickNamePresenter extends BasePresenter<UpdateNickNameView> implements UpdateNickNameModel.UpdateNickNameMessage {
    private UpdateNickNameModel updateNickNameModel;
    public UpdateNickNamePresenter(UpdateNickNameView mView) {
        super(mView);
        if(updateNickNameModel == null){
            updateNickNameModel = new UpdateNickNameModel();
        }
        updateNickNameModel.setUpdateNickNameMessage(this);
    }

    public void updateNickNameData(String uid,String nickname){
        updateNickNameModel.getUpdateNickNameData(uid,nickname);
    }

    @Override
    public void updateNickNameScuuess(String msg) {
        mView.updateNickNameScuuess(msg);
    }

    @Override
    public void updateNickNameFailure(String msg) {
        mView.updateNickNameFailure(msg);

    }
}

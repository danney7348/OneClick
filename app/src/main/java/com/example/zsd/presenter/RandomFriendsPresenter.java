package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.RandomFriends;
import com.example.zsd.model.RandomFriendsCallBack;
import com.example.zsd.model.RandomFriendsModel;
import com.example.zsd.view.RandomFriendsView;

/**
 * 作者： 张少丹
 * 时间：  2017/12/16.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class RandomFriendsPresenter extends BasePresenter<RandomFriendsView> {
    private RandomFriendsModel randomFriendsModel;
    public RandomFriendsPresenter(RandomFriendsView mView) {
        super(mView);
        if(randomFriendsModel == null){
            randomFriendsModel = new RandomFriendsModel();
        }
    }
    public void getRandomFriendsData(){
        randomFriendsModel.getRandomFriendsData(new RandomFriendsCallBack() {
            @Override
            public void getRandomFriendsSuccess(RandomFriends randomFriends) {
                mView.getRandomFriendsSuccess(randomFriends);
            }

            @Override
            public void getRandomFriendsFailure(String msg) {
                mView.getRandomFriendsFailure(msg);
            }
        });
    }
}

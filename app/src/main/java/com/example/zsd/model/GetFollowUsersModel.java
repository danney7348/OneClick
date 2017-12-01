package com.example.zsd.model;

import com.example.zsd.entity.GetFollowUsers;
import com.example.zsd.utils.HttpUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者： 张少丹
 * 时间：  2017/12/1.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetFollowUsersModel {
    public void getFollowUsers(String uid){
        new HttpUtils.Builder()
                .addConverterFactory()
                .addCallAdapterFactory()
                .build()
                .getMyQusetUtils()
                .getFollowUsers(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetFollowUsers>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetFollowUsers value) {

                        if(value.code.equals("0")){
                            followUsersMessage.getFollowUsersSuccess(value);
                        }else{
                            followUsersMessage.getFollowUsersFailure(value.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
    private GetFollowUsersMessage followUsersMessage;

    public void setFollowUsersMessage(GetFollowUsersMessage followUsersMessage) {
        this.followUsersMessage = followUsersMessage;
    }

    public interface GetFollowUsersMessage{
        void getFollowUsersSuccess(GetFollowUsers value);
        void getFollowUsersFailure(String msg);
    }
}

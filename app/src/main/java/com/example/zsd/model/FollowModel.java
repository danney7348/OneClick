package com.example.zsd.model;

import com.example.zsd.entity.Follow;
import com.example.zsd.utils.HttpUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者： 张少丹
 * 时间：  2017/11/28.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class FollowModel {

    public void getFollow(String uid,String followId){
        new HttpUtils.Builder()
                .addCallAdapterFactory()
                .addConverterFactory()
                .build()
                .getMyQusetUtils()
                .getFollow(uid,followId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Follow>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Follow value) {

                        if(value.code.equals("0")){
                            getFollowMessage.getFollowSuccess(value);
                        }else {
                            getFollowMessage.getFollowFailure(value.msg);
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
    private GetFollowMessage getFollowMessage;

    public void setGetFollowMessage(GetFollowMessage getFollowMessage) {
        this.getFollowMessage = getFollowMessage;
    }

    public interface GetFollowMessage{
        void getFollowSuccess(Follow value);
        void getFollowFailure(String msg);
    }
}

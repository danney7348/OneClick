package com.example.zsd.model;

import com.example.zsd.entity.RandomFriends;
import com.example.zsd.utils.HttpUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * 作者： 张少丹
 * 时间：  2017/12/16.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class RandomFriendsModel implements IRandomFriendsModel {
    @Override
    public void getRandomFriendsData(final RandomFriendsCallBack randomFriendsCallBack) {
                new HttpUtils.Builder()
                        .addCallAdapterFactory()
                        .addConverterFactory()
                        .build()
                        .getMyQusetUtils()
                        .getRandomFriends()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSubscriber<RandomFriends>() {
                            @Override
                            public void onNext(RandomFriends randomFriends) {
                                if(randomFriends.code.equals("0")){
                                    randomFriendsCallBack.getRandomFriendsSuccess(randomFriends);
                                }else {
                                    randomFriendsCallBack.getRandomFriendsFailure(randomFriends.msg);
                                }
                            }

                            @Override
                            public void onError(Throwable t) {
                                randomFriendsCallBack.getRandomFriendsFailure(t.getMessage().toString());
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
    }
}

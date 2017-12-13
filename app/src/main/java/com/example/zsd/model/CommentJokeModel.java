package com.example.zsd.model;

import com.example.zsd.entity.CommentJoke;
import com.example.zsd.utils.HttpUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * 作者： 张少丹
 * 时间：  2017/12/13.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class CommentJokeModel implements ICommentJokeModel {

    private DisposableSubscriber<CommentJoke> disposableSubscriber;

    @Inject
    public CommentJokeModel() {
    }

    @Override
    public void getCommentJoke(String uid, String jid, String content, final CommentJokeCallBack commentJokeCallBack) {
        disposableSubscriber = new HttpUtils.Builder()
                .addCallAdapterFactory()
                .addConverterFactory()
                .build()
                .getMyQusetUtils()
                .getCommentJoke(uid, jid, content)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<CommentJoke>() {
                    @Override
                    public void onNext(CommentJoke commentJoke) {
                        if (commentJoke.code.equals("0")) {
                            commentJokeCallBack.getCommentJokeSuccess(commentJoke);
                        } else {
                            commentJokeCallBack.getCommentJokeFailure(commentJoke.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        commentJokeCallBack.getCommentJokeFailure(t.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void onDestry(){
        if(!disposableSubscriber.isDisposed()){
            disposableSubscriber.dispose();
        }
    }
}

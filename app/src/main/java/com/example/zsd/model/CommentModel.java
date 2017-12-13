package com.example.zsd.model;

import com.example.zsd.entity.CancelFavourite;
import com.example.zsd.entity.Comment;
import com.example.zsd.utils.HttpUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * 作者： 张少丹
 * 时间：  2017/12/11.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class CommentModel implements ICommentModel {

    @Inject
    public CommentModel() {
    }

    private DisposableSubscriber<Comment> disposableSubscriber;

    @Override
    public void getCommentData(String uid, String wid, final String content, final CommentCallBack commentCallBack) {
        disposableSubscriber = new HttpUtils.Builder()
                .addConverterFactory()
                .addCallAdapterFactory()
                .build()
                .getMyQusetUtils()
                .getComment(uid, wid, content)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<Comment>() {
                    @Override
                    public void onNext(Comment comment) {
                        if (comment.code.equals("0")) {
                            commentCallBack.getCommentSuccess(comment);
                        } else {
                            commentCallBack.getCommentFailure(comment.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        commentCallBack.getCommentFailure(t.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    public void onDestroy(){
        if(!disposableSubscriber.isDisposed()){
            disposableSubscriber.dispose();
        }
    }
}

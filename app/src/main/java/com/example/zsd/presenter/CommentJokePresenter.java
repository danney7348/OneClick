package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.CommentJoke;
import com.example.zsd.model.CommentJokeCallBack;
import com.example.zsd.model.CommentJokeModel;
import com.example.zsd.view.CommentJokeView;

import javax.inject.Inject;

/**
 * 作者： 张少丹
 * 时间：  2017/12/13.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class CommentJokePresenter extends BasePresenter<CommentJokeView>{

    @Inject
    CommentJokeModel commentJokeModel;
    @Inject
    public CommentJokePresenter(CommentJokeView mView) {
        super(mView);
    }
    public void getCommentJokeData(String uid,String jid,String connection){
        commentJokeModel.getCommentJoke(uid, jid, connection, new CommentJokeCallBack() {
            @Override
            public void getCommentJokeSuccess(CommentJoke commentJoke) {
                mView.getCommentJokeSuccess(commentJoke);
            }

            @Override
            public void getCommentJokeFailure(String msg) {
                mView.getCommentJokeFailure(msg);
            }
        });
    }
    public void onDestry(){
        commentJokeModel.onDestry();
    }
}

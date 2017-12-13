package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.Comment;
import com.example.zsd.model.CommentCallBack;
import com.example.zsd.model.CommentModel;
import com.example.zsd.view.CommentView;

import javax.inject.Inject;

/**
 * 作者： 张少丹
 * 时间：  2017/12/12.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class CommentPresenter extends BasePresenter<CommentView> {
    @Inject
    CommentModel commentModel;
    CommentPresenter commentPresenter;
    @Inject
    public CommentPresenter(CommentView mView) {
        super(mView);
    }
    public void getCommentData(String uid, String wid,String content){
        commentModel.getCommentData(uid, wid, content, new CommentCallBack() {
            @Override
            public void getCommentSuccess(Comment comment) {
                mView.getCommentSuccess(comment);
            }

            @Override
            public void getCommentFailure(String msg) {
                mView.getCommentFailure(msg);
            }
        });
    }
    public void ondestry(){
        commentModel.onDestroy();
    }
}

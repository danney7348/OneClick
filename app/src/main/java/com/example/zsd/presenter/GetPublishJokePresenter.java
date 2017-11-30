package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.PublishJoke;
import com.example.zsd.model.GetPublishJokeModel;
import com.example.zsd.view.GetPublishJokeView;

import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/11/28.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetPublishJokePresenter extends BasePresenter {
    private GetPublishJokeView getPublishJokeView;
    private GetPublishJokeModel getPublishJokeModel;
    public GetPublishJokePresenter(GetPublishJokeView getPublishJokeView) {
        super(getPublishJokeView);
        this.getPublishJokeView = getPublishJokeView;
        if(getPublishJokeModel == null){
            getPublishJokeModel = new GetPublishJokeModel();
        }
    }
    public void getPublishJokeData(String uid, String content, List<String> jokeFiles){
        getPublishJokeModel.getPublishJoke(uid, content,jokeFiles, new GetPublishJokeModel.GetPublishJokeMessage() {
            @Override
            public void getPublishJokeSuccess(PublishJoke value) {
                String code = value.code;
                if(code.equals("0")){
                    getPublishJokeView.getPublishJokeSuccess(value);
                }else if(code.equals("2")){
                    getPublishJokeView.getPublishJokeTokenFaliure(value.msg);
                }else {
                    getPublishJokeView.getPublishJokeFaliure(value.msg);
                }
            }

            @Override
            public void getPublishJokeFaliure(Throwable e) {
                getPublishJokeView.error(e.getMessage().toString());
            }
        });
    }
}

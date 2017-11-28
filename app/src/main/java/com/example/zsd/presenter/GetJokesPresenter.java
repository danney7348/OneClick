package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.GetJokes;
import com.example.zsd.model.GetJokesModel;
import com.example.zsd.view.GetJokesView;

/**
 * 作者： 张少丹
 * 时间：  2017/11/27.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetJokesPresenter extends BasePresenter {
    private GetJokesModel getJokesModel;
    private GetJokesView getJokesView;
    public GetJokesPresenter(GetJokesView getJokesView) {
        super(getJokesView);
        this.getJokesView = getJokesView;
        if(getJokesModel == null){
            getJokesModel = new GetJokesModel();
        }
    }
    public void getJokesData(String page,String token){
        getJokesModel.getJokesData(page, token, new GetJokesModel.GetJokensMessage() {
            @Override
            public void getJokesSuccess(GetJokes value) {
                String code = value.code;
                if(code.equals("0")){
                    getJokesView.getJokesSuccess(value);
                }else {
                    getJokesView.getJokesFailure(value.msg);
                }
            }

            @Override
            public void getJokesFailure(Throwable e) {
                getJokesView.failure();
            }
        });
    }
}

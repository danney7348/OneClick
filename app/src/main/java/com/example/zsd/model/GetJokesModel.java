package com.example.zsd.model;

import com.example.zsd.entity.GetJokes;
import com.example.zsd.utils.HttpUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者： 张少丹
 * 时间：  2017/11/27.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetJokesModel {
    public void getJokesData(String page, final GetJokensMessage getJokensMessage){
        new HttpUtils.Builder()
                .addCallAdapterFactory()
                .addConverterFactory()
                .build()
                .getMyQusetUtils()
                .getJokes(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetJokes>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetJokes value) {
                        getJokensMessage.getJokesSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getJokensMessage.getJokesFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public interface GetJokensMessage{
        void getJokesSuccess(GetJokes value);
        void getJokesFailure(Throwable e);
    }
}

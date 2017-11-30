package com.example.zsd.model;

import com.example.zsd.entity.UpdateNickName;
import com.example.zsd.utils.HttpUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者： 张少丹
 * 时间：  2017/11/30.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class UpdateNickNameModel {
    public void getUpdateNickNameData(String uid,String nickname){
        new HttpUtils.Builder()
                .addConverterFactory()
                .addCallAdapterFactory()
                .build()
                .getMyQusetUtils()
                .getUpdateNickName(uid,nickname)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UpdateNickName>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UpdateNickName value) {

                        if(value.code.equals("0")){
                            updateNickNameMessage.updateNickNameScuuess(value.msg);
                        }else {
                            updateNickNameMessage.updateNickNameFailure(value.msg);
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
    private UpdateNickNameMessage updateNickNameMessage;

    public void setUpdateNickNameMessage(UpdateNickNameMessage updateNickNameMessage) {
        this.updateNickNameMessage = updateNickNameMessage;
    }

    public interface UpdateNickNameMessage{
        void updateNickNameScuuess(String msg);
        void updateNickNameFailure(String msg);
    }
}

package com.example.zsd.model;

import com.example.zsd.entity.SearchFriends;
import com.example.zsd.utils.HttpUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * 作者： 张少丹
 * 时间：  2017/12/15.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class SearchFriendsModel implements ISearchFriendsModel {
    @Override
    public void getSearchFridendsData(String keywords, String page, final SearchFridendsCallBack searchFridendsCallBack) {
        new HttpUtils.Builder()
                .addCallAdapterFactory()
                .addConverterFactory()
                .build()
                .getMyQusetUtils()
                .getSearchFriends(keywords,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<SearchFriends>() {
                    @Override
                    public void onNext(SearchFriends searchFriends) {
                        if(searchFriends.code.equals("0")){
                            searchFridendsCallBack.getSearchFridendsSuccess(searchFriends);
                        }else {
                            searchFridendsCallBack.getSearchFridendsFailure(searchFriends.msg);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        searchFridendsCallBack.getSearchFridendsFailure(t.getMessage().toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

package com.example.zsd.presenter;

import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.SearchFriends;
import com.example.zsd.model.SearchFridendsCallBack;
import com.example.zsd.model.SearchFriendsModel;
import com.example.zsd.view.SearchFriendsView;

/**
 * 作者： 张少丹
 * 时间：  2017/12/15.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class SearchFriendsPresenter extends BasePresenter<SearchFriendsView> {
    private SearchFriendsModel searchFriendsModel;

    public SearchFriendsPresenter(SearchFriendsView mView) {
        super(mView);
        if(searchFriendsModel == null){
            searchFriendsModel = new SearchFriendsModel();
        }
    }
    public void getSearchFriendsData(String keywords,String page){
        searchFriendsModel.getSearchFridendsData(keywords, page, new SearchFridendsCallBack() {
            @Override
            public void getSearchFridendsSuccess(SearchFriends searchFriends) {
                mView.getSearchFridendsSuccess(searchFriends);
            }

            @Override
            public void getSearchFridendsFailure(String msg) {
                mView.getSearchFridendsFailure(msg);
            }
        });
    }
}

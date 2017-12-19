package com.example.zsd.activity;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zsd.R;
import com.example.zsd.adapter.SearchFriendsRecycleViewAdapter;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.base.BasePresenter;
import com.example.zsd.entity.SearchFriends;
import com.example.zsd.presenter.SearchFriendsPresenter;
import com.example.zsd.view.SearchFriendsView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.SearchView;
import scut.carson_ho.searchview.bCallBack;

public class FindFriendsActivity extends BaseActivity implements SearchFriendsView {

    private RecyclerView rv;
    private SearchFriendsPresenter searchFriendsPresenter;
    private int page;
    private SearchFriendsRecycleViewAdapter adapter;
    private EditText keywords;
    private String keywordsContent;
    private ImageView sousuo;
    private TextView quxiao;
    private TextView back;
    private SearchView search;

    @Override
    public int bindLayout() {
        return R.layout.activity_find_friends;
    }

    @Override
    public void setListener() {

    }

    @Override
    public void Click(View view) throws PackageManager.NameNotFoundException {

    }

    @Override
    public void initView() {
        rv = findViewById(R.id.find_rv);
        sousuo = findViewById(R.id.find_iv_sousuo);
        quxiao = findViewById(R.id.sousuo_tv_quxiao);
        keywords = findViewById(R.id.find_et_keywords);
        back = findViewById(R.id.sousuo_tv_back);
        search = findViewById(R.id.search_view);

        rv.setLayoutManager(new LinearLayoutManager(this));

        search.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String string) {
                searchFriendsPresenter.getSearchFriendsData(string+"",page+"");
            }
        });

        // 5. 设置点击返回按键后的操作（通过回调接口）
        search.setOnClickBack(new bCallBack() {
            @Override
            public void BackAciton() {
                finish();
            }
        });
    }

    @Override
    public void initData() {
        searchFriendsPresenter = new SearchFriendsPresenter(this);

        sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keywordsContent = keywords.getText().toString();
                searchFriendsPresenter.getSearchFriendsData(keywordsContent,page+"");
            }
        });
        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }

    @Override
    public BasePresenter binView() {
        return null;
    }

    @Override
    public void success(Object o) {

    }

    @Override
    public void error(String msg) {

    }

    @Override
    public void failure(String msg) {

    }

    @Override
    public void getSearchFridendsSuccess(SearchFriends searchFriends) {

        showToast(searchFriends.msg);
        if(adapter == null){
            adapter = new SearchFriendsRecycleViewAdapter(this,searchFriends.data);
            rv.setAdapter(adapter);
        }else {
            adapter.refreshData(searchFriends.data);
        }
    }

    @Override
    public void getSearchFridendsFailure(String msg) {
        showToast(msg);
    }
}

package com.example.zsd.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.zsd.R;
import com.example.zsd.adapter.DuanziRecycleViewAdapter;
import com.example.zsd.entity.GetJokes;
import com.example.zsd.presenter.GetJokesPresenter;
import com.example.zsd.utils.SpacesItemDecoration;
import com.example.zsd.view.GetJokesView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/11/23.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class DuanziFragment extends Fragment implements GetJokesView {

    private View view;
    private XRecyclerView duanzi_fragment_rv;
    private int page=1;
    private DuanziRecycleViewAdapter adapter;
    private GetJokesPresenter getJokesPresenter;
    private List<GetJokes.DataBean> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.duanzi_fragment,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        getJokesPresenter = new GetJokesPresenter(this);
        getJokesPresenter.getJokesData(page+"");
    }

    private void initView() {
        list = new ArrayList<>();
        duanzi_fragment_rv = view.findViewById(R.id.duanzi_fragment_rv);
        duanzi_fragment_rv.setLayoutManager(new LinearLayoutManager(getContext()));
        duanzi_fragment_rv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "下拉刷新", Toast.LENGTH_SHORT).show();
                page = 1;
                getJokesPresenter.getJokesData(page+"");
                duanzi_fragment_rv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                Toast.makeText(getContext(), "上拉加载", Toast.LENGTH_SHORT).show();
                page++;
                System.out.println("page ======================= " + page);
                getJokesPresenter.getJokesData(page+"");
            }
        });
    }



    @Override
    public void getJokesSuccess(GetJokes value) {
        //Toast.makeText(getContext(), value.msg, Toast.LENGTH_SHORT).show();
        list.addAll(value.data);
        if(adapter == null){
            adapter = new DuanziRecycleViewAdapter(getActivity(),list);
            SpacesItemDecoration decoration=new SpacesItemDecoration(16);
            duanzi_fragment_rv.addItemDecoration(decoration);
            duanzi_fragment_rv.setAdapter(adapter);
            return;
        }
        if(page == 1){
            adapter.refreshData(value.data);
            duanzi_fragment_rv.refreshComplete();
        }else {
            adapter.loadmoreData(value.data);
            duanzi_fragment_rv.loadMoreComplete();
        }


    }

    @Override
    public void getJokesFailure(String e) {
        Toast.makeText(getActivity(), e, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void success(Object o) {

    }

    @Override
    public void failure(String msg) {

    }

    @Override
    public void error(String msg) {

    }
}

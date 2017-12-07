package com.example.zsd.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.zsd.R;
import com.example.zsd.adapter.MyShipinRemenAdapter;
import com.example.zsd.adapter.MyShipinRemenAdapter1;
import com.example.zsd.entity.GetNearVideos;
import com.example.zsd.presenter.GetNearVideosPresenter;
import com.example.zsd.utils.SpacesItemDecoration;
import com.example.zsd.view.GetNearVideosView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/11/25.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class FujinFragment extends Fragment implements GetNearVideosView {

    private View view;
    private XRecyclerView lv;
    private GetNearVideosPresenter getNearVideosPresenter;
    private int page;
    private List<GetNearVideos.DataBean> list;
    private MyShipinRemenAdapter1 adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.shipin_fragment_fujin,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        getNearVideosPresenter = new GetNearVideosPresenter(this);
        getNearVideosPresenter.getNearVideosData(1+"",40+"",116+"");
    }

    private void initView() {
        list = new ArrayList();
        lv = view.findViewById(R.id.fragmet_near_xlv);
        lv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
        lv.addItemDecoration(decoration);
        lv.setRefreshProgressStyle(15);
        lv.setLoadingMoreProgressStyle(10);
    }

    @Override
    public void success(GetNearVideos getNearVideos) {
        list.addAll(getNearVideos.data);
        if(adapter == null){
            adapter = new MyShipinRemenAdapter1(getActivity(),list);
            lv.setAdapter(adapter);
        }else{
            adapter.notifyDataSetChanged();
        }
        lv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getActivity(), "下拉刷新", Toast.LENGTH_SHORT).show();
                list.clear();
                getNearVideosPresenter.getNearVideosData(page+"",40+"",116+"");
                lv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                Toast.makeText(getActivity(), "上拉加载", Toast.LENGTH_SHORT).show();
                page++;
                getNearVideosPresenter.getNearVideosData(page+"",40+"",116+"");
                lv.loadMoreComplete();
            }
        });


    }

    @Override
    public void error(String msg) {

    }

    @Override
    public void failure(String msg) {

    }
}

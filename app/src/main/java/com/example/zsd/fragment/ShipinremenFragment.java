package com.example.zsd.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.zsd.R;
import com.example.zsd.adapter.MyShipinRemenAdapter;
import com.example.zsd.entity.GetHotVideos;
import com.example.zsd.presenter.GetHotVideosPresenter;
import com.example.zsd.utils.SpacesItemDecoration;
import com.example.zsd.view.GetHotVideosView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 作者： 张少丹
 * 时间：  2017/11/25.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class ShipinremenFragment extends Fragment implements GetHotVideosView {

    private View view;
    private XRecyclerView lv;
    private List<GetHotVideos.DataBean> list;
    private MyShipinRemenAdapter adapter;
    private int page = 1;
    private GetHotVideosPresenter getHotVideosPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.shipin_remen_fragment,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        list = new ArrayList<>();
        lv = view.findViewById(R.id.shipin_remen_xlv);
        getHotVideosPresenter = new GetHotVideosPresenter(this);
        getHotVideosPresenter.getHotVideosData("1");
        lv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
        lv.addItemDecoration(decoration);
        lv.setRefreshProgressStyle(15);
        lv.setLoadingMoreProgressStyle(10);
        lv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getActivity(), "下拉刷新", Toast.LENGTH_SHORT).show();
                getHotVideosPresenter.getHotVideosData(1+"");
            }

            @Override
            public void onLoadMore() {
                Toast.makeText(getActivity(), "上拉加载", Toast.LENGTH_SHORT).show();
                page++;
                getHotVideosPresenter.getHotVideosData(page+"");
            }
        });
    }

    @Override
    public void success(GetHotVideos getHotVideos) {
        Toast.makeText(getActivity(), "+++++++++++++success++++++++++++++++", Toast.LENGTH_SHORT).show();
        list.addAll(getHotVideos.data);
        for (int i = 0; i < getHotVideos.data.size(); i++) {
            int height = new Random().nextInt(400) + 250;
            getHotVideos.data.get(i).height = height;
        }
        if(adapter == null){
            adapter = new MyShipinRemenAdapter(getActivity(),list);
            lv.setAdapter(adapter);
            return;
        }
        if(page == 1){
            adapter.refreshData(list);
            lv.refreshComplete();
        }else {
            adapter.loadmoreData(list);
            lv.loadMoreComplete();
        }



    }

    @Override
    public void error(String msg) {
        Toast.makeText(getActivity(), "+++++++++++++++error++++++++++++++", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void failure(String msg) {
        Toast.makeText(getActivity(), "+++++++++++++++failure++++++++++++++", Toast.LENGTH_SHORT).show();
    }
}

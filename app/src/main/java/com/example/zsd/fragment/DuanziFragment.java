package com.example.zsd.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zsd.R;
import com.example.zsd.adapter.DuanziRecycleViewAdapter;

/**
 * 作者： 张少丹
 * 时间：  2017/11/23.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class DuanziFragment extends Fragment {

    private View view;
    private RecyclerView duanzi_fragment_rv;

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
        duanzi_fragment_rv.setLayoutManager(new LinearLayoutManager(getContext()));
        DuanziRecycleViewAdapter adapter = new DuanziRecycleViewAdapter();
        duanzi_fragment_rv.setAdapter(adapter);
    }

    private void initView() {
        duanzi_fragment_rv = view.findViewById(R.id.duanzi_fragment_rv);

    }
}

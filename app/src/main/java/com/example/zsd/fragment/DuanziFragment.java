package com.example.zsd.fragment;

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
import com.example.zsd.view.GetJokesView;

/**
 * 作者： 张少丹
 * 时间：  2017/11/23.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class DuanziFragment extends Fragment implements GetJokesView {

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
        GetJokesPresenter getJokesPresenter = new GetJokesPresenter(this);
        getJokesPresenter.getJokesData("1","");

    }

    private void initView() {
        duanzi_fragment_rv = view.findViewById(R.id.duanzi_fragment_rv);

    }

    @Override
    public void success() {

    }

    @Override
    public void failure() {

    }

    @Override
    public void getJokesSuccess(GetJokes value) {
        Toast.makeText(getContext(), value.msg, Toast.LENGTH_SHORT).show();
        duanzi_fragment_rv.setLayoutManager(new LinearLayoutManager(getContext()));
        DuanziRecycleViewAdapter adapter = new DuanziRecycleViewAdapter(getActivity(),value.data);
        duanzi_fragment_rv.setAdapter(adapter);

    }

    @Override
    public void getJokesFailure(String e) {
        Toast.makeText(getContext(), e, Toast.LENGTH_SHORT).show();
    }
}

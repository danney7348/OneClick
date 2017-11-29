package com.example.zsd.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zsd.R;
import com.example.zsd.entity.GetAd;
import com.example.zsd.model.GetAdModel;
import com.example.zsd.presenter.GetAdPresenter;
import com.example.zsd.view.GetAdView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/11/25.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class RemenFragment extends Fragment implements XBanner.XBannerAdapter, GetAdView {

    private View view;
    private List<String> imgesUrl;
    private XBanner mBanner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.tuijian_remen_fragment,null);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        mBanner = view.findViewById(R.id.banner);
        GetAdPresenter getAdPresenter = new GetAdPresenter(this);
        getAdPresenter.getAdData();
    }

    @Override
    public void loadBanner(XBanner banner, View view, int position) {
        Glide.with(this).load(imgesUrl.get(position)).into((ImageView) view);
    }
    @Override
    public void onResume() {
        super.onResume();
        mBanner.startAutoPlay();
    }
    @Override public void onStop() {
        super.onStop();
        mBanner.stopAutoPlay();
    }

    @Override
    public void success(GetAd getAd) {

        imgesUrl = new ArrayList<>();
        for (int i = 0; i < getAd.data.size(); i++) {
            imgesUrl.add(getAd.data.get(i).icon);
            System.out.println("getAd.data.get(i).url = " + getAd.data.get(i).icon);
        }
        mBanner.setData(imgesUrl,null);
        mBanner.setPoinstPosition(XBanner.RIGHT);
        mBanner.setmAdapter(this);
    }

    @Override
    public void failure(String msg) {

    }

    @Override
    public void error(String msg) {

    }
}

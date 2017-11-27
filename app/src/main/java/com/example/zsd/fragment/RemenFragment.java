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
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/11/25.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class RemenFragment extends Fragment implements XBanner.XBannerAdapter {

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
        imgesUrl = new ArrayList<>();
        imgesUrl.add("http://pic1.cxtuku.com/00/06/78/b9903ad9ea2b.jpg");
        imgesUrl.add("http://pic1.cxtuku.com/00/06/78/b9903ad9ea2b.jpg");
        imgesUrl.add("http://pic1.cxtuku.com/00/06/78/b9903ad9ea2b.jpg");
        imgesUrl.add("http://pic1.cxtuku.com/00/06/78/b9903ad9ea2b.jpg");
        mBanner.setData(imgesUrl,null);
        mBanner.setPoinstPosition(XBanner.RIGHT);
        mBanner.setmAdapter(this);
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
}

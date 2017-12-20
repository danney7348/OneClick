package com.example.zsd.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.example.zsd.R;
import com.example.zsd.activity.DonghuaActivity;
import com.example.zsd.base.BaseFragment;
import com.example.zsd.base.BasePresenter;

/**
 * 作者： 张少丹
 * 时间：  2017/12/15.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class LocalFragment extends BaseFragment {
    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public int getViewId() {
        return R.layout.localfragment_view;
    }

    @Override
    public void initFragment() {

        TextView tv = view.findViewById(R.id.fongggg);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),DonghuaActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void resumFragment() {

    }
}

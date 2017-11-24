package com.example.zsd.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/11/20.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class MyFragmentAdapter extends FragmentPagerAdapter{

    private  List<Fragment>fragmentList ;

    public MyFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    //通过position设置对应的Fragment，
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    //你的fragment集合的参数长度
    public int getCount() {
        return fragmentList.size();
    }
}

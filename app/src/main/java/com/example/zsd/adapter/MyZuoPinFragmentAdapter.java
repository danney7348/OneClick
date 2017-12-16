package com.example.zsd.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/12/15.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class MyZuoPinFragmentAdapter extends FragmentPagerAdapter{
    private List<Fragment> list;
    private List<String>  meuns;

    public MyZuoPinFragmentAdapter(FragmentManager fm, List<String> meusn, List<Fragment> list) {
        super(fm);
        this.meuns=meusn;
        this.list = list;
    }

    public MyZuoPinFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
    @Override public CharSequence getPageTitle(int position) {
        return meuns.get(position);
    }
}

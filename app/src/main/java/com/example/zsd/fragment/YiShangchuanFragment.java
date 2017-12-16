package com.example.zsd.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.zsd.R;
import com.example.zsd.adapter.YiShangchuanRecycleViewAdapter;
import com.example.zsd.base.BaseFragment;
import com.example.zsd.base.BasePresenter;
import com.example.zsd.component.DaggerGetWorkInfoComponent;
import com.example.zsd.entity.GetWorkInfo;
import com.example.zsd.entity.RemoveWork;
import com.example.zsd.module.GetWorkInfoMudule;
import com.example.zsd.presenter.GetWorkInfoPresenter;
import com.example.zsd.presenter.RemoveWorkPresenter;
import com.example.zsd.utils.ShareprefrensUtils;
import com.example.zsd.utils.SpacesItemDecoration;
import com.example.zsd.view.GetWorkInfoView;
import com.example.zsd.view.RemoveWorkView;

import java.util.List;

import javax.inject.Inject;

/**
 * 作者： 张少丹
 * 时间：  2017/12/15.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class YiShangchuanFragment extends BaseFragment implements GetWorkInfoView, RemoveWorkView {
    @Inject
    GetWorkInfoPresenter getWorkInfoPresenter;
    private String uid;
    private RecyclerView rv;
    private RemoveWorkPresenter removeWorkPresenter;

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public int getViewId() {
        return R.layout.yishangchuanfragment_view;
    }

    @Override
    public void initFragment() {
        rv = view.findViewById(R.id.yishangchuan_rv);
        uid = (String) ShareprefrensUtils.get(getActivity(), "uid", "");
        removeWorkPresenter = new RemoveWorkPresenter(this);
        GetWorkInfoPresenter getWorkInfoPresenter = new GetWorkInfoPresenter(this);
        DaggerGetWorkInfoComponent.builder().getWorkInfoMudule(new GetWorkInfoMudule(this)).build().inject(this);
        getWorkInfoPresenter.getWorkInfoData(uid);
        rv.setLayoutManager(new GridLayoutManager(getActivity(),3));
    }


    @Override
    public void resumFragment() {

    }

    @Override
    public void success(Object o) {

    }

    @Override
    public void error(String msg) {

    }

    @Override
    public void failure(String msg) {
        showToast(msg);
    }

    @Override
    public void getWorkInfoSuccess(final GetWorkInfo getWorkInfo) {
        showToast(getWorkInfo.msg);
        final YiShangchuanRecycleViewAdapter adapter = new YiShangchuanRecycleViewAdapter(getActivity(),getWorkInfo.data.worksEntities);
        SpacesItemDecoration decoration=new SpacesItemDecoration(8);
        rv.addItemDecoration(decoration);
        rv.setAdapter(adapter);
        adapter.setOnLongClickListener(new YiShangchuanRecycleViewAdapter.OnLongClickListener() {
            @Override
            public void setOnLongClickListener(View view, final int position) {
                AlertDialog.Builder ad = new AlertDialog.Builder(getActivity())
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                adapter.removeData(position);
                                removeWorkPresenter.getRemoveWorkData(uid,getWorkInfo.data.worksEntities.get(position).wid+"");
                                adapter.notifyDataSetChanged();
                            }
                        }).setNegativeButton("取消",null)
                        .setTitle("是否删除");
                ad.show();
            }
        });


    }

    @Override
    public void getWorkInfoFailure(String msg) {
        showToast(msg);
    }

    @Override
    public void removeWorkScuuess(RemoveWork removeWork) {
        showToast(removeWork.msg);
    }

    @Override
    public void removeWorkFailure(String msg) {
        showToast(msg);
    }
}
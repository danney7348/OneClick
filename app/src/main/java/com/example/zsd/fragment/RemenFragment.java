package com.example.zsd.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.zsd.R;
import com.example.zsd.adapter.RemenRecycleViewAdapter;
import com.example.zsd.component.CommentComponent;
import com.example.zsd.component.DaggerCommentComponent;
import com.example.zsd.entity.Comment;
import com.example.zsd.entity.GetAd;
import com.example.zsd.entity.GetVideos;
import com.example.zsd.model.GetAdModel;
import com.example.zsd.module.CommentMudule;
import com.example.zsd.presenter.CommentPresenter;
import com.example.zsd.presenter.GetAdPresenter;
import com.example.zsd.presenter.GetVideosPresenter;
import com.example.zsd.utils.ShareprefrensUtils;
import com.example.zsd.view.CommentView;
import com.example.zsd.view.GetAdView;
import com.example.zsd.view.GetVideosView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * 作者： 张少丹
 * 时间：  2017/11/25.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class RemenFragment extends Fragment implements XBanner.XBannerAdapter,GetAdView, CommentView {

    private View view;
    private List<String> imgesUrl;
    private XRecyclerView lv;
    private GetAdPresenter getAdPresenter;
    private View view1;
    private XBanner banner;
    private RemenRecycleViewAdapter adapter;
    private int page = 1;
    private String uid;
    private LinearLayoutManager linearLayoutManager;
    @Inject
    CommentPresenter commentPresenter;
    private int wid;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.tuijian_remen_fragment,null);
        /*DaggerCommentComponent.Builder builder = DaggerCommentComponent.builder();
        CommentComponent build = builder.build();
        build.inject(this);*/
        DaggerCommentComponent.builder().commentMudule(new CommentMudule(this)).build().inject(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        getAdPresenter.getAdData();
        getAdPresenter.getVideos(uid,"1","1");

    }

    private void initView() {
        view1 = View.inflate(getActivity(), R.layout.xbanner_item, null);
        banner = view1.findViewById(R.id.banner);
        lv = this.view.findViewById(R.id.remen_xrv);
        lv.addHeaderView(view1);
        uid = (String) ShareprefrensUtils.get(getActivity(), "uid", "");
        getAdPresenter = new GetAdPresenter(this);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        lv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getActivity(), "下拉刷新", Toast.LENGTH_SHORT).show();
                page = 1;
                getAdPresenter.getVideos(uid,"1",page+"");
            }

            @Override
            public void onLoadMore() {
                Toast.makeText(getActivity(), "上拉加载", Toast.LENGTH_SHORT).show();
                page++;
                getAdPresenter.getVideos(uid,"1",page+"");
            }
        });
        /*lv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                return false;
            }
        });*/
    }

    @Override
    public void loadBanner(XBanner banner, View view, int position) {
        Glide.with(this).load(imgesUrl.get(position)).into((ImageView) view);
    }
    @Override
    public void onResume() {
        super.onResume();
        banner.startAutoPlay();
    }
    @Override public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }

    @Override
    public void success(Object o) {

    }

    @Override
    public void failure(String msg) {

    }

    @Override
    public void getAdseccuss(GetAd ad) {
        imgesUrl = new ArrayList<>();
        for (int i = 0; i < ad.data.size(); i++) {
            imgesUrl.add(ad.data.get(i).icon);
            System.out.println("getAd.data.get(i).url = " + ad.data.get(i).icon);
        }
        banner.setData(imgesUrl,null);
        banner.setPoinstPosition(XBanner.RIGHT);
        banner.setmAdapter(this);
    }

    @Override
    public void getVideosseccuss(final GetVideos videos) {
        System.out.println(videos.msg+"++++++++++++++++++++++++++++++++++++++++++++++");
        for (int i = 0; i < videos.data.size(); i++) {
            wid = videos.data.get(i).wid;
        }

        //commentPresenter.getCommentData("170",wid+"","真棒真棒");
        lv.setLayoutManager(linearLayoutManager);
        if(adapter == null){
            adapter = new RemenRecycleViewAdapter(getActivity(),videos.data);
            adapter.setOnLongItemClickListener(new RemenRecycleViewAdapter.OnLongItemClickListener() {
                @Override
                public void setOnLongItemClickListener( final int position) {
                    Toast.makeText(getActivity(), "position:"+position, Toast.LENGTH_SHORT).show();
                    final EditText et = new EditText(getActivity());
                    new AlertDialog.Builder(getActivity()).setTitle("评论")
                            .setIcon(android.R.drawable.ic_dialog_info)
                            .setView(et)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    String input = et.getText().toString();
                                    if (input.equals("")) {
                                        Toast.makeText(getActivity(), "评论内容不能为空！" + input, Toast.LENGTH_LONG).show();
                                    }
                                    else {
                                        commentPresenter.getCommentData("170",videos.data.get(position).wid+"",et.getText().toString());
                                        adapter.notifyDataSetChanged();
                                    }
                                }
                            })
                            .setNegativeButton("取消", null)
                            .show();

                }
            });
            lv.setAdapter(adapter);

            return;
        }
        if(page == 1){
            adapter.refreshData(videos.data);
            lv.refreshComplete();
        }else {
            adapter.loadmoreData(videos.data);
            lv.loadMoreComplete();
        }
    }

    @Override
    public void error(String msg) {

        System.out.println("msg 999999+++++++++++= " + msg);
    }

    @Override
    public void failue(String msg) {
        System.out.println("msg 999999+++++++++++= " + msg);
    }


    /*public void success(GetVideos o) {

    }*/


   /* @Override
    public void onDestroy() {
        super.onDestroy();
        commentPresenter.ondestry();
    }*/

    @Override
    public void getCommentSuccess(Comment comment) {
        Toast.makeText(getActivity(), comment.msg+"=======================", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getCommentFailure(String msg) {
        Toast.makeText(getActivity(), msg+"=======================", Toast.LENGTH_SHORT).show();
    }
}

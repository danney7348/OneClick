package com.example.zsd.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.zsd.R;
import com.example.zsd.activity.DonghuaActivity;
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

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * 作者： 张少丹
 * 时间：  2017/12/15.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class YiShangchuanFragment extends BaseFragment implements GetWorkInfoView, RemoveWorkView, View.OnClickListener {
    @Inject
    GetWorkInfoPresenter getWorkInfoPresenter;
    private String uid;
    private RecyclerView rv;
    private RemoveWorkPresenter removeWorkPresenter;
    private int[] res = {R.id.donghua_img_hongxing,R.id.donghua_img_shanchu,
            R.id.donghua_img_zhaoxiang,R.id.donghua_img_fxx};
    private List<ImageView> list_img =
            new ArrayList<ImageView>();
    /*
     1.  flag为true，当点击按钮的时候，弹出菜单
     2.  flag为false，当点击按钮的时候，收回菜单
    */
    private boolean flag = true;
    private ImageView hongxing;
    private ImageView shanchu;
    private ImageView zhaoxiang;
    private ImageView fxx;
    private ImageView lanxing;

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
        hongxing = view.findViewById(R.id.donghua_img_hongxing);
        shanchu = view.findViewById(R.id.donghua_img_shanchu);
        zhaoxiang = view.findViewById(R.id.donghua_img_zhaoxiang);
        fxx = view.findViewById(R.id.donghua_img_fxx);
        lanxing = view.findViewById(R.id.donghua_img_lanxing);
        for(int i=0;i<res.length;i++){
            ImageView img = (ImageView)
                    view.findViewById(res[i]);
            hongxing.setOnClickListener(this);
            list_img.add(img);
        }
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.donghua_img_hongxing:
                if(flag){
                    startAnim();  //弹出菜单动画
                    hongxing.setImageResource(R.drawable.lanxing);
                }else{
                    closeAnim();  //收回菜单动画
                    hongxing.setImageResource(R.drawable.hongxing);
                }
                break;
            default:
//这里只是简单的对弹出按钮的点击响应进行了处理，具体应用时可以进行完善
                Toast.makeText(getActivity(),"click"+view.getId(),
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void closeAnim(){
        for(int i =1;i<res.length;i++){
//给出一个沿Y轴移动的动画
            ObjectAnimator animator = ObjectAnimator.ofFloat(
                    list_img.get(i),"translationY",(res.length-i-1)*50f,0f );
//给出一个沿X轴移动的动画
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                    list_img.get(i),"translationX",(i-1)*50f,0f );
            //定义属性动画集合的对象
            AnimatorSet animSet = new AnimatorSet();
            //通过with方法，让两个动画同时进行
            animSet.play(animator).with(animator1);
            //设置延迟时间,让菜单内容相继弹出
            animSet.setStartDelay(500);
            animSet.start();
            //然后，设置flag为true，当再次点击的时候，收回菜单
            flag = true;
        }
    }
    //两种方法的内容大体相同，只是动画属性的参数相反
    private void startAnim() {
        for(int i =1;i<res.length;i++){
            ObjectAnimator animator = ObjectAnimator.ofFloat(
                    list_img.get(i),"translationY",
                    0f,(res.length-i-1)*50f );
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                    list_img.get(i),"translationX", 0f , (i-1)*50f );
            AnimatorSet animSet = new AnimatorSet();
            animSet.play(animator).with(animator1);
            animSet.setStartDelay(500);
            animSet.start();
            flag = false;
        }
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

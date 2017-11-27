package com.example.zsd.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.zsd.R;
import com.example.zsd.activity.FindFriendsActivity;
import com.example.zsd.activity.MessageTongzhiActivity;
import com.example.zsd.activity.MyGuanzhuActivity;
import com.example.zsd.activity.MyShoucangActivity;
import com.example.zsd.utils.GlideCircleTransform;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.content.Context.MODE_PRIVATE;

/**
 * 作者： 张少丹
 * 时间：  2017/11/23.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class LeftFragment extends Fragment {

    @BindView(R.id.relativeLayout5)
    RelativeLayout relativeLayout5;
    @BindView(R.id.relativeLayout6)
    RelativeLayout relativeLayout6;
    @BindView(R.id.relativeLayout7)
    RelativeLayout relativeLayout7;
    @BindView(R.id.relativeLayout8)
    RelativeLayout relativeLayout8;
    Unbinder unbinder;
    private View view;
    private Switch left_switch;
    private ImageView moon;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.left_fragment, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        left_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                int uiMode;//夜间模式
                uiMode = getResources().getConfiguration().uiMode& Configuration.UI_MODE_NIGHT_MASK;
                if(b){
                    if(uiMode == Configuration.UI_MODE_NIGHT_YES){

                      /*  getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        getActivity().getSharedPreferences("theme",MODE_PRIVATE).edit().putBoolean("night_theme",false).commit();
                    }else if(uiMode == Configuration.UI_MODE_NIGHT_NO){
                        getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        getActivity().getSharedPreferences("theme",MODE_PRIVATE).edit().putBoolean("night_theme", true).commit();
                    }*/
                        getActivity().recreate();
                        moon.setImageResource(R.drawable.shiping2);
                    }else {
                   /* if(uiMode == Configuration.UI_MODE_NIGHT_YES){
                        getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        getActivity().getSharedPreferences("theme",MODE_PRIVATE).edit().putBoolean("night_theme",false).commit();
                    }else if(uiMode == Configuration.UI_MODE_NIGHT_NO){
                        getDelegate().setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        getActivity().getSharedPreferences("theme",MODE_PRIVATE).edit().putBoolean("night_theme", true).commit();
                    }*/
                        getActivity().recreate();
                        moon.setImageResource(R.drawable.raw_1500886654);
                    }
                }
            }
        });
    }

    private void initView() {
        left_switch = view.findViewById(R.id.left_switch);
        moon = view.findViewById(R.id.imageView7);
        ImageView left_icon = view.findViewById(R.id.left_icon);
        Glide.with(getActivity()).load(R.drawable.raw_1499936862).bitmapTransform(new GlideCircleTransform(getActivity(), 360)).into(left_icon);
        left_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.relativeLayout5, R.id.relativeLayout6, R.id.relativeLayout7, R.id.relativeLayout8})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.relativeLayout5:
                Intent intent = new Intent(getContext(), MyGuanzhuActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.relativeLayout6:
                Intent intent1 = new Intent(getContext(), MyShoucangActivity.class);
                getActivity().startActivity(intent1);
                break;
            case R.id.relativeLayout7:
                Intent intent2 = new Intent(getContext(), FindFriendsActivity.class);
                getActivity().startActivity(intent2);
                break;
            case R.id.relativeLayout8:
                Intent intent3 = new Intent(getContext(), MessageTongzhiActivity.class);
                getActivity().startActivity(intent3);
                break;
        }
    }
}

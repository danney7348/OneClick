package com.example.zsd.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.zsd.R;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.base.BasePresenter;
import com.example.zsd.utils.GlideCircleTransform;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChuangzuoActivity extends BaseActivity {

    @BindView(R.id.chuangzuo_tv_quxiao)
    TextView chuangzuoTvQuxiao;
    @BindView(R.id.chuangzuo_iv_shipin)
    ImageView chuangzuoIvShipin;
    @BindView(R.id.chuangzuo_iv_duanzi)
    ImageView chuangzuoIvDuanzi;

    @Override
    public int bindLayout() {
        return R.layout.activity_chuangzuo;
    }

    @Override
    public void setListener() {

    }
    @OnClick({R.id.chuangzuo_tv_quxiao,R.id.chuangzuo_iv_duanzi,R.id.rl_shipin})
    @Override
    public void Click(View view) {
        switch (view.getId()){
            case R.id.chuangzuo_tv_quxiao:
                finish();
                break;
            case R.id.chuangzuo_iv_duanzi:
                startActivity(BianxieDuanziActivity.class);
                finish();
                break;
            case R.id.rl_shipin:
                startActivity(FabuShipin2Activity.class);
                finish();
                break;
        }
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public List<BasePresenter> initPresenter() {
        return null;
    }

    @Override
    public BasePresenter binView() {
        return null;
    }
}

package com.example.zsd.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.zsd.R;
import com.example.zsd.base.BaseActivity;
import com.example.zsd.utils.GlideCircleTransform;
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
    @OnClick(R.id.chuangzuo_tv_quxiao)
    @Override
    public void Click(View view) {
        switch (view.getId()){
            case R.id.chuangzuo_tv_quxiao:
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

        Glide.with(this).load(R.drawable.ic_launcher_background)
                .bitmapTransform(new GlideCircleTransform(this, 360))
                .into(chuangzuoIvDuanzi);
    }
}

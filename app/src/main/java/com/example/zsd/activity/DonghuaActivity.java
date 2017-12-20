package com.example.zsd.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.zsd.R;

import java.util.ArrayList;
import java.util.List;

public class DonghuaActivity extends AppCompatActivity implements View.OnClickListener {
    //组存放图片ID，通过list进行图片遍历
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donghua);

        hongxing = findViewById(R.id.donghua_img_hongxing);
        shanchu = findViewById(R.id.donghua_img_shanchu);
        zhaoxiang = findViewById(R.id.donghua_img_zhaoxiang);
        fxx = findViewById(R.id.donghua_img_fxx);
        lanxing = findViewById(R.id.donghua_img_lanxing);
        for(int i=0;i<res.length;i++){
                ImageView img = (ImageView)
                        findViewById(res[i]);
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
                    Toast.makeText(DonghuaActivity.this,"click"+view.getId(),
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
}

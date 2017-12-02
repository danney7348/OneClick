package com.example.zsd.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.zsd.R;
import com.yancy.imageselector.ImageLoader;

/**
 * 作者： 张少丹
 * 时间：  2017/11/29.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GlideLoader implements com.yancy.imageselector.ImageLoader {

    @Override
    public void displayImage(Context context, String path, ImageView imageView) {

        RequestOptions options = new RequestOptions();
        options.placeholder(R.drawable.ic_launcher_foreground);
        Glide.with(context).load(path).apply(options).into(imageView);
      /*  Glide.with(context)
                .load(path)
                .placeholder(com.yancy.imageselector.R.mipmap.imageselector_photo)
                .centerCrop()
                .into(imageView);*/
    }

}

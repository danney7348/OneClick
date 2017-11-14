package com.example.zsd.utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * 作者： 张少丹
 * 时间：  2017/11/13.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */
public class DialogUtils {
    private DialogUtils(){

    }
    private ProgressDialog progressDialog;
    private static class DialogUtilsHolder{
        static DialogUtils DialogUtils = new DialogUtils();
    }
    public static DialogUtils getInstance(){
        return  DialogUtilsHolder.DialogUtils;
    }

    public void show(Context context, String msg){

        close();

        createProgressDialog(context,msg);

        if (progressDialog!=null&&!progressDialog.isShowing()){
            progressDialog.show();
        }



    }

    private void createProgressDialog(Context context,String msg) {

        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage(msg);

    }

    public void close(){

        if (progressDialog!=null&&progressDialog.isShowing()){
            progressDialog.dismiss();
        }

    }
}

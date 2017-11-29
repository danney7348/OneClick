package com.example.zsd.entity;

/**
 * 作者： 张少丹
 * 时间：  2017/11/29.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetVersion {

    /**
     * msg : 获取版本信息成功
     * code : 0
     * data : {"apkUrl":"https://www.zhaoapi.cn/version/101.apk","type":0,"vId":1,"versionCode":"101","versionName":"1.0.1"}
     */

    public String msg;
    public String code;
    public DataBean data;

    public static class DataBean {
        /**
         * apkUrl : https://www.zhaoapi.cn/version/101.apk
         * type : 0
         * vId : 1
         * versionCode : 101
         * versionName : 1.0.1
         */

        public String apkUrl;
        public int type;
        public int vId;
        public String versionCode;
        public String versionName;
    }
}

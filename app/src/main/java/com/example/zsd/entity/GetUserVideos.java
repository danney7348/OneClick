package com.example.zsd.entity;

import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/12/1.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetUserVideos {

    /**
     * msg : 获取作品列表成功
     * code : 0
     * data : [{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/icon.png","createTime":"2017-11-28T11:34:09","favoriteNum":null,"latitude":null,"localUri":"","longitude":null,"playNum":null,"praiseNum":null,"uid":71,"videoUrl":"https://www.zhaoapi.cn/","wid":1,"workDesc":"我是描述"}]
     */

    public String msg;
    public String code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * commentNum : null
         * cover : https://www.zhaoapi.cn/images/icon.png
         * createTime : 2017-11-28T11:34:09
         * favoriteNum : null
         * latitude : null
         * localUri :
         * longitude : null
         * playNum : null
         * praiseNum : null
         * uid : 71
         * videoUrl : https://www.zhaoapi.cn/
         * wid : 1
         * workDesc : 我是描述
         */

        public Object commentNum;
        public String cover;
        public String createTime;
        public Object favoriteNum;
        public Object latitude;
        public String localUri;
        public Object longitude;
        public Object playNum;
        public Object praiseNum;
        public int uid;
        public String videoUrl;
        public int wid;
        public String workDesc;
    }
}

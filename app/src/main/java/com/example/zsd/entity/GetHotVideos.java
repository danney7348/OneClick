package com.example.zsd.entity;

import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/12/5.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetHotVideos {
    /**
     * msg : 获取热门作品列表成功
     * code : 0
     * data : [{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/oppo3.3gp","createTime":"2017-12-02T12:01:32","favoriteNum":0,"latitude":"103","localUri":null,"longitude":"102","playNum":0,"praiseNum":0,"uid":115,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/115.jpg","nickname":"微风～","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/PictureSelector_20171201_133412.mp4","wid":11,"workDesc":"fff"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/PictureSelector_20171202_104440.mp4","createTime":"2017-12-02T12:01:32","favoriteNum":0,"latitude":"30","localUri":null,"longitude":"30","playNum":0,"praiseNum":0,"uid":145,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/145.jpg","nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/a.jpg","wid":12,"workDesc":"Y"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/e.png","createTime":"2017-12-02T12:01:32","favoriteNum":0,"latitude":"1221","localUri":null,"longitude":"4542","playNum":0,"praiseNum":0,"uid":2997,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/1512108751006e.png","nickname":"李薇","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/wx_camera_1509596718115.mp4","wid":13,"workDesc":"成功成功"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1512184570725a.jpg","createTime":"2017-12-02T12:01:57","favoriteNum":0,"latitude":"30","localUri":null,"longitude":"30","playNum":0,"praiseNum":0,"uid":145,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/145.jpg","nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512184570725PictureSelector_20171202_111527.mp4","wid":14,"workDesc":"Y"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1512354186490录屏_20171201_190404.mp4","createTime":"2017-12-04T10:23:06","favoriteNum":0,"latitude":"1212","localUri":null,"longitude":"12121","playNum":null,"praiseNum":0,"uid":169,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/1512120820443cropped_1512120819548.jpg","nickname":"不熟","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512354186490录屏_20171201_190404.mp4","wid":16,"workDesc":"视频"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1512355016990oppo2.3gp","createTime":"2017-12-04T10:36:56","favoriteNum":0,"latitude":"1212","localUri":null,"longitude":"12121","playNum":null,"praiseNum":0,"uid":169,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/1512120820443cropped_1512120819548.jpg","nickname":"不熟","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512355016990oppo2.3gp","wid":17,"workDesc":"OPPO音乐手机"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/15123903874751.jpg","createTime":"2017-12-04T20:26:27","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":0,"uid":170,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/15121344760841.jpg","nickname":"wo","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512390387475_https___1251964405_vod2_myqcloud_com_vodtransgzp1251964405_4564972818487746947_v_f30.mp4","wid":18,"workDesc":"try"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/15123905141461.jpg","createTime":"2017-12-04T20:28:34","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":0,"uid":170,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/15121344760841.jpg","nickname":"wo","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512390514146_https___1251964405_vod2_myqcloud_com_vodtransgzp1251964405_4564972818487746947_v_f30.mp4","wid":19,"workDesc":"try"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/15123908778501.jpg","createTime":"2017-12-04T20:34:37","favoriteNum":0,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":0,"uid":170,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/15121344760841.jpg","nickname":"wo","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512390877850_https___1251964405_vod2_myqcloud_com_vodtransgzp1251964405_9031868223284436747_v_f30.mp4","wid":20,"workDesc":"try"},{"commentNum":0,"comments":[],"cover":"https://www.zhaoapi.cn/images/quarter/1512391802162a.jpg","createTime":"2017-12-04T20:50:02","favoriteNum":0,"latitude":"40.040452","localUri":null,"longitude":"116.300033","playNum":null,"praiseNum":0,"uid":145,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/145.jpg","nickname":null,"praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512391802162PictureSelector_20171204_204951.mp4","wid":21,"workDesc":"Y"}]
     */

    public String msg;
    public String code;
    public List<DataBean> data;


    public static class DataBean {
        /**
         * commentNum : 0
         * comments : []
         * cover : https://www.zhaoapi.cn/images/quarter/oppo3.3gp
         * createTime : 2017-12-02T12:01:32
         * favoriteNum : 0
         * latitude : 103
         * localUri : null
         * longitude : 102
         * playNum : 0
         * praiseNum : 0
         * uid : 115
         * user : {"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/115.jpg","nickname":"微风～","praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/PictureSelector_20171201_133412.mp4
         * wid : 11
         * workDesc : fff
         */

        public int commentNum;
        public String cover;
        public String createTime;
        public int favoriteNum;
        public String latitude;
        public Object localUri;
        public String longitude;
        public int playNum;
        public int praiseNum;
        public int uid;
        public UserBean user;
        public String videoUrl;
        public int wid;
        public int height;
        public String workDesc;
        public List<?> comments;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : null
             * icon : https://www.zhaoapi.cn/images/115.jpg
             * nickname : 微风～
             * praiseNum : null
             */

            public Object age;
            public String fans;
            public String follow;
            public String icon;
            public String nickname;
            public String praiseNum;
        }
    }
}

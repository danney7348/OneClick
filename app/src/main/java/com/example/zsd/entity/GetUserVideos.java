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
     * data : [{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/15124600880061.jpg","createTime":"2017-12-05T15:48:08","favoriteNum":null,"latitude":"40","localUri":null,"longitude":"116","playNum":null,"praiseNum":null,"uid":170,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512460088006_https___1251964405_vod2_myqcloud_com_vodtransgzp1251964405_4564972818487746947_v_f30.mp4","wid":32,"workDesc":"try"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151252828350620171206104424.jpg","createTime":"2017-12-06T10:44:43","favoriteNum":null,"latitude":"40.040393","localUri":null,"longitude":"116.300055","playNum":null,"praiseNum":null,"uid":170,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512528283506VID_20171206_104405.3gp","wid":63,"workDesc":""},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151252915317820171206105901.jpg","createTime":"2017-12-06T10:59:13","favoriteNum":null,"latitude":"40.038863","localUri":null,"longitude":"116.296717","playNum":null,"praiseNum":null,"uid":170,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512529153178VID_20171206_105848.3gp","wid":64,"workDesc":"大家好"},{"commentNum":null,"cover":"https://www.zhaoapi.cn/images/quarter/151261562864620171207110012.jpg","createTime":"2017-12-07T11:00:28","favoriteNum":null,"latitude":"null","localUri":null,"longitude":"null","playNum":null,"praiseNum":null,"uid":170,"videoUrl":"https://www.zhaoapi.cn/images/quarter/1512615628646VID_20171207_105953.3gp","wid":162,"workDesc":"哈哈哈哈"}]
     */

    public String msg;
    public String code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * commentNum : null
         * cover : https://www.zhaoapi.cn/images/quarter/15124600880061.jpg
         * createTime : 2017-12-05T15:48:08
         * favoriteNum : null
         * latitude : 40
         * localUri : null
         * longitude : 116
         * playNum : null
         * praiseNum : null
         * uid : 170
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1512460088006_https___1251964405_vod2_myqcloud_com_vodtransgzp1251964405_4564972818487746947_v_f30.mp4
         * wid : 32
         * workDesc : try
         */

        public Object commentNum;
        public String cover;
        public String createTime;
        public Object favoriteNum;
        public String latitude;
        public Object localUri;
        public String longitude;
        public Object playNum;
        public Object praiseNum;
        public int uid;
        public String videoUrl;
        public int wid;
        public String workDesc;
    }
}

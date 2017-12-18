package com.example.zsd.entity;

import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/12/18.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetVideosDetail {

     /**
     * msg : 获取详情成功
     * code : 0
     * data : {"commentNum":2,"comments":[{"cid":108,"content":"888888","createTime":"2017-12-18T16:11:50","jid":null,"mvp":null,"nickname":"%E6%9E%97","praiseNum":0,"uid":114,"wid":225},{"cid":110,"content":"你好啊","createTime":"2017-12-18T16:14:05","jid":null,"mvp":null,"nickname":"%E6%9E%97","praiseNum":0,"uid":114,"wid":225}],"cover":"https://www.zhaoapi.cn/images/quarter/151358372249720170919_202309_1506213685322.jpg","createTime":"2017-12-18T15:55:22","favoriteNum":3,"latitude":"0.0","localUri":null,"longitude":"0.0","playNum":14,"praiseNum":1,"uid":150,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1513246264287cropped_1513246262263.jpg","nickname":"小狼","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/151358372249720170919_194626.mp4","wid":225,"workDesc":"瞎搞"}
     */

    public String msg;
    public String code;
    public DataBean data;

    public static class DataBean {
        /**
         * commentNum : 2
         * comments : [{"cid":108,"content":"888888","createTime":"2017-12-18T16:11:50","jid":null,"mvp":null,"nickname":"%E6%9E%97","praiseNum":0,"uid":114,"wid":225},{"cid":110,"content":"你好啊","createTime":"2017-12-18T16:14:05","jid":null,"mvp":null,"nickname":"%E6%9E%97","praiseNum":0,"uid":114,"wid":225}]
         * cover : https://www.zhaoapi.cn/images/quarter/151358372249720170919_202309_1506213685322.jpg
         * createTime : 2017-12-18T15:55:22
         * favoriteNum : 3
         * latitude : 0.0
         * localUri : null
         * longitude : 0.0
         * playNum : 14
         * praiseNum : 1
         * uid : 150
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1513246264287cropped_1513246262263.jpg","nickname":"小狼","praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/151358372249720170919_194626.mp4
         * wid : 225
         * workDesc : 瞎搞
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
        public String workDesc;
        public List<CommentsBean> comments;

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1513246264287cropped_1513246262263.jpg
             * nickname : 小狼
             * praiseNum : null
             */

            public Object age;
            public String fans;
            public boolean follow;
            public String icon;
            public String nickname;
            public String praiseNum;
        }

        public static class CommentsBean {
            /**
             * cid : 108
             * content : 888888
             * createTime : 2017-12-18T16:11:50
             * jid : null
             * mvp : null
             * nickname : %E6%9E%97
             * praiseNum : 0
             * uid : 114
             * wid : 225
             */

            public int cid;
            public String content;
            public String createTime;
            public Object jid;
            public Object mvp;
            public String nickname;
            public int praiseNum;
            public int uid;
            public int wid;
        }
    }
}

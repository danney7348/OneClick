package com.example.zsd.entity;

import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/12/18.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetFavorites {

    /**
     * msg : 获取收藏列表成功
     * code : 0
     * data : [{"commentNum":2,"comments":[{"cid":50,"content":"亚麻得","createTime":"2017-12-15T14:52:37","jid":null,"mvp":null,"nickname":"小狼","praiseNum":0,"uid":150,"wid":218},{"cid":67,"content":"pp","createTime":"2017-12-16T11:53:56","jid":null,"mvp":null,"nickname":"李灿灿","praiseNum":0,"uid":148,"wid":218}],"cover":"https://www.zhaoapi.cn/images/quarter/1513248624521cover.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":1,"latitude":"101","localUri":null,"longitude":"102","playNum":3,"praiseNum":4,"uid":154,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15131486893501.jpg","nickname":"beautiful","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1513248624521PictureSelector_20171214_184937.mp4","wid":218,"workDesc":"111"},{"commentNum":1,"comments":[{"cid":89,"content":"测试1","createTime":"2017-12-18T13:59:26","jid":null,"mvp":null,"nickname":"123","praiseNum":0,"uid":2719,"wid":223}],"cover":"https://www.zhaoapi.cn/images/quarter/151338850155520171216094126.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":7,"latitude":"null","localUri":null,"longitude":"null","playNum":1,"praiseNum":3,"uid":170,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15131486893501.jpg","nickname":"beautiful","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1513388501555VID_20171216_094056.3gp","wid":223,"workDesc":"视频"},{"commentNum":2,"comments":[{"cid":59,"content":"%E4%BD%A0%E5%A5%BD","createTime":"2017-12-16T11:16:00","jid":null,"mvp":null,"nickname":"李灿灿","praiseNum":0,"uid":148,"wid":221},{"cid":70,"content":"yy","createTime":"2017-12-16T11:56:56","jid":null,"mvp":null,"nickname":"李灿灿","praiseNum":0,"uid":148,"wid":221}],"cover":"https://www.zhaoapi.cn/images/quarter/1513334984104cover.jpg","createTime":"2017-12-17T19:20:44","favoriteNum":2,"latitude":"","localUri":null,"longitude":"","playNum":21,"praiseNum":1,"uid":154,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15131486893501.jpg","nickname":"beautiful","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/15133349841041513246461819.mp4","wid":221,"workDesc":"  "}]
     */

    public String msg;
    public String code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * commentNum : 2
         * comments : [{"cid":50,"content":"亚麻得","createTime":"2017-12-15T14:52:37","jid":null,"mvp":null,"nickname":"小狼","praiseNum":0,"uid":150,"wid":218},{"cid":67,"content":"pp","createTime":"2017-12-16T11:53:56","jid":null,"mvp":null,"nickname":"李灿灿","praiseNum":0,"uid":148,"wid":218}]
         * cover : https://www.zhaoapi.cn/images/quarter/1513248624521cover.jpg
         * createTime : 2017-12-17T19:20:44
         * favoriteNum : 1
         * latitude : 101
         * localUri : null
         * longitude : 102
         * playNum : 3
         * praiseNum : 4
         * uid : 154
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15131486893501.jpg","nickname":"beautiful","praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1513248624521PictureSelector_20171214_184937.mp4
         * wid : 218
         * workDesc : 111
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
             * icon : https://www.zhaoapi.cn/images/15131486893501.jpg
             * nickname : beautiful
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
             * cid : 50
             * content : 亚麻得
             * createTime : 2017-12-15T14:52:37
             * jid : null
             * mvp : null
             * nickname : 小狼
             * praiseNum : 0
             * uid : 150
             * wid : 218
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

package com.example.zsd.entity;

import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/11/28.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetVideos {
    /**
     * msg : 获取作品列表成功
     * code : 0
     * data : [{"commentNum":2,"comments":[{"cid":7,"content":"评论评论评论","createTime":"2017-11-27T23:34:37","eid":null,"mvp":null,"praiseNum":0,"uid":72,"wid":2},{"cid":8,"content":"评论评论评论","createTime":"2017-11-27T23:34:41","eid":null,"mvp":null,"praiseNum":0,"uid":71,"wid":2}],"cover":"http://www.zhaoapi.cn/images/icon.png","createTime":"2017-11-27T23:32:50","favoriteNum":0,"latitude":null,"localUri":null,"longitude":null,"playNum":null,"praiseNum":0,"uid":72,"user":{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-11-15T17:01:10","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/72.jpg","latitude":null,"longitude":null,"mobile":"13832312132","money":0,"nickname":"QQ","password":"111111","praiseNum":null,"token":"AB6478E2D4AB73A92F31243EA4CD9F50","uid":72,"username":"13832312132"},"videoUrl":"http://www.zhaoapi.cn/","wid":2,"workDesc":"我是描述2"},{"commentNum":6,"comments":[{"cid":1,"content":"评论评论评论","createTime":"2017-11-27T22:59:31","eid":null,"mvp":null,"praiseNum":0,"uid":71,"wid":1},{"cid":2,"content":"评论评论评论","createTime":"2017-11-27T22:59:33","eid":null,"mvp":null,"praiseNum":0,"uid":71,"wid":1},{"cid":3,"content":"评论评论评论","createTime":"2017-11-27T23:04:00","eid":null,"mvp":null,"praiseNum":0,"uid":71,"wid":1},{"cid":4,"content":"评论评论评论","createTime":"2017-11-27T23:04:02","eid":null,"mvp":null,"praiseNum":0,"uid":71,"wid":1},{"cid":5,"content":"评论评论评论","createTime":"2017-11-27T23:34:24","eid":null,"mvp":null,"praiseNum":0,"uid":71,"wid":1},{"cid":6,"content":"评论评论评论","createTime":"2017-11-27T23:34:30","eid":null,"mvp":null,"praiseNum":0,"uid":72,"wid":1}],"cover":"http://www.zhaoapi.cn/images/icon.png","createTime":"2017-11-27T23:34:04","favoriteNum":2,"latitude":null,"localUri":"","longitude":null,"playNum":null,"praiseNum":1,"uid":71,"user":{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-11-28T08:19:59","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/71.jpg","latitude":null,"longitude":null,"mobile":"18612991023","money":0,"nickname":"123456","password":"111111","praiseNum":null,"token":"58231D3E963D88765BB0130473BD3636","uid":71,"username":"18612991023"},"videoUrl":"http://www.zhaoapi.cn/","wid":1,"workDesc":"我是描述"}]
     */

    public String msg;
    public String code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * commentNum : 2
         * comments : [{"cid":7,"content":"评论评论评论","createTime":"2017-11-27T23:34:37","eid":null,"mvp":null,"praiseNum":0,"uid":72,"wid":2},{"cid":8,"content":"评论评论评论","createTime":"2017-11-27T23:34:41","eid":null,"mvp":null,"praiseNum":0,"uid":71,"wid":2}]
         * cover : http://www.zhaoapi.cn/images/icon.png
         * createTime : 2017-11-27T23:32:50
         * favoriteNum : 0
         * latitude : null
         * localUri : null
         * longitude : null
         * playNum : null
         * praiseNum : 0
         * uid : 72
         * user : {"age":null,"appkey":null,"appsecret":null,"createtime":"2017-11-15T17:01:10","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/72.jpg","latitude":null,"longitude":null,"mobile":"13832312132","money":0,"nickname":"QQ","password":"111111","praiseNum":null,"token":"AB6478E2D4AB73A92F31243EA4CD9F50","uid":72,"username":"13832312132"}
         * videoUrl : http://www.zhaoapi.cn/
         * wid : 2
         * workDesc : 我是描述2
         */

        public int commentNum;
        public String cover;
        public String createTime;
        public int favoriteNum;
        public Object latitude;
        public Object localUri;
        public Object longitude;
        public Object playNum;
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
             * appkey : null
             * appsecret : null
             * createtime : 2017-11-15T17:01:10
             * email : null
             * fans : null
             * follow : null
             * gender : 0
             * icon : https://www.zhaoapi.cn/images/72.jpg
             * latitude : null
             * longitude : null
             * mobile : 13832312132
             * money : 0
             * nickname : QQ
             * password : 111111
             * praiseNum : null
             * token : AB6478E2D4AB73A92F31243EA4CD9F50
             * uid : 72
             * username : 13832312132
             */

            public Object age;
            public Object appkey;
            public Object appsecret;
            public String createtime;
            public Object email;
            public Object fans;
            public Object follow;
            public int gender;
            public String icon;
            public Object latitude;
            public Object longitude;
            public String mobile;
            public int money;
            public String nickname;
            public String password;
            public Object praiseNum;
            public String token;
            public int uid;
            public String username;
        }

        public static class CommentsBean {
            /**
             * cid : 7
             * content : 评论评论评论
             * createTime : 2017-11-27T23:34:37
             * eid : null
             * mvp : null
             * praiseNum : 0
             * uid : 72
             * wid : 2
             */

            public int cid;
            public String content;
            public String createTime;
            public Object eid;
            public Object mvp;
            public int praiseNum;
            public int uid;
            public int wid;
        }
    }
}

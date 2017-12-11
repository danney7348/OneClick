package com.example.zsd.entity;

import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/12/11.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class SearchFriends {

    /**
     * msg : 查询成功
     * code : 0
     * data : [{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-09T10:22:26","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/146.jpg","latitude":null,"longitude":null,"mobile":"13717830672","money":0,"nickname":"昵称是一个萝卜","password":"123456","praiseNum":null,"token":"929A310F425923598C7F3495BCAAA278","uid":146,"userId":null,"username":"13717830672"}]
     * page : 1
     */

    public String msg;
    public String code;
    public int page;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * age : null
         * appkey : null
         * appsecret : null
         * createtime : 2017-12-09T10:22:26
         * email : null
         * fans : null
         * follow : null
         * gender : 0
         * icon : https://www.zhaoapi.cn/images/146.jpg
         * latitude : null
         * longitude : null
         * mobile : 13717830672
         * money : 0
         * nickname : 昵称是一个萝卜
         * password : 123456
         * praiseNum : null
         * token : 929A310F425923598C7F3495BCAAA278
         * uid : 146
         * userId : null
         * username : 13717830672
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
        public Object userId;
        public String username;
    }
}

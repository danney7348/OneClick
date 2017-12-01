package com.example.zsd.entity;

import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/12/1.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetFollowUsers {
    /**
     * msg : 获取关注用户列表成功
     * code : 0
     * data : [{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-11-15T17:01:10","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/72.jpg","latitude":null,"longitude":null,"mobile":"13832312132","money":0,"nickname":"QQ","password":"111111","praiseNum":null,"token":"AB6478E2D4AB73A92F31243EA4CD9F50","uid":72,"userId":null,"username":"13832312132"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-01T10:14:23","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/73.jpg","latitude":null,"longitude":null,"mobile":"15910489658","money":0,"nickname":"蒋顺聪","password":"111111","praiseNum":null,"token":"2062A865CF010E126AFC0F1442BC7D49","uid":73,"userId":null,"username":"15910489658"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-09-29T09:50:10","email":null,"fans":null,"follow":null,"gender":0,"icon":null,"latitude":null,"longitude":null,"mobile":"123456789","money":0,"nickname":null,"password":"123456","praiseNum":null,"token":null,"uid":74,"userId":null,"username":"123456789"}]
     */

    public String msg;
    public String code;
    public List<DataBean> data;

    public static class DataBean {
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
         * userId : null
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
        public Object userId;
        public String username;
    }
}

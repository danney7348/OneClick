package com.example.zsd.entity;

/**
 * 作者： 张少丹
 * 时间：  2017/11/28.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class LoginBean {


    /**
     * msg : 登录成功
     * code : 0
     * data : {"age":null,"appkey":null,"appsecret":null,"createtime":"2017-11-28T19:30:14","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/188.jpg","latitude":null,"longitude":null,"mobile":"18201205512","money":0,"nickname":"李方印","password":"123456","praiseNum":null,"token":"1CF78CD99420BCC297A5673C248769BD","uid":188,"userId":null,"username":"18201205512"}
     */

    public String msg;
    public String code;
    public DataBean data;

    public static class DataBean {
        /**
         * age : null
         * appkey : null
         * appsecret : null
         * createtime : 2017-11-28T19:30:14
         * email : null
         * fans : null
         * follow : null
         * gender : 0
         * icon : https://www.zhaoapi.cn/images/188.jpg
         * latitude : null
         * longitude : null
         * mobile : 18201205512
         * money : 0
         * nickname : 李方印
         * password : 123456
         * praiseNum : null
         * token : 1CF78CD99420BCC297A5673C248769BD
         * uid : 188
         * userId : null
         * username : 18201205512
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

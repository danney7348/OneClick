package com.example.zsd.entity;

/**
 * 作者： 张少丹
 * 时间：  2017/11/27.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetUserInfo {

    /**
     * msg : 获取用户信息成功
     * code : 0
     * data : {"age":null,"appkey":null,"appsecret":null,"createtime":"2017-11-27T20:23:18","email":null,"fans":0,"follow":0,"gender":0,"icon":"https://www.zhaoapi.cn/images/170.jpg","latitude":null,"longitude":null,"mobile":"15297526557","money":0,"nickname":"张少丹","password":"123456","praiseNum":null,"token":"D9C75CAADF0EE4C106A4C4D9B4DE1B19","uid":170,"username":"15297526557"}
     */

    public String msg;
    public String code;
    public DataBean data;

    public static class DataBean {
        /**
         * age : null
         * appkey : null
         * appsecret : null
         * createtime : 2017-11-27T20:23:18
         * email : null
         * fans : 0
         * follow : 0
         * gender : 0
         * icon : https://www.zhaoapi.cn/images/170.jpg
         * latitude : null
         * longitude : null
         * mobile : 15297526557
         * money : 0
         * nickname : 张少丹
         * password : 123456
         * praiseNum : null
         * token : D9C75CAADF0EE4C106A4C4D9B4DE1B19
         * uid : 170
         * username : 15297526557
         */

        public Object age;
        public Object appkey;
        public Object appsecret;
        public String createtime;
        public Object email;
        public int fans;
        public int follow;
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
}

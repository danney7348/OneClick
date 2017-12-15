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
     * data : [{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-14T16:06:13","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/1512470827115mo.jpg","latitude":null,"longitude":null,"mobile":"18410261121","money":0,"nickname":"nnnnnn","password":"111111","praiseNum":null,"token":"C5F1896E305FA85630AA9BB54A621BC3","uid":195,"userId":null,"username":"18410261121"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-14T16:06:26","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/154.jpg","latitude":null,"longitude":null,"mobile":"13773359134","money":0,"nickname":"笑出腹肌的男人","password":"654321","praiseNum":null,"token":"B77920CD2D38574F335E2C137F821D61","uid":154,"userId":null,"username":"13773359134"}]
     */

    public String msg;
    public String code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * age : null
         * appkey : null
         * appsecret : null
         * createtime : 2017-12-14T16:06:13
         * email : null
         * fans : null
         * follow : null
         * gender : 0
         * icon : https://www.zhaoapi.cn/images/1512470827115mo.jpg
         * latitude : null
         * longitude : null
         * mobile : 18410261121
         * money : 0
         * nickname : nnnnnn
         * password : 111111
         * praiseNum : null
         * token : C5F1896E305FA85630AA9BB54A621BC3
         * uid : 195
         * userId : null
         * username : 18410261121
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

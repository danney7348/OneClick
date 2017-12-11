package com.example.zsd.entity;

import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/12/11.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class RandomFriends {

    /**
     * msg : 请求成功
     * code : 1
     * data : [{"age":null,"appkey":"191953647ec609b4","appsecret":"25F705FBB27DB1E924809B8CB022142A","createtime":"2017-12-05T19:39:28","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15860061339","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":null,"uid":3325,"userId":null,"username":"15860061339"},{"age":null,"appkey":"ab6a3e3d17a8d59e","appsecret":"0905924795E4145F470F6E049CF3BB2C","createtime":"2017-12-05T19:40:18","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15890062339","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":null,"uid":3326,"userId":null,"username":"15890062339"},{"age":null,"appkey":"5171540bc52912ba","appsecret":"CE06E2945E64BDB457485605825F62E4","createtime":"2017-12-05T19:42:44","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13574578954","money":null,"nickname":null,"password":"79481C5104454D177C56D15CA1A593EC","praiseNum":null,"token":null,"uid":3327,"userId":null,"username":"13574578954"},{"age":null,"appkey":"8dc10dd8b9a239e6","appsecret":"4D90883E059E1431A66D3B6AF5D4F445","createtime":"2017-12-05T19:47:18","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13477777777","money":null,"nickname":null,"password":"36FEA9EDD86A667E4F3B327497470799","praiseNum":null,"token":null,"uid":3328,"userId":null,"username":"13477777777"},{"age":null,"appkey":"8dc30460a81cab1b","appsecret":"A85911856180E97E1C473F5D448882E1","createtime":"2017-12-05T19:52:58","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15930061339","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":null,"uid":3329,"userId":null,"username":"15930061339"},{"age":null,"appkey":"56838a97af4c5f92","appsecret":"D0290ABA583710FD9AED1974C9FFD6BF","createtime":"2017-12-05T19:53:41","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"17600287150","money":null,"nickname":null,"password":"36FEA9EDD86A667E4F3B327497470799","praiseNum":null,"token":null,"uid":3330,"userId":null,"username":"17600287150"},{"age":null,"appkey":"c6138826127f0935","appsecret":"B946D9D002077D2B8D2F3E7AA603BC87","createtime":"2017-12-05T19:54:53","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15201257161","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":null,"uid":3331,"userId":null,"username":"15201257161"},{"age":null,"appkey":"b7133122b38521d1","appsecret":"F1CDEBC54D1440E27FB4A2C8E25A4B0D","createtime":"2017-12-05T19:55:06","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15330061339","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":null,"uid":3332,"userId":null,"username":"15330061339"},{"age":null,"appkey":"3434f7038ca27d19","appsecret":"A713605F6E19DE70EDF6AEA9C9F6B6C5","createtime":"2017-12-05T19:55:47","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15201257162","money":null,"nickname":null,"password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":null,"uid":3333,"userId":null,"username":"15201257162"},{"age":null,"appkey":"efb44682092a0063","appsecret":"158CBDAEF721500711AFC664FA14CB50","createtime":"2017-12-05T19:56:26","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"15830061335","money":null,"nickname":null,"password":"484C9BA39687C80693A78A7244859195","praiseNum":null,"token":null,"uid":3334,"userId":null,"username":"15830061335"}]
     */

    public String msg;
    public String code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * age : null
         * appkey : 191953647ec609b4
         * appsecret : 25F705FBB27DB1E924809B8CB022142A
         * createtime : 2017-12-05T19:39:28
         * email : null
         * fans : null
         * follow : null
         * gender : null
         * icon : null
         * latitude : null
         * longitude : null
         * mobile : 15860061339
         * money : null
         * nickname : null
         * password : 8F669074CAF5513351A2DE5CC22AC04C
         * praiseNum : null
         * token : null
         * uid : 3325
         * userId : null
         * username : 15860061339
         */

        public Object age;
        public String appkey;
        public String appsecret;
        public String createtime;
        public Object email;
        public Object fans;
        public Object follow;
        public Object gender;
        public Object icon;
        public Object latitude;
        public Object longitude;
        public String mobile;
        public Object money;
        public Object nickname;
        public String password;
        public Object praiseNum;
        public Object token;
        public int uid;
        public Object userId;
        public String username;
    }
}

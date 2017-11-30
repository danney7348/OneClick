package com.example.zsd.entity;

import java.util.List;

/**
 * 作者： 张少丹
 * 时间：  2017/11/27.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */

public class GetJokes {

    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"so","createTime":"2017-11-30T08:17:26","imgUrls":null,"jid":269,"praiseNum":null,"shareNum":null,"uid":148,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/148.jpg","nickname":"lcc","praiseNum":"null"}},{"commentNum":null,"content":"so","createTime":"2017-11-30T08:17:26","imgUrls":null,"jid":268,"praiseNum":null,"shareNum":null,"uid":148,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/148.jpg","nickname":"lcc","praiseNum":"null"}},{"commentNum":null,"content":"0000000","createTime":"2017-11-30T08:01:48","imgUrls":null,"jid":267,"praiseNum":null,"shareNum":null,"uid":146,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/146.jpg","nickname":"昵称是一个萝卜","praiseNum":"null"}},{"commentNum":null,"content":"晚安","createTime":"2017-11-29T23:43:50","imgUrls":"https://www.zhaoapi.cn/images/quarter/151196967322720171129233416.jpg|https://www.zhaoapi.cn/images/quarter/151197023083620171129234333.jpg","jid":266,"praiseNum":null,"shareNum":null,"uid":92,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/92.jpg","nickname":"金鳞","praiseNum":"null"}},{"commentNum":null,"content":"二狗你飘了 哈哈","createTime":"2017-11-29T23:34:33","imgUrls":"https://www.zhaoapi.cn/images/quarter/151196967322720171129233416.jpg","jid":265,"praiseNum":null,"shareNum":null,"uid":92,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/92.jpg","nickname":"金鳞","praiseNum":"null"}},{"commentNum":null,"content":"9999999","createTime":"2017-11-29T21:39:04","imgUrls":null,"jid":264,"praiseNum":null,"shareNum":null,"uid":675,"user":{"age":null,"fans":"null","follow":"null","icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"88888","createTime":"2017-11-29T21:24:17","imgUrls":"https://www.zhaoapi.cn/images/quarter/tu.jpg|https://www.zhaoapi.cn/images/quarter/tu.jpg|https://www.zhaoapi.cn/images/quarter/tu.jpg|https://www.zhaoapi.cn/images/quarter/tu.jpg|https://www.zhaoapi.cn/images/quarter/tu.jpg|https://www.zhaoapi.cn/images/quarter/tu.jpg|https://www.zhaoapi.cn/images/quarter/tu.jpg|https://www.zhaoapi.cn/images/quarter/tu.jpg|https://www.zhaoapi.cn/images/quarter/image.jpg|https://www.zhaoapi.cn/images/quarter/image.jpg|https://www.zhaoapi.cn/images/quarter/image.jpg|https://www.zhaoapi.cn/images/quarter/image.jpg|https://www.zhaoapi.cn/images/quarter/tu.jpg|https://www.zhaoapi.cn/images/quarter/tu.jpg|https://www.zhaoapi.cn/images/quarter/tu.jpg","jid":263,"praiseNum":null,"shareNum":null,"uid":99,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/99.jpg","nickname":"Zhu","praiseNum":"null"}},{"commentNum":null,"content":"段子段子","createTime":"2017-11-29T21:22:59","imgUrls":null,"jid":262,"praiseNum":null,"shareNum":null,"uid":144,"user":{"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/144.jpg","nickname":"乔君","praiseNum":"null"}},{"commentNum":null,"content":"123","createTime":"2017-11-29T21:22:47","imgUrls":null,"jid":261,"praiseNum":null,"shareNum":null,"uid":675,"user":{"age":null,"fans":"null","follow":"null","icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"123","createTime":"2017-11-29T21:22:06","imgUrls":null,"jid":260,"praiseNum":null,"shareNum":null,"uid":675,"user":{"age":null,"fans":"null","follow":"null","icon":null,"nickname":null,"praiseNum":"null"}}]
     */

    public String msg;
    public String code;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * commentNum : null
         * content : so
         * createTime : 2017-11-30T08:17:26
         * imgUrls : null
         * jid : 269
         * praiseNum : null
         * shareNum : null
         * uid : 148
         * user : {"age":null,"fans":"null","follow":"null","icon":"https://www.zhaoapi.cn/images/148.jpg","nickname":"lcc","praiseNum":"null"}
         */

        public Object commentNum;
        public String content;
        public String createTime;
        public Object imgUrls;
        public int jid;
        public Object praiseNum;
        public Object shareNum;
        public int uid;
        public UserBean user;

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : null
             * icon : https://www.zhaoapi.cn/images/148.jpg
             * nickname : lcc
             * praiseNum : null
             */

            public Object age;
            public String fans;
            public String follow;
            public String icon;
            public String nickname;
            public String praiseNum;
        }
    }
}

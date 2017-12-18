package com.example.zsd.utils;

/**
 * 作者： 张少丹
 * 时间：  2017/11/13.
 * 邮箱：1455456581@qq.com
 * 类的用途：
 */
public class StringUtils {
    private static final String USER_NAME_REGEX = "^[a-zA-Z]\\w{2,19}$";

    private static final String PASSWORD_REGEX = "^[0-9]{3,20}$";


    public static boolean checkUserName(String userName) {
        return userName.matches(USER_NAME_REGEX);
    }
    public static boolean checkPassword(String pwd) {
        return pwd.matches(PASSWORD_REGEX);
    }

}

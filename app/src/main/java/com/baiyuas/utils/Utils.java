package com.baiyuas.utils;

import java.util.List;

/**
 * @作者: Leo
 * @时间:2018/3/10
 * @描述:https://baiyuas.github.io/
 */
public class Utils {

    public static boolean checkNull(Object obj) {
        return obj == null;
    }

    public static boolean isEmptyList(List data) {
        return data == null || data.size() <= 0;
    }

    public static boolean isValidEmail(String email) {
        return email.contains("@");
    }

    public static boolean isValidPassword(String password) {
        return password.length() > 4;
    }

}

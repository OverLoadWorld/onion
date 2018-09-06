package com.nearu.util;

/**
 * Title
 *
 * @Description:
 * @Author: Zhao Zhenhua [zhaozhenhua1@xiaomi.com]
 * @Since: 9/6/18 4:49 PM
 */
public class CastUtil {

    public static String castString(Object object){
        return castString(object, "null");
    }

    public static String castString(Object object, String defaultValue){
        return object != null ? String.valueOf(object) : defaultValue;
    }
}

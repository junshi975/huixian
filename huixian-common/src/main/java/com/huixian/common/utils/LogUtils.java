package com.huixian.common.utils;

/**
 * 日志文件处理
 * @author JUNSHI 405773808@qq.com
 * @create 2020-08-25 14:30
 */
public class LogUtils {
    public static String getBlock(Object msg) {
        if (msg == null) {
            msg = "";
        }
        return "[" + msg.toString() + "]";
    }
}

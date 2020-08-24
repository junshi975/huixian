package com.huixian.common.utils.ip;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP的工具类
 * @author JUNSHI 405773808@qq.com
 * @create 2020-08-24 13:46
 */
public class IPUtils {
    /**
     * 获取用户ip地址
     */
    public static String getIpAddress(HttpServletRequest request) {
        //如果请求为空
        if (request == null) {
            return "unknown";
        }
        String ipAddress = request.getHeader("x-forwarded-for");

        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                    ipAddress = inet.getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) { //"***.***.***.***".length() = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }


    public static String getLocalIP() throws UnknownHostException {
        String localIP = "";
        InetAddress addr = (InetAddress) InetAddress.getLocalHost();

        localIP = addr.getHostAddress().toString();
        return localIP;
    }


}

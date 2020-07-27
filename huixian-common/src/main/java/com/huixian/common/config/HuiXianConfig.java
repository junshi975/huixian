package com.huixian.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-27 14:33
 */
@Component
@ConfigurationProperties(prefix = "huixian")
public class HuiXianConfig {


    /**
     * 项目名称
     */
    private String name;

    /**
     * 版本
     */
    private String version;

    /**
     * 版权年份
     */
    private String copyrightYear;

    /**
     * 上传路径
     */
    private static String profile;

    /**
     * 头像路径
     */
    private static String photo;

    /**
     * 获取地址开关
     */
    private static boolean addressEnabled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCopyrightYear() {
        return copyrightYear;
    }

    public void setCopyrightYear(String copyrightYear) {
        this.copyrightYear = copyrightYear;
    }


    public static String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        HuiXianConfig.profile = profile;
    }

    public static boolean isAddressEnabled() {
        return addressEnabled;
    }

    public void setAddressEnabled(boolean addressEnabled) {
        HuiXianConfig.addressEnabled = addressEnabled;
    }

    public static String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        HuiXianConfig.photo = photo;
    }

    /**
     * 获取头像上传路径
     */
    public static String getAvatarPath() {
        return getProfile() + "/avatar";
    }

    /**
     * 获取下载路径
     */
    public static String getDownloadPath() {
        return getProfile() + "/download/";
    }

    /**
     * 获取上传路径
     */
    public static String getUploadPath() {
        return getProfile() + "/upload";
    }
}


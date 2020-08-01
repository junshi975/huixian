package com.huixian.system.service;

import com.huixian.common.domain.UserInfo;

import java.util.List;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-24 20:59
 */
public interface UserInfoService {

    List<UserInfo> findAllUsers();


    /**
     * 登陆系统
     * @param stuId   用户学号号
     * @param password 密码
     * @return 登陆成功返回true，登陆失败返回false
     */
    boolean login(String stuId,String password);

}

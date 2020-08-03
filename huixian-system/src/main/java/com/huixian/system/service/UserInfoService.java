package com.huixian.system.service;

import com.huixian.common.domain.UserInfo;

import java.util.List;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-24 20:59
 */
public interface UserInfoService {

    /**
     * 查询所有用户信息
     * @return
     * @throws Exception
     */
    List<UserInfo> findAllUsers() throws Exception;


    /**
     * 登陆系统
     * @param stuId    用户学号号
     * @param password 密码
     * @return 登陆成功返回true，登陆失败返回false
     */
    boolean login(String stuId, String password) throws Exception;


    /**
     * 修改账号密码
     * @param stuId  学号
     * @param pwd    旧密码
     * @param newPwd 新密码
     * @return 返回true表示修改成功，返回false表示修改失败
     */
    boolean updatePwd(String stuId, String pwd, String newPwd) throws Exception;
}

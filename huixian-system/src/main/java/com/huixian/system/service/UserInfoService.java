package com.huixian.system.service;

import com.huixian.common.pojo.UserInfo;

import java.util.List;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-24 20:59
 */
public interface UserInfoService {

    List<UserInfo> findAllUsers();
}

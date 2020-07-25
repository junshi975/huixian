package com.huixian.system.service.impl;

import com.huixian.common.pojo.UserInfo;
import com.huixian.system.mapper.UserInfoMapper;
import com.huixian.system.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-24 20:59
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> findAllUsers() {
        return userInfoMapper.findAllUsers();
    }
}

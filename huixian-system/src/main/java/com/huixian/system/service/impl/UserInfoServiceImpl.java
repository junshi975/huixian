package com.huixian.system.service.impl;

import com.huixian.common.domain.UserInfo;
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
    public List<UserInfo> findAllUsers() throws Exception {
        return userInfoMapper.findAllUsers();
    }

    @Override
    public boolean login(String stuId, String password) throws Exception {

        if (userInfoMapper.findUserByStuIdAndPassWord(stuId, password) == null) {
            return false;

        } else {
            return true;
        }
    }

    @Override
    public boolean updatePwd(String stuId, String pwd, String newPwd) throws Exception {
        //根据账号密码查询用户
        UserInfo user = userInfoMapper.findUserByStuIdAndPassWord(stuId, pwd);
        //如果不为空，那么原密码正确
        if (user != null) {
            //开始修改
            userInfoMapper.updatePassword(stuId, newPwd);
            //修改成功后返回true
            return true;
        }
        return false;
    }
}

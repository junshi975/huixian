package com.huixian.web;


import com.huixian.common.config.HuiXianConfig;
import com.huixian.common.domain.UserInfo;
import com.huixian.common.utils.sign.Md5Utils;
import com.huixian.system.mapper.AvatarMapper;
import com.huixian.system.mapper.UserInfoMapper;
import com.huixian.system.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class HuiXianAdminApplicationTests {

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    AvatarMapper avatarMapper;
    @Test
    void contextLoads() throws Exception {
        //userInfoMapper.findAllUsers().forEach(System.out::println);
        //System.out.println(avatarMapper.findAvatarById(1));
        //System.out.println(userInfoMapper.findUserById("F7F6D2AECE3211EAB12A00163E0E371C"));
        //System.out.println(userInfoMapper.findUserByStuIdAndPassWord("0","admin"));
        //System.out.println(userInfoMapper.findUserCount());
        //    System.out.println(userInfoMapper.updateAvatar(6, "f3226"));
        System.out.println(userInfoMapper.findFileIdByFileName("1596455402964.jpg"));
    }



}

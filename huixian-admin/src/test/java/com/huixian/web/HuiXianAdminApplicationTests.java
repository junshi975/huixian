package com.huixian.web;


import com.huixian.common.config.HuiXianConfig;
import com.huixian.common.pojo.UserInfo;
import com.huixian.common.utils.file.FileUtils;
import com.huixian.system.mapper.UserInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
public class HuiXianAdminApplicationTests {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void contextLoads() throws SQLException {

        //System.out.println(userInfoMapper.findUserById("F7F6D2AECE3211EAB12A00163E0E371C"));
        //userInfoMapper.addUser(new UserInfo(IdUtils.simpleUUID(),
        //        IdUtils.simpleUUID().substring(1,6),
        //        IdUtils.simpleUUID().substring(1,6),
        //        IdUtils.simpleUUID().substring(1,6),
        //        IdUtils.simpleUUID().substring(1,6),
        //        1,
        //        IdUtils.simpleUUID().substring(1,6),
        //        IdUtils.simpleUUID().substring(1,6),
        //        "static/img/defulat.png",
        //        1
        //));
        //for (int i = 0;i<20;i++){
        //    userInfoMapper.addUser(new UserInfo(null, IdUtils.simpleUUID().substring(1, 6), IdUtils.simpleUUID().substring(1, 6),
        //            IdUtils.simpleUUID().substring(1, 6),
        //            IdUtils.simpleUUID().substring(1, 6),
        //            null,
        //            IdUtils.simpleUUID().substring(1, 6),
        //            IdUtils.simpleUUID().substring(1, 6),
        //            null, null
        //    ));
        //}
        //userInfoMapper.addUser(new UserInfo(null, IdUtils.simpleUUID().substring(1, 6), IdUtils.simpleUUID().substring(1, 6),
        //        IdUtils.simpleUUID().substring(1, 6),
        //        IdUtils.simpleUUID().substring(1, 6),
        //        null,
        //        IdUtils.simpleUUID().substring(1, 6),
        //        IdUtils.simpleUUID().substring(1, 6),
        //        null, null
        //));
        //userInfoMapper.findAllUsers().forEach(System.out::println);
        //System.out.println("删除之前：" +userInfoMapper.findUserCount());
        //userInfoMapper.deleteUserById("75EB7E43CFC211EAB12A00163E0E371C");
        //System.out.println("删除之后：" +userInfoMapper.findUserCount());

        System.out.println("修改之前：" + userInfoMapper.findUserById("75DBB1EDCFC211EAB12A00163E0E371C"));
        userInfoMapper.updateUserById(new UserInfo("75DBB1EDCFC211EAB12A00163E0E371C", null, null, null, null, 1, null, null, null, 1));
        System.out.println("修改之后：" + userInfoMapper.findUserById("75DBB1EDCFC211EAB12A00163E0E371C"));

    }

    @Test
    public void testMapper() {
        //System.out.println(userInfoMapper.findUserByStuIdAndPassWord(new UserInfo(null, null, "admin", null, "0", null, null, null, null, null)));
        //System.out.println(FileUtils.fileExists("C:\\Users\\JUN\\Desktop\\惠闲交易系统\\io\\1595838905573.jpg"));
        System.out.println(HuiXianConfig.getPhoto());
    }

}

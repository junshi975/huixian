package com.huixian.admin;



import com.huixian.system.mapper.UserInfoMapper;
import com.huixian.system.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
public class HuiXianAdminApplicationTests {


    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserInfoService userInfoService;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(userInfoService.findAllUsers());

    }

}

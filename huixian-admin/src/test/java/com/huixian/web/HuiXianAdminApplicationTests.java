package com.huixian.web;


import com.huixian.common.domain.UserInfo;
import com.huixian.system.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class HuiXianAdminApplicationTests {

    @Autowired
    UserInfoService userInfoService;

    @Test
    void contextLoads()  {

    }

}

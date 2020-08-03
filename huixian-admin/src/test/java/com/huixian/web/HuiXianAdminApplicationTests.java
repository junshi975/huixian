package com.huixian.web;


import com.huixian.common.domain.UserInfo;
import com.huixian.common.utils.sign.Md5Utils;
import com.huixian.system.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class HuiXianAdminApplicationTests {

    @Autowired
    UserInfoService userInfoService;

    @Test
    void contextLoads()  {
       String txt = "ab123";
        System.out.println(Md5Utils.hash(txt));
    }

}

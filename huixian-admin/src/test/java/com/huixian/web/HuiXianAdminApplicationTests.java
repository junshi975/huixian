package com.huixian.web;


import com.github.pagehelper.PageHelper;
import com.huixian.center.aspectj.LogAspect;
import com.huixian.common.utils.sign.Md5Utils;
import com.huixian.system.mapper.SysLogMapper;
import com.huixian.system.service.SysLogService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootTest
public class HuiXianAdminApplicationTests {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private SysLogService sysLogService;
    @Autowired
    private SysLogMapper sysLogMapper;


    @Test
    void contextLoads() throws Exception {
        System.out.println(Md5Utils.hash("202cb962ac59075b964b07152d234b70"));
        System.out.println(Md5Utils.hash("123"));
    }


}

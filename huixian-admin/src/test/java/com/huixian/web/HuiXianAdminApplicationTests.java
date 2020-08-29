package com.huixian.web;


import com.github.pagehelper.PageHelper;
import com.huixian.center.aspectj.LogAspect;
import com.huixian.common.entiry.SysLog;
import com.huixian.common.entiry.SysLogininfor;
import com.huixian.common.utils.ip.AddressUtils;
import com.huixian.common.utils.ip.IPUtils;
import com.huixian.system.mapper.SysLogMapper;
import com.huixian.system.mapper.SysLogininforMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;


@SpringBootTest
public class HuiXianAdminApplicationTests {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private SysLogininforMapper sysLogininforMapper;


    @Test
    void contextLoads() throws Exception {

        String[] ids = {"1","2"} ;
        System.out.println(sysLogininforMapper.deleteLoginLogByIds(ids));
    }


}

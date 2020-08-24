package com.huixian.web;


import com.huixian.center.aspectj.LogAspect;
import com.huixian.common.domain.SysLog;
import com.huixian.common.utils.DateUtils;
import com.huixian.system.mapper.SysLogMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class HuiXianAdminApplicationTests {
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private SysLogMapper sysLogMapper;


    @Test
    void contextLoads() throws Exception {
        try {
            SysLog sysLog = new SysLog("d07b19a4ef6a4fe096d6c6b7d33eb12e", DateUtils.getNowDate(), 0L, null, "admin", "192.168.56.1", "/api/ip", "com.huixian.web.controller.UserController.getIp()", "GET", "测试模块", 2, "{\"code\":200,\"data\":\"ip地址：192.168.56.1\",\"message\":\"处理成功！\"}");
            //System.out.println(sysLog);
            System.out.println(sysLogMapper.insertLog(sysLog));
            //sysLogMapper.findAllLog().forEach(System.out::println);

        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }


}

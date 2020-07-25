package com.huixian.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.huixian.system.mapper") //配置Mapper扫描的地址
public class HuiXianAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuiXianAdminApplication.class, args);
    }

}

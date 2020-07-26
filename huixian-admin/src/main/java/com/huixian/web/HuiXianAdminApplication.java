package com.huixian.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//配置Mapper扫描的地址
@MapperScan("com.huixian.system.mapper")
//配置扫描包的地址！重点！！！
@ComponentScan(basePackages = "com.huixian")
public class HuiXianAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(HuiXianAdminApplication.class, args);
    }

}

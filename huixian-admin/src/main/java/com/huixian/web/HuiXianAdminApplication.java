package com.huixian.web;

import com.huixian.center.filter.MyCharacterEncodingFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

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

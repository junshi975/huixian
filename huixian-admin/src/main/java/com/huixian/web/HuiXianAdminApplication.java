package com.huixian.web;


import com.huixian.common.config.HuiXianConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;


/**
 * 启动类：配置mapper扫描地址，与扫描组件
 * @author JUN
 */

@SpringBootApplication
@MapperScan("com.huixian.system.mapper")
@ComponentScan(basePackages = {"com.huixian"})
@EnableConfigurationProperties(HuiXianConfig.class)
public class HuiXianAdminApplication {




    public static void main(String[] args) {
        SpringApplication.run(HuiXianAdminApplication.class, args);

    }

}

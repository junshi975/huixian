package com.huixian.web.config;

import com.google.common.base.Predicates;
import com.huixian.common.entiry.ResultCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-26 11:31
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 是否开启swagger
     */
    @Value("${swagger.enabled}")
    private boolean enabled;

    /**
     * 配置docket
     */
    @Bean
    public Docket docket() {
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(
                new ResponseMessageBuilder().code(200).message("请求成功！").build()
        );
        responseMessageList.add(
                new ResponseMessageBuilder().code(100).message("请求失败！").build()
        );
        return new Docket(DocumentationType.SWAGGER_2)

                // 是否启用Swagger
                .enable(enabled)
                // 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
                .apiInfo(apiInfo())
                .host("https://www.codewhite.cn")
                .useDefaultResponseMessages(false)
                // 添加全局响应状态码
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
                // 设置哪些接口暴露给Swagger展示
                .select()
                // 扫描所有 .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                //错误路径不监控
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();
    }

    /**
     * 添加摘要信息
     */
    private ApiInfo apiInfo() {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                // 设置标题
                .title("惠闲二手系统_接口文档")
                .termsOfServiceUrl("https://www.codewhite.cn")
                // 描述
                .description("二手交易平台的后台API接口")
                // 作者信息
                .contact(new Contact("JUNSHI", "https://www.codewhite.cn", "junshi975@aliyun.com"))
                // 版本
                .version("版本号:V1.0")
                .build();
    }

}

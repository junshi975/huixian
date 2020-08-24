package com.huixian.common.annotation;


import com.huixian.common.enums.BusinessType;
import com.huixian.common.enums.OperatorType;

import java.lang.annotation.*;

/**
 * 自定义操作日志记录注解
 * @author ruoyi
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 模块
     */
    public String title() default "";

    /**
     * 功能
     */
    public BusinessType businessType() default BusinessType.OTHER;

}

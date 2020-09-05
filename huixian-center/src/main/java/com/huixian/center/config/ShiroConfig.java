package com.huixian.center.config;

import com.huixian.center.shiro.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * shiro配置类
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建Shiro过滤器工厂
     * @param manager 安全管理器
     * @return 返回Shiro过滤器工厂
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager manager) {

        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        filterFactoryBean.setSecurityManager(manager);
        return filterFactoryBean;
    }

    /**
     * 默认安全管理器
     * @param userRealm 关联的自定义Realm
     * @return 默认安全管理器
     */
    @Bean("securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {

        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        //关联realm
        manager.setRealm(userRealm);
        return manager;
    }

    /**
     * 创建Realm（Shiro连接数据的桥梁）
     * @return 返回一个Realm
     */
    @Bean("userRealm")
    public UserRealm getUserRealm() {
        return new UserRealm();
    }
}

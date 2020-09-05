package com.huixian.center.shiro;

import com.huixian.common.entiry.UserInfo;
import com.huixian.system.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义Realm
 * @author JUNSHI 405773808@qq.com
 * @create 2020-09-04 20:53
 */
public class UserRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRealm.class);

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 执行授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //创建授权信息对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        Object user = subject.getPrincipal();

        return info;
    }

    /**
     * 执行认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户token
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //获取对象
        UserInfo user = null;
        try {
            user = userInfoService.findUserInfoByStuId(token.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (user == null) {
            //用户名不存在
            //shiro底层会抛出UnKnowAccountException
            LOGGER.info("用户不存在！");
            return null;
        }
        // 返回身份验证信息
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}

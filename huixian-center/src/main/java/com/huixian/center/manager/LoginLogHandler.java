package com.huixian.center.manager;

import com.huixian.common.constant.Constants;
import com.huixian.common.entiry.SysLogininfor;
import com.huixian.common.utils.DateUtils;
import com.huixian.common.utils.LogUtils;
import com.huixian.common.utils.ServletUtils;
import com.huixian.common.utils.ip.AddressUtils;
import com.huixian.common.utils.ip.IPUtils;
import com.huixian.common.utils.uuid.IdUtils;
import com.huixian.system.service.SysLogininforService;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 登陆日志处理器
 * @author JUNSHI 405773808@qq.com
 * @create 2020-08-25 14:06
 */
@Component
public class LoginLogHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginLogHandler.class);

    @Autowired
    private SysLogininforService sysLogininforService;

    /**
     * 记录日志
     * @param username 登陆用户名
     * @param status   登陆状态
     * @param message  登陆信息
     * @return
     */
    public  boolean recording(String username, final String status, final String message) {

        try {
            // 通过当前的请求，从请求头获取用户代理
            final UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));

            // 获取当前请求下的ip地址
            final String ip = IPUtils.getIpAddress(ServletUtils.getRequest());
            //根据ip查询ip地址
            String address = AddressUtils.getRealAddressByIP(ip);

            StringBuilder s = new StringBuilder();
            s.append(LogUtils.getBlock(ip));
            s.append(address);
            s.append(LogUtils.getBlock(username));
            s.append(LogUtils.getBlock(status));
            s.append(LogUtils.getBlock(message));

            // 打印信息到日志
            LOGGER.info(s.toString());

            // 获取客户端浏览器
            String browser = userAgent.getBrowser().getName();
            // 获取客户端操作系统
            String os = userAgent.getOperatingSystem().getName();

            // 封装对象
            SysLogininfor logininfor = new SysLogininfor();
            logininfor.setId(IdUtils.fastSimpleUUID());
            logininfor.setUsername(username);
            logininfor.setIpaddr(ip);
            logininfor.setLoginLocation(address);
            logininfor.setBrowser(browser);
            logininfor.setOs(os);
            logininfor.setMsg(message);
            logininfor.setLoginTime(DateUtils.getNowDate());

            if (Constants.LOGIN_SUCCESS.equals(status) || Constants.LOGOUT.equals(status)) {
                //如果登陆成功，或者退出成功：设置Success
                logininfor.setStatus(Constants.SUCCESS);
            } else if (Constants.LOGIN_FAIL.equals(status)) {
                //如果登陆失败：设置FAIL
                logininfor.setStatus(Constants.FAIL);
            }
            sysLogininforService.saveLoginLog(logininfor);
            return true;

        } catch (Exception e) {
            LOGGER.error("=====登录日志发生错误！=====");
            LOGGER.error(e.getMessage());
            e.printStackTrace();

        }
        return false;
    }

}

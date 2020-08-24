package com.huixian.center.aspectj;

import com.alibaba.fastjson.JSONObject;
import com.huixian.common.annotation.Log;
import com.huixian.common.domain.SysLog;
import com.huixian.common.utils.DateUtils;
import com.huixian.common.utils.ServletUtils;
import com.huixian.common.utils.ip.IPUtils;
import com.huixian.common.utils.uuid.IdUtils;
import com.huixian.system.mapper.SysLogMapper;
import com.huixian.system.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * 操作日志记录处理
 * @author JUNSHI 405773808@qq.com
 * @create 2020-08-20 19:41
 */
@Aspect
@Component
public class LogAspect {

    /**
     * 日志记录器
     */
    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 执行时间
     */
    private Date startTime;

    @Autowired
    private SysLogService sysLogService;

    // 配置织入点
    @Pointcut("@annotation(com.huixian.common.annotation.Log)")
    public void logPointCut() {
    }

    @Before("logPointCut()")
    public void before() {
        startTime = DateUtils.getNowDate();
    }

    /**
     * 处理完请求后执行（returning方法的返回值）
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "logPointCut()", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult) {
        handleLog(joinPoint, null, jsonResult);
    }

    /**
     * 拦截异常操作
     * @param joinPoint 切点
     * @param e         异常
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        handleLog(joinPoint, e, null);
    }

    /**
     * 处理日志
     */
    protected void handleLog(final JoinPoint joinPoint, final Exception e, Object jsonResult) {
        try {

            Log controllerLog = getAnnotationLog(joinPoint);
            if (controllerLog == null) {
                return;
            }
            //获取访问的时长
            long time = System.currentTimeMillis() - startTime.getTime();

            //数据库日志
            SysLog sysLog = new SysLog();
            sysLog.setId(IdUtils.fastSimpleUUID());

            //获取ip地址
            String ip = IPUtils.getIpAddress(ServletUtils.getRequest());
            sysLog.setIp(ip);

            //获取请求的url
            sysLog.setUrl(ServletUtils.getRequest().getRequestURI());


            int length = JSONObject.toJSONString(jsonResult).length();
            String result = JSONObject.toJSONString(jsonResult);
            //如果大于数据库长度
            if (length >= 225) {
                result = "{}";
            }
            //方法返回的参数
            sysLog.setReturnArgs(result);


            // 设置方法名称:获取全类名
            String className = joinPoint.getTarget().getClass().getName();

            //获取访问的方法名称
            String methodName = joinPoint.getSignature().getName();
            //设置操作方法
            sysLog.setMethod(className + "." + methodName + "()");

            //请求的方式
            sysLog.setRequestType(ServletUtils.getRequest().getMethod());

            //开始操作时间
            sysLog.setOperatingTime(startTime);
            //执行时常
            sysLog.setUseTime(time);

            // 处理设置注解上的参数
            getControllerMethodDescription(joinPoint, controllerLog, sysLog);

            sysLogService.saveSysLog(sysLog);

        } catch (Exception ex) {
            // 记录本地异常日志
            log.error("==前置通知异常==");
            log.error("异常信息:{}", ex.getMessage());
            ex.printStackTrace();
        }

    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     * @param log     日志
     * @param operLog 操作日志
     * @throws Exception
     */
    public void getControllerMethodDescription(JoinPoint joinPoint, Log log, SysLog operLog) throws Exception {

        // 设置action动作：业务类型
        operLog.setBusinessType(log.businessType().ordinal());

        // 设置标题
        operLog.setTitle(log.title());

    }


    /**
     * 如果存在注解，那么截取
     */
    private Log getAnnotationLog(JoinPoint joinPoint) throws Exception {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            return method.getAnnotation(Log.class);
        }

        return null;
    }
}

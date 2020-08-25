package com.huixian.system.service;

import com.huixian.common.entiry.SysLogininfor;

import java.util.List;

/**
 * 登陆日志服务逻辑
 * @author JUNSHI 405773808@qq.com
 * @create 2020-08-25 21:29
 */
public interface SysLogininforService {

    /**
     * 查询所有日志
     */
    List<SysLogininfor> findAllLoginLog() throws Exception;

    /**
     * 根据id查询登陆日志
     */
    SysLogininfor findLoginLogById(String id) throws Exception;

    /**
     * 插入一条登陆日志
     * @param sysLog 登陆日志
     * @return true表示插入成功，false失败
     */
    boolean saveLoginLog(SysLogininfor sysLog) throws Exception;

    /**
     * 根据logid查询log
     * @param id 日志id
     * @return true表示插入成功，false失败
     */
    boolean deleteLoginLog(String id) throws Exception;

    /**
     * 批量删除系统登陆日志
     * @param ids 需要删除的登陆日志ID
     * @return 成功返回true，失败返回false
     */
    boolean deleteLoginLogByIds(String[] ids);

    /**
     * 清空登陆日志
     */
    void cleanLoginLog() throws Exception;
}

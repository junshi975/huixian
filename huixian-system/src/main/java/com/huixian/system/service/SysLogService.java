package com.huixian.system.service;

import com.huixian.common.entiry.SysLog;

import java.util.List;

/**
 * 日志服务层
 * @author JUNSHI 405773808@qq.com
 * @create 2020-08-24 21:54
 */
public interface SysLogService {

    /**
     * 查询所有日志
     */
    List<SysLog> findAllLog() throws Exception;

    /**
     * 根据id查询log
     */
    SysLog findLogById(String id) throws Exception;

    /**
     * 插入一条log日志
     * @param sysLog 日志
     * @return true表示插入成功，false失败
     */
    boolean saveSysLog(SysLog sysLog) throws Exception;

    /**
     * 根据logid查询log
     * @param id 日志id
     * @return true表示插入成功，false失败
     */
    boolean deleteSysLog(String id) throws Exception;

    /**
     * 批量删除系统操作日志
     * @param ids 需要删除的操作日志ID
     * @return 成功返回true，失败返回false
     */
    boolean deleteLogByIds(String[] ids);

    /**
     * 清空操作日志
     */
    boolean cleanSysLog() throws Exception;
}

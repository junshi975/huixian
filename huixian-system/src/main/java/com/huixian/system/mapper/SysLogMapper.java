package com.huixian.system.mapper;

import com.huixian.common.entiry.SysLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统操作日志mapper
 * @author JUNSHI 405773808@qq.com
 * @create 2020-08-24 20:59
 */
public interface SysLogMapper {

    /**
     * 查询所有Log
     */
    List<SysLog> findAllLog() throws Exception;

    /**
     * 根据id查询log
     */
    SysLog findLogById(String id)  throws Exception;

    /**
     * 插入一条log日志
     */
    int insertLog(SysLog sysLog)  throws Exception;


    /**
     * 插入多条日志
     */
    int insertLogs(@Param("sysLogs") List<SysLog> sysLogs)  throws Exception;

    /**
     * 根据logid查询log
     */
    int deleteLog(String id) throws Exception;

    /**
     * 清空所有日志
     */
    void cleanSysLog() throws Exception;

    /**
     *  批量删除系统操作日志
     * @param ids 需要删除的操作日志ID
     */
    int deleteLogByIds(String[] ids);

}

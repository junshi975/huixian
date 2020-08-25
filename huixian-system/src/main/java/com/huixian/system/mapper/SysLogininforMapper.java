package com.huixian.system.mapper;

import com.huixian.common.entiry.SysLog;
import com.huixian.common.entiry.SysLogininfor;

import java.util.List;

/**
 * 登陆日志mapper
 * @author JUNSHI 405773808@qq.com
 * @create 2020-08-24 20:59
 */
public interface SysLogininforMapper {

    /**
     * 查询所有Log
     */
    List<SysLogininfor> findAllLoginLog() throws Exception;

    /**
     * 根据id查询log
     */
    SysLogininfor findLoginLogById(String id)  throws Exception;

    /**
     * 插入一条log日志
     */
    int insertLoginLog(SysLogininfor sysLogininfor)  throws Exception;

    /**
     * 根据logid查询log
     */
    int deleteLoginLog(String id) throws Exception;

    /**
     * 清空所有日志
     * @return 返回影响行数
     */
    int cleanLoginLog() throws Exception;

    /**
     *  批量删除系统操作日志
     * @param ids 需要删除的操作日志ID
     */
    int deleteLoginLogByIds(String[] ids);

}

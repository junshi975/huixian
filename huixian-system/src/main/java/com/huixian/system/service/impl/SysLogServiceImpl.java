package com.huixian.system.service.impl;

import com.huixian.common.domain.SysLog;
import com.huixian.system.mapper.SysLogMapper;
import com.huixian.system.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-08-24 21:56
 */
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {


    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public List<SysLog> findAllLog() throws Exception {
        return sysLogMapper.findAllLog();
    }

    @Override
    public SysLog findLogById(String id) throws Exception {
        return sysLogMapper.findLogById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveSysLog(SysLog sysLog) throws Exception {
        int row = sysLogMapper.insertLog(sysLog);
        return row == 1;
    }

    @Override
    public boolean deleteSysLog(String id) throws Exception {
        int row = sysLogMapper.deleteLog(id);
        return row == 1;
    }
}

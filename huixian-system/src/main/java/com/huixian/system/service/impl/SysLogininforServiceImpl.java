package com.huixian.system.service.impl;

import com.huixian.common.entiry.SysLogininfor;
import com.huixian.system.mapper.SysLogininforMapper;
import com.huixian.system.service.SysLogininforService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 登陆日志服务逻辑实现
 * @author JUNSHI 405773808@qq.com
 * @create 2020-08-25 21:31
 */
@Service("sysLogininforService")
public class SysLogininforServiceImpl implements SysLogininforService {


    @Autowired
    private SysLogininforMapper sysLogininforMapper;

    @Override
    public List<SysLogininfor> findAllLoginLog() throws Exception {

        return sysLogininforMapper.findAllLoginLog();
    }

    @Override
    public SysLogininfor findLoginLogById(String id) throws Exception {

        return sysLogininforMapper.findLoginLogById(id);
    }

    @Override
    public boolean saveLoginLog(SysLogininfor sysLog) throws Exception {
        int row = sysLogininforMapper.insertLoginLog(sysLog);
        return row == 1;
    }

    @Override
    public boolean deleteLoginLog(String id) throws Exception {
        return sysLogininforMapper.deleteLoginLog(id) == 1;

    }

    @Override
    public boolean deleteLoginLogByIds(String[] ids) {
        return sysLogininforMapper.deleteLoginLogByIds(ids) != 0;
    }

    @Override
    public void cleanLoginLog() throws Exception {
        sysLogininforMapper.cleanLoginLog();
    }
}

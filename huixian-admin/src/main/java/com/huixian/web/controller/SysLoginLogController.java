package com.huixian.web.controller;

import com.huixian.common.domain.Result;
import com.huixian.common.entiry.SysLog;
import com.huixian.common.entiry.SysLogininfor;
import com.huixian.system.service.SysLogService;
import com.huixian.system.service.SysLogininforService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 登陆日志接口
 * @author JUSHI 405773808@qq.com
 * @create 2020-08-24 22:37
 */
@Api(tags = "登陆日志接口")
@RestController
public class SysLoginLogController {

    @Autowired
    private SysLogininforService sysLogininforService;

    @GetMapping("/loginlog")
    public Result getSysLog() throws Exception {
        List<SysLogininfor> log = sysLogininforService.findAllLoginLog();
        if (log != null) {
            return Result.success(log);
        }
        return Result.failure("无日志！");
    }

}

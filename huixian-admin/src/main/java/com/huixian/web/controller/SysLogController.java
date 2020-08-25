package com.huixian.web.controller;

import com.huixian.common.entiry.SysLog;
import com.huixian.common.domain.Result;
import com.huixian.common.utils.ServletUtils;
import com.huixian.common.utils.ip.IPUtils;
import com.huixian.system.service.SysLogService;
import eu.bitwalker.useragentutils.UserAgent;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 操作日志接口
 * @author JUSHI 405773808@qq.com
 * @create 2020-08-24 22:37
 */
@Api(tags = "操作日志接口")
@RestController
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @GetMapping("/syslog")
    public Result getSysLog() throws Exception {
        List<SysLog> log = sysLogService.findAllLog();
        if (log != null) {
            return Result.success(log);
        }
        return Result.failure("无日志！");
    }

}

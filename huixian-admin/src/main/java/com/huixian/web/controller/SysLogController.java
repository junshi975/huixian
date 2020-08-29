package com.huixian.web.controller;

import com.huixian.common.entiry.SysLog;
import com.huixian.common.domain.Result;
import com.huixian.common.utils.page.PageUtils;
import com.huixian.system.service.SysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页的条目数", required = true, dataType = "Integer")

    })
    public Result getLoginLog(Integer pageNum, Integer pageSize) throws Exception {
        PageUtils.startPage(pageNum,pageSize);

        List<SysLog> log = sysLogService.findAllLog();
        if (log != null) {
            return Result.success(PageUtils.getPageInfo(log, PageUtils.NAVIGATEPAGES));
        }
        return Result.failure("无日志！");
    }

}

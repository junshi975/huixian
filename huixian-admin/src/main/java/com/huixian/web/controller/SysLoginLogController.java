package com.huixian.web.controller;

import com.github.pagehelper.PageInfo;
import com.huixian.common.domain.Result;
import com.huixian.common.entiry.SysLog;
import com.huixian.common.entiry.SysLogininfor;
import com.huixian.common.utils.page.PageUtils;
import com.huixian.system.service.SysLogService;
import com.huixian.system.service.SysLogininforService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页的条目数", required = true, dataType = "Integer")

    })
    public Result getLoginLog(Integer pageNum, Integer pageSize) throws Exception {

        PageUtils.startPage(pageNum,pageSize);
        List<SysLogininfor> log = sysLogininforService.findAllLoginLog();
        if (log != null) {
            return Result.success(PageUtils.getPageInfo(log, PageUtils.NAVIGATEPAGES));
        }
        return Result.failure("无日志！");
    }

}

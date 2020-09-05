package com.huixian.web.controller;

import com.huixian.center.listener.SysLogReadListener;
import com.huixian.common.entiry.SysLog;
import com.huixian.common.domain.Result;
import com.huixian.common.utils.file.ExcelUtils;
import com.huixian.common.utils.page.PageUtils;
import com.huixian.system.service.SysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    private SysLogReadListener sysLogReadListener;

    @GetMapping("/syslog")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "页的条目数", required = true, dataType = "Integer")

    })
    public Result getLoginLog(Integer pageNum, Integer pageSize) throws Exception {
        PageUtils.startPage(pageNum, pageSize);

        List<SysLog> log = sysLogService.findAllLog();
        if (log != null) {
            return Result.success(PageUtils.getPageInfo(log, PageUtils.NAVIGATEPAGES));
        }
        return Result.failure("无日志！");
    }

    @GetMapping("/export")
    @ApiOperation("导出操作日志")
    public void export() {
        try {
            String fileName = System.currentTimeMillis() + "操作日志.xlsx";
            ExcelUtils.webWrite(sysLogService.findAllLog(), fileName, SysLog.class, "操作日志");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ApiOperation("导入操作日志")
    @PostMapping("/read")
    public Result read(MultipartFile file) {
        ExcelUtils.webRead(file, SysLog.class, sysLogReadListener);
        return Result.success();
    }

    @ApiOperation("清空日志")
    @DeleteMapping("/clear")
    public Result<SysLog> clear() {
        try {
            sysLogService.cleanSysLog();
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure();
        }

    }
}

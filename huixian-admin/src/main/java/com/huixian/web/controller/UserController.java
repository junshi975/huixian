package com.huixian.web.controller;

import com.huixian.common.domain.Result;
import com.huixian.common.domain.ResultCode;
import com.huixian.common.domain.UserInfo;
import com.huixian.system.service.UserInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户操作接口
 * @author JUNSHI 405773808@qq.com
 * @create 2020-08-01 17:02
 */
@Api(tags = "用户操作接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation("登陆")
    @GetMapping("/login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuId", value = "学生学号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")

    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "登陆成功"),
            @ApiResponse(code = 2003, message = "用户不存在或密码错误")

    })
    public Result login(String password,String stuId) {

        if (userInfoService.login(stuId,password)) {
            return Result.success("登陆成功");

        } else {
            return new Result(ResultCode.USER_LOGIN_ERROR);
        }

    }


}

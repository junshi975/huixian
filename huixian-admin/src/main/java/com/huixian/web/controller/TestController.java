package com.huixian.web.controller;

import com.huixian.common.pojo.Result;
import com.huixian.common.pojo.ResultCode;
import com.huixian.system.service.UserInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

import static com.huixian.common.pojo.Result.success;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-24 19:25
 */
@Api(tags = "用户信息管理")
@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation("获取用户列表")
    @GetMapping("/get")
    public Result<UserEntity> get() throws SQLException {
        UserEntity entity = new UserEntity(1, "测试", "密码", "123123");
        return new Result<>(ResultCode.SUCCESS, entity);
    }

    @ApiOperation("获取用户详细")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "integer", paramType = "path")
    @DeleteMapping("/{userId}")
    public Result getAgs(@PathVariable Integer userId) {
        return success();
    }

    @ApiOperation("获取用户")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "integer", paramType = "path")
    @PutMapping("/user")
    public Result<UserEntity> getUser(@PathVariable Integer userId) {
        return Result.success(new UserEntity(1, "测试", "密码", "123123"));
    }

    @ApiOperation("失败")
    @PostMapping("/fail")
    public Result fail(UserEntity userEntity) {
        System.out.println(userEntity);
        return Result.failure();
    }
    @ApiOperation("成功")
    @GetMapping("/suceess")
    public Result success() {
        return new Result(ResultCode.PARAM_TYPE_ERROR);
    }

}

@ApiModel("用户表JSON字段")
class UserEntity {
    @ApiModelProperty(value = "用户ID",required = true,example = "12345")
    private Integer userId;

    @ApiModelProperty(value = "用户名称",required = true)
    private String username;

    @ApiModelProperty(value = "用户密码",required = true)
    private String password;

    @ApiModelProperty(value = "用户手机",required = true)
    private String mobile;

    public UserEntity() {

    }

    public UserEntity(Integer userId, String username, String password, String mobile) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
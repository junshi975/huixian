package com.huixian.web.controller;

import com.huixian.center.manager.LoginLogHandler;
import com.huixian.common.annotation.Log;
import com.huixian.common.constant.Constants;
import com.huixian.common.domain.Result;
import com.huixian.common.entiry.SysLogininfor;
import com.huixian.common.entiry.UserInfo;
import com.huixian.common.enums.BusinessType;
import com.huixian.common.exception.FileException;
import com.huixian.system.service.UserInfoService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * 用户操作接口
 * @author JUNSHI 405773808@qq.com
 * @create 2020-08-01 17:02
 */
@Api(tags = "用户操作接口")
@RestController
//@CrossOrigin
public class UserController {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private LoginLogHandler loginLogHandler;


    @Log(title = "用户模块", businessType = BusinessType.UPDATE)
    @ApiOperation("修改用户信息")
    @PutMapping("/user")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuId", value = "学号", dataType = "String", paramType = "stuId", required = true),
            @ApiImplicitParam(name = "nickname", value = "会员名称", dataType = "String", paramType = "nickname", required = true),
            @ApiImplicitParam(name = "phone", value = "手机号", dataType = "String", paramType = "phone", required = true),
            @ApiImplicitParam(name = "grade", value = "所在班级", dataType = "String", paramType = "grade", required = true)

    })
    public Result updateUserInfo(@ApiIgnore UserInfo userInfo) throws Exception {
        boolean update = userInfoService.updateUserInfoByStuId(userInfo);
        if (update) {
            return Result.success("修改成功！");

        }
        return Result.failure("修改失败！");
    }

    /**
     * 根据学号查询用户详细信息
     * @param stuId 学号
     * @return 成功200，失败100
     */
    @Log(title = "用户模块", businessType = BusinessType.OTHER)
    @ApiOperation("根据学号查询用户详细信息")
    @GetMapping("/user/{stuId}")
    @ApiImplicitParam(name = "stuId", value = "学号", dataType = "String", paramType = "stuId", required = true)
    public Result userInfo(@PathVariable("stuId") String stuId) throws Exception {
        UserInfo userInfo = userInfoService.findUserInfoByStuId(stuId);
        if (userInfo != null) {
            return Result.success(userInfo);
        }
        return Result.failure("找不到此用户");

    }


    /**
     * 修改用户头像
     * @param image 头像
     * @param stuId 学号
     * @return 成功200，失败100
     * @throws FileException 文件异常
     */
    @Log(title = "用户模块", businessType = BusinessType.UPDATE)
    @ApiOperation("根据学号修改头像")
    @PostMapping("/upload")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "image", value = "头像", dataType = "file", paramType = "image", required = true),
            @ApiImplicitParam(name = "stuId", value = "学号", dataType = "String", paramType = "stuId", required = true)
    })
    public Result upload(MultipartFile image, String stuId) throws FileException {

        boolean update = userInfoService.updateAvatar(image, stuId);
        if (update) {
            return Result.success("头像上传成功!");
        } else {
            return Result.failure("头像上传失败");
        }
    }


    /**
     * 修改用户密码
     * @param stuId  学生学号
     * @param pwd    旧密码
     * @param newPwd 新密码
     * @return 成功200，失败100
     */
    @Log(title = "用户模块", businessType = BusinessType.UPDATE)
    @ApiOperation("修改用户密码")
    @PutMapping("/user/stuId/{stuId}/pwd/{pwd}/newPwd/{newPwd}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuId", value = "学生学号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "pwd", value = "旧密码", required = true, dataType = "String"),
            @ApiImplicitParam(name = "newPwd", value = "新密码", required = true, dataType = "String")

    })
    public Result updatePwd(@PathVariable String stuId, @PathVariable String pwd, @PathVariable String newPwd) {
        try {
            boolean update = userInfoService.updatePwd(stuId, pwd, newPwd);
            //如果返回true
            if (update) {
                return Result.success("密码修改成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.failure("旧密码错误！");
    }

    /**
     * 获取所有用户信息
     * @return 所有用户信息
     */
    @Log(title = "用户模块", businessType = BusinessType.OTHER)
    @ApiOperation("返回所有用户信息")
    @GetMapping("/users")
    public Result getAll() {
        List<UserInfo> users = null;
        try {
            users = userInfoService.findAllUsers();
            //users.clear(); 测试失败
            //当users不为空，那么返回数据
            if (users != null || !users.isEmpty()) {
                return Result.success(users);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(e.getMessage());
        }
        return Result.failure();
    }

    /**
     * 登陆功能
     * @param password 密码
     * @param stuId    学号
     */
    @Log(title = "用户模块", businessType = BusinessType.OTHER)
    @ApiOperation("登陆")
    @PostMapping(value = "/login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuId", value = "学生学号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")

    })
    public Result login(String password, String stuId) {
        try {
            boolean login = userInfoService.login(stuId, password);
            if (login) {
                loginLogHandler.recording(stuId, Constants.LOGIN_SUCCESS, "登陆成功");
                return Result.success("登陆成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(e.getMessage());
        }
        loginLogHandler.recording(stuId, Constants.LOGIN_FAIL, "登陆失败");
        return Result.failure("用户账号或密码错误！");

    }


}

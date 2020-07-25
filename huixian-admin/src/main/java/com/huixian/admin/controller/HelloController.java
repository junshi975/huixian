package com.huixian.admin.controller;

import com.huixian.common.pojo.Result;
import com.huixian.common.pojo.UserInfo;
import com.huixian.system.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-24 19:25
 */
@RestController
public class HelloController {



    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/get")
    public Result get() throws SQLException {
        List<UserInfo> allUsers = userInfoService.findAllUsers();
        return Result.success(allUsers);
    }
}

package com.huixian.system.mapper;


import com.huixian.common.domain.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-25 14:15
 */
public interface UserInfoMapper {


    /**
     * 查询所有的用户
     * @return
     */
    List<UserInfo> findAllUsers() throws Exception;

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    UserInfo findUserById(String id) throws Exception;

    /**
     * 添加用户
     * @param userInfo
     */
    void addUser(UserInfo userInfo) throws Exception;


    /**
     * 根据id修改用户信息
     */
    void updateUserById(UserInfo userInfo) throws Exception;

    /**
     * 根据学号修改用户信息
     */
    void updatePassword(@Param("stuId") String stuId, @Param("pwd") String pwd) throws Exception;


    /**
     * 根据id删除用户
     * @param id
     */
    void deleteUserById(String id) throws Exception;

    /**
     * 查询用户个数
     * @return
     */
    Integer findUserCount() throws Exception;

    /**
     * 根据学号和密码查询用户
     */
    UserInfo findUserByStuIdAndPassWord(@Param("stuId") String stuId, @Param("password") String password) throws Exception;

}

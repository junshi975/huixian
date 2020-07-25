package com.huixian.system.mapper;


import com.huixian.common.pojo.UserInfo;
import org.apache.ibatis.annotations.Select;

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
    @Select("select * from user_info")
    List<UserInfo> findAllUsers();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    UserInfo findUserById(String id);

}

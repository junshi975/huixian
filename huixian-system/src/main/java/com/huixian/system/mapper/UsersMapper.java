package com.huixian.system.mapper;

import com.huixian.common.pojo.Users;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-25 14:15
 */
public interface UsersMapper {


    /**
     * 查询所有的用户
     * @return
     */
    @Select("select * from users")
    List<Users> findAllUsers();

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    Users findUserById(String id);

}

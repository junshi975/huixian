package com.huixian.system.service;

import com.huixian.common.entiry.UserInfo;
import com.huixian.common.exception.FileException;
import org.apache.catalina.User;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-24 20:59
 */
public interface UserInfoService {

    /**
     * 查询所有用户信息
     * @return
     * @throws Exception
     */
    List<UserInfo> findAllUsers() throws Exception;


    /**
     * 根据学号查询用户信息
     * @param stuId 学号
     * @return 成功返回用户信息，失败返回null
     */
    UserInfo findUserInfoByStuId(String stuId) throws Exception;


    /**
     * 修改账号密码
     * @param stuId  学号
     * @param pwd    旧密码
     * @param newPwd 新密码
     * @return 返回true表示修改成功，返回false表示修改失败
     */
    boolean updatePwd(String stuId, String pwd, String newPwd) throws Exception;


    /**
     * 上传头像
     * @param image 头像
     * @return 成功返回图片名称，失败返回null
     */
    String upload(MultipartFile image) throws FileException ;

    /**
     * 修改用户头像
     * @param image 用户id
     * @param stuId 学号
     * @return 成功返回true，失败返回false
     * @throws FileException
     */
    boolean updateAvatar(MultipartFile image,String stuId) throws FileException;

    /**
     * 根据学号Id修改用户信息
     * @param userInfo 用户信息
     * @return 成功返回true，失败返回false
     * @throws Exception
     */
    boolean updateUserInfoByStuId(UserInfo userInfo) throws Exception;
}

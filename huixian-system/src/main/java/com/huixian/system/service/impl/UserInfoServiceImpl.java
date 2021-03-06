package com.huixian.system.service.impl;

import com.huixian.common.config.HuiXianConfig;
import com.huixian.common.entiry.UserInfo;
import com.huixian.common.enums.ResultCode;
import com.huixian.common.exception.FileException;
import com.huixian.common.utils.file.FileUploadUtils;
import com.huixian.system.mapper.UserInfoMapper;
import com.huixian.system.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-24 20:59
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> findAllUsers() throws Exception {
        return userInfoMapper.findAllUsers();
    }

    @Override
    public UserInfo findUserInfoByStuId(String stuId) throws Exception {
        return userInfoMapper.findUserByStuId(stuId);
    }



    @Override
    public boolean updatePwd(String stuId, String pwd, String newPwd) throws Exception {
        //根据账号密码查询用户
        UserInfo user = userInfoMapper.findUserByStuIdAndPassWord(stuId, pwd);
        //如果不为空，那么原密码正确
        if (user != null) {
            //开始修改
            userInfoMapper.updatePassword(stuId, newPwd);
            //修改成功后返回true
            return true;
        }
        return false;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public String upload(MultipartFile image) throws FileException {
        //获取照片存储基路径
        String filePath = HuiXianConfig.getPhoto();

        //上传照片，并且获取照片名称
        String fileName = FileUploadUtils.fileUpload(image, filePath);

        //当fileName不为null时表示照片存在
        if (fileName != null) {
            //上传成功后拼接完整路径
            filePath += fileName;

            // 获取照片访问基路径
            String srcPath = HuiXianConfig.getAvatar() + fileName;

            int row = userInfoMapper.upload(fileName, filePath, srcPath);
            if (row == 1) {
                return fileName;
            }

        }

        return null;

    }

    @Override
    public boolean updateAvatar(MultipartFile image, String stuId) throws FileException {
        String fileName = upload(image);
        if (fileName != null) {
            //根据文件名称查询fileId
            Integer fileId = userInfoMapper.findFileIdByFileName(fileName);
            //修改头像
            int rowSize = userInfoMapper.updateAvatar(fileId, stuId);
            if (rowSize == 1) {
                //当影响条目数为1的时候，头像修改成功
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean updateUserInfoByStuId(UserInfo userInfo) throws Exception {
        int rowSize = userInfoMapper.updateUserByStuId(userInfo);
        //如果影响条目数等于1说明修改成功
        if (rowSize == 1) {
            return true;
        }
        return false;
    }
}

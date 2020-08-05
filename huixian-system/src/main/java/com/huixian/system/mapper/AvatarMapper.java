package com.huixian.system.mapper;

import com.huixian.common.domain.Avatar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 头像操作Mapper
 * @author JUNSHI 405773808@qq.com
 * @create 2020-08-03 20:48
 */
public interface AvatarMapper {

    /**
     * 查询所有头像信息
     * @return 返回所有头像信息
     */
    List<Avatar> findAllAvatar();

    /**
     * 根据头像id查询头像
     * @param fileId 头像id
     * @return 头像信息
     */
    Avatar findAvatarById(Integer fileId);

    /**
     * 上传头像
     */
    void addAvatar(@Param("fileName") String fileName, @Param("filePath") String filePath, @Param("srcPath") String srcPath);
}

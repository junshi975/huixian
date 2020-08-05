package com.huixian.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 头像实体类
 * @author JUNSHI 405773808@qq.com
 * @create 2020-08-03 19:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Avatar {
    /** 头像id*/
    private Integer fileId;
    /** 头像名称*/
    private String fileName;
    /** 头像路径*/
    private String filePath;
    /** 访问路径*/
    private String srcPath;
}

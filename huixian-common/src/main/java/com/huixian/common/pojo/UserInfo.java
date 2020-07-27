package com.huixian.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Users表实体类
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-25 14:15
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 219948L;

    /** id无意义 */
    private String id;
    /** 昵称 */
    private String nickname;
    /** 密码 */
    private String password;
    /** 姓名 */
    private String name;
    /** 学号 */
    private String stuId;
    /** 性别 0男  1女 */
    private Integer gender;
    /** 手机号 */
    private String phone;
    /** 班级 */
    private String grade;
    /** 头像 */
    private String photo = "static/img/default.jpg";
    /** 状态 */
    private Integer status;

}

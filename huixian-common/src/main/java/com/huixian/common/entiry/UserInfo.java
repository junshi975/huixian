package com.huixian.common.entiry;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Users表
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-25 14:15
 */
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 219948L;


    /**
     * id无意义
     */
    private String id;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 学号
     */
    private String stuId;
    /**
     * 性别 0男  1女
     */
    private Integer gender;
    private String genderStr;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 班级
     */
    private String grade;
    /**
     * 头像Id,默认为1
     */
    private Integer fileId = 1;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 格式化后的状态
     */
    private String statusStr;

    /**
     * 头像
     */
    private Avatar avatar;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }


    public String getGenderStr() {if (gender != null) {
            switch (gender) {
                case 1:
                    return genderStr = "女";
                default:
                    return genderStr = "男";
            }
        }
        return genderStr;
    }

    public void setGenderStr(String genderStr) {
        this.genderStr = genderStr;
    }

    public String getStatusStr() {

        if (status != null) {
            switch (status) {
                case 0:
                    return statusStr = "不可用";
                default:
                    return statusStr = "正常使用";
            }
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {

        this.statusStr = statusStr;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public Integer getGender() {
        return gender;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }



    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", stuId='" + stuId + '\'' +
                ", gender=" + gender +
                ", genderStr='" + genderStr + '\'' +
                ", phone='" + phone + '\'' +
                ", grade='" + grade + '\'' +
                ", fileId='" + fileId + '\'' +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                ", avatar=" + avatar +
                '}';
    }
}

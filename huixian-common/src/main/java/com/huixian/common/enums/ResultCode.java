package com.huixian.common.enums;


/**
 * 统一返回结果状态码枚举
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-17 19:37
 */
public enum ResultCode {

    /**
     * 成功状态码
     */
    SUCCESS(200, "处理成功！"),
    /**
     * 失败状态码
     */
    ERROR(100, "处理失败！"),
    /* 参数错误 1000-1999 */
    /**
     * 参数无效
     */
    PARAM_IS_INVALID(1001, "参数无效！"),
    /**
     * 参数为空
     */
    PARAM_IS_NULL(1002, "参数为空！"),
    /**
     * 参数类型错误！
     */
    PARAM_TYPE_ERROR(1003, "参数类型错误！"),
    /**
     * 部分参数缺失
     */
    PARAM_IS_MISS(1004, "参数缺失！"),

    /* 用户错误 2000-2999 */
    /**
     * 用户不存在
     */
    USER_NOT_EXIST(2001, "用户不存在！"),
    /**
     * 用户已存在
     */
    USER_HAS_EXIST(2002, "用户已存在！"),
    /**
     * 用户不存在或密码错误
     */
    USER_LOGIN_ERROR(2003, "用户不存在或密码错误！"),
    /**
     * 用户未登陆，请验证后再访问
     */
    USER_NOT_LOGIN(2004, "用户未登陆，请验证后再访问！"),
    /**
     * 账号已经被禁用
     */
    USER_ACCOUNT_DISABLE(2005, "账号已经被禁用！");


    /**
     * 状态码
     */
    private final Integer code;
    private final String message;

    private ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

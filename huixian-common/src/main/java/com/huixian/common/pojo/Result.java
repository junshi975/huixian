package com.huixian.common.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 统一返回结果类
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-17 20:08
 */
@ApiModel(value = "统一返回结果")
public class Result<T> implements Serializable {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 229948L;

    /**
     * 状态码
     */
    @ApiModelProperty("状态码")
    private Integer code;
    /**
     * 提示信息
     */
    @ApiModelProperty("提示信息")
    private String message;

    /**
     * 返回数据
     */
    @ApiModelProperty("返回的数据")
    private T data;



    /**
     * 私有构造器，防止创建
     */
    private Result() {
    }

    /**
     * 设置状态码，与返回信息
     */
    public Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    /**
     * 设置状态码，与返回信息还有返回值
     */
    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    /**
     * 处理成功无返回值情况
     * @return 返回接口
     */
    public static <T> Result<T> success() {
        return new Result(ResultCode.SUCCESS);
    }

    /**
     * 处理成功有返回值
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(ResultCode.SUCCESS, data);
    }

    /**
     * 处理失败
     * @param <T>
     * @return
     */
    public static <T> Result<T> failure() {
        return new Result<>(ResultCode.ERROR);
    }

    /**
     * 通用：返回处理失败，带有返回值
     * @return 返回处理失败的结果
     */
    public static <T> Result<T> failure(T data) {
        return new Result<>(ResultCode.ERROR, data);
    }



    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "{" +
                "'code:'" + code +
                ", 'message:'" + message + '\'' +
                ", 'data:'" + data +
                '}';
    }
}

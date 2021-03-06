package com.huixian.common.entiry;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.huixian.common.core.text.convert.SysLogConverter;
import com.huixian.common.utils.DateUtils;

import java.util.Date;

/**
 * 系统日志表
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-02 22:35
 */
public class SysLog {

    /**
     * 编号
     */
    @ExcelProperty("ID")
    private String id;

    /**
     * 操作模块
     */
    @ExcelProperty("操作模块")
    private String title;

    /**
     * 访问方法
     */
    @ExcelProperty("访问方法")
    private String method;

    /**
     * 请求方式
     */
    @ExcelProperty("请求方式")
    private String requestType;


    /**
     * 操作用户
     */
    @ExcelProperty("操作用户")
    private String username;


    /**
     * 请求的url
     */
    @ExcelProperty("访问地址")
    private String url;

    /**
     * 主机IP
     */
    @ExcelProperty("主机IP")
    private String ip;

    /**
     * 执行时长
     */
    @ExcelProperty("执行时长")
    private Long useTime;

    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     */
    @ExcelProperty(value = "业务类型",converter = SysLogConverter.class)
    private Integer businessType;

    /**
     * 返回参数
     */
    @ExcelProperty("返回参数")
    private String returnArgs;

    /**
     * 操作时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    @ExcelProperty("操作时间")
    private Date operatingTime;

    public SysLog() {
    }

    public SysLog(String id, Date operatingTime, Long useTime, String username, String ip, String url, String method, String requestType, String title, Integer businessType, String returnArgs) {
        this.id = id;
        this.operatingTime = operatingTime;
        this.useTime = useTime;
        this.username = username;
        this.ip = ip;
        this.url = url;
        this.method = method;
        this.requestType = requestType;
        this.title = title;
        this.businessType = businessType;
        this.returnArgs = returnArgs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getOperatingTime() {
        return operatingTime;
    }

    public void setOperatingTime(Date operatingTime) {
        this.operatingTime = operatingTime;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReturnArgs() {
        return returnArgs;
    }

    public void setReturnArgs(String returnArgs) {
        this.returnArgs = returnArgs;
    }

    public Long getUseTime() {
        return useTime;
    }

    public void setUseTime(Long useTime) {
        this.useTime = useTime;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "id='" + id + '\'' +
                ", operatingTime=" + operatingTime +
                ", useTime=" + useTime +
                ", username='" + username + '\'' +
                ", ip='" + ip + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", requestType='" + requestType + '\'' +
                ", title='" + title + '\'' +
                ", businessType=" + businessType +
                ", returnArgs='" + returnArgs + '\'' +
                '}';
    }
}

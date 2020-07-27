package com.huixian.common.exception;

/**
 * 文件异常
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-27 21:50
 */
public class FileException extends BaseException{

    public FileException(String module, String code, Object[] args, String defaultMessage) {
        super(module, code, args, defaultMessage);
    }

    public FileException(String module, String code, Object[] args) {
        super(module, code, args);
    }

    public FileException(String module, String defaultMessage) {
        super(module, defaultMessage);
    }

    public FileException(String code, Object[] args) {
        super(code, args);
    }

    public FileException(String defaultMessage) {
        super(defaultMessage);
    }
}

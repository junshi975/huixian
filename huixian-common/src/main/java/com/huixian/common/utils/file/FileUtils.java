package com.huixian.common.utils.file;

import com.huixian.common.utils.uuid.IdUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 文件操作工具类
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-27 15:51
 */
public class FileUtils {

    public static String FILENAME_PATTERN = "[a-zA-Z0-9_\\-\\|\\.\\u4e00-\\u9fa5]+";

    /**
     * （数字）文件名无后缀小数点结尾:
     * 例:123213.
     */
    public static String FILENAME_MATH_HAVE_POINT = System.currentTimeMillis() + ".";

    /**
     * （UUID）文件名无后缀小数点结尾：
     */
    public static String FILENAME_UUID_HAVE_POINT = IdUtils.simpleUUID() + ".";


    /**
     * （纯数字）文件名:
     * 例:123213.
     */
    public static String FILENAME_MATH = System.currentTimeMillis() + "";

    /**
     * （UUID）文件名：
     */
    public static String FILENAME_UUID = IdUtils.simpleUUID();

    /**
     * 文件大小
     */
    public static final Long FILE_SIZE_10M = 10000000L;
    /**
     * 文件大小
     */
    public static final Long FILE_SIZE_0M = 0L;

    /**
     * 文件名称验证
     * @param filename 文件名称
     * @return true 正常 false 非法
     */
    public static boolean isValidFilename(String filename) {
        return filename.matches(FILENAME_PATTERN);
    }


    /**
     * 下载文件名重新编码
     * @param request  请求对象
     * @param fileName 文件名
     * @return 编码后的文件名
     */
    public static String setFileDownloadHeader(HttpServletRequest request, String fileName) throws UnsupportedEncodingException {
        final String agent = request.getHeader("USER-AGENT");
        String filename = fileName;
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            filename = new String(fileName.getBytes(), "ISO8859-1");
        } else if (agent.contains("Chrome")) {
            // google浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }


    /**
     * 删除文件
     * @param filePath 文件路径
     * @return 如果删除成功返回true，删除失败返回false
     */
    public static boolean deleteFile(String filePath) {
        //判断文件是否删除
        boolean isFlag = false;
        File file = new File(filePath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            isFlag = true;
        }
        return isFlag;
    }

    /**
     * 判断文件是否存在
     * @param filePath 文件路径
     * @return 如果存在返回true，不存在返回false
     */
    public static boolean fileExists(String filePath) {

        File file = new File(filePath);
        //如果存在返回true
        if (file.isFile() && file.exists()) {
            return true;
        }
        return false;
    }

}

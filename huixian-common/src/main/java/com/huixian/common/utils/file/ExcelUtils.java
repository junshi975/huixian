package com.huixian.common.utils.file;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.fastjson.JSON;
import com.huixian.common.entiry.SysLog;
import com.huixian.common.utils.ServletUtils;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.List;

/**
 * Excel操作Utils
 * @author JUNSHI 405773808@qq.com
 * @create 2020-08-29 19:35
 */
public class ExcelUtils {

    /**
     * log记录器
     */
    private static Logger LOGGER = LoggerFactory.getLogger(EasyExcel.class);


    /**
     * Excel表格写出
     * @param data      写出的数据
     * @param fileName  写出的Excel文件名
     * @param o         实体类
     * @param sheetName 工作表名
     */
    public static <T> void simpleWrite(List<T> data, String fileName, Class<T> o, String sheetName) {
        try {
            //创建工作簿对象
            ExcelWriterBuilder writerBuilder = EasyExcel.write(fileName, o);
            //创建工作表对象
            ExcelWriterSheetBuilder sheet = writerBuilder.sheet(sheetName);
            //写出
            sheet.doWrite(data);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Excel写出错误：{}", JSON.toJSONString(e.getMessage()));
        }
    }

    /**
     * Excel表格写出 下载
     * @param data      写出的数据
     * @param fileName  写出的Excel文件名
     * @param o         实体类
     * @param sheetName 工作表名
     */
    public static <T> void webWrite(List<T> data, String fileName, Class<T> o, String sheetName) {
        try {
            // 防止中文乱码
            String formatFileName = FileUtils.setFileDownloadHeader(ServletUtils.getRequest(), fileName);
            ServletUtils.getResponse().setContentType("application/force-download");
            ServletUtils.getResponse().addHeader("Content-Disposition", "attachment;fileName=" + formatFileName);
            //写出
            ExcelWriterBuilder write = EasyExcel.write(ServletUtils.getResponse().getOutputStream(), o);
            write.sheet(sheetName).doWrite(data);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("Excel写出错误：{}", JSON.toJSONString(e.getMessage()));
        }
    }

    /**
     * web
     * @param file     上传的文件
     * @param tClass   Excel对应实体类
     * @param listener 监听器
     * @param <T>      泛型
     */
    public static <T> void webRead(MultipartFile file, Class<T> tClass, ReadListener<T> listener) {
        try {
            ExcelReaderBuilder read = EasyExcel.read(file.getInputStream(), tClass, listener);
            //doRead
            read.sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("Excel读出错误：{}", JSON.toJSONString(e.getMessage()));
        }
    }

}

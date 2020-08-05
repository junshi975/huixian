package com.huixian.common.utils.file;

import com.huixian.common.config.HuiXianConfig;
import com.huixian.common.exception.FileException;
import com.huixian.common.utils.StringUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 文件上传工具
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-27 16:05
 */
public class FileUploadUtils {


    /**
     * 文件下载
     * @param storagePath 存储路径（例：/opt/data/）
     * @param fileName 文件名称
     * @return 下载成功返回true，失败返回false
     * @throws FileException
     * @throws UnsupportedEncodingException
     */
    public static boolean download(String storagePath, String fileName, HttpServletResponse response, HttpServletRequest request) throws FileException, UnsupportedEncodingException {

        //如果文件不存在
        if (!FileUtils.fileExists(storagePath + fileName)) {
            //结束方法
            throw new FileException("文件不存在！");
        }

        //编码化后的文件名
        String formatFileName = FileUtils.setFileDownloadHeader(request, fileName);

        BufferedOutputStream bfs = null;
        BufferedInputStream bis = null;

        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" + formatFileName);


        try {
            //获取缓冲文件输出流
            bfs = new BufferedOutputStream(response.getOutputStream());

            byte[] buff = new byte[1024];
            int len;

            bis = new BufferedInputStream(new FileInputStream(new File(HuiXianConfig.getPhoto() + fileName)));

            //存入
            while ((len = bis.read(buff)) != -1) {
                bfs.write(buff, 0, len);
            }
            //刷新
            bfs.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bfs != null) {
                try {
                    bfs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return false;

    }

    /**
     * 文件下载（默认下载springboot配置下的）
     * @param fileName 文件名
     * @return 下载成功返回true，失败返回false
     * @throws Exception
     */
    public static boolean download(String fileName, HttpServletResponse response, HttpServletRequest request) throws FileException, UnsupportedEncodingException {

        //如果文件不存在
        if (!FileUtils.fileExists(HuiXianConfig.getProfile() + fileName)) {
            //结束方法
            throw new FileException("文件不存在！");
        }

        //编码化后的文件名
        String formatFileName = FileUtils.setFileDownloadHeader(request, fileName);

        BufferedOutputStream bfs = null;
        BufferedInputStream bis = null;

        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" + formatFileName);


        try {
            //获取缓冲文件输出流
            bfs = new BufferedOutputStream(response.getOutputStream());

            byte[] buff = new byte[1024];
            int len;

            bis = new BufferedInputStream(new FileInputStream(new File(HuiXianConfig.getPhoto() + fileName)));

            //存入
            while ((len = bis.read(buff)) != -1) {
                bfs.write(buff, 0, len);
            }
            //刷新
            bfs.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bfs != null) {
                try {
                    bfs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return false;

    }


    /**
     * 文件上传工具
     * @param fileResources 上传过来的文件资源
     * @param filePath      文件路径
     * @return 上传成功返回文件名，上传失败返回null
     * @throws FileException 文件异常类
     */
    public static String fileUpload(MultipartFile fileResources, String filePath) throws FileException {

        if (!fileResources.isEmpty()) {

            if (fileResources.getSize() == FileUtils.FILE_SIZE_0M) {
                throw new FileException("上传失败：文件为空");
            }
            if (fileResources.getSize() > FileUtils.FILE_SIZE_10M) {
                throw new FileException("上传失败：文件大小不能超过10M");
            }

            //创建File对象，一会向该路径下上传文件
            File file = new File(filePath);

            // 判断路径是否存在，如果不存在，创建该路径
            if (!file.exists()) {
                file.mkdir();
            }
            String originalFilename = fileResources.getOriginalFilename();

            // 设置文件名：数字加后缀
            String filename = FileUtils.FILENAME_MATH_HAVE_POINT + FileUploadUtils.getExtension(fileResources);

            // 完成文件上传
            try {
                fileResources.transferTo(new File(file, filename));
            } catch (IOException e) {
                throw new FileException("文件:" + fileResources.getOriginalFilename() + "上传失败,错误信息:" + e);
            }

            //返回文件路径:如果上传成功。
            String serverPath = filePath + filename;
            if (serverPath != null) {
                return filename;
            }
        }

        return null;
    }

    /**
     * 文件上传工具(文件路径)
     * @return 上传成功返回文件名，上传失败返回null
     */
    public static String fileUpload(MultipartFile fileResources) throws FileException {
        String path = fileUpload(fileResources, HuiXianConfig.getProfile());
        if (path != null) {
            return path;
        }
        return null;
    }

    /**
     * 获取文件名的后缀
     * @param file 表单文件
     * @return 后缀名
     */
    public static final String getExtension(MultipartFile file) {

        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        if (StringUtils.isEmpty(extension)) {
            extension = MimeTypeUtils.getExtension(file.getContentType());
        }
        return extension;
    }
}

package com.huixian.common.utils.file;

import com.huixian.common.config.HuiXianConfig;
import com.huixian.common.utils.DateUtils;
import com.huixian.common.utils.uuid.IdUtils;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Excel工具类
 * @author JUNSHI 405773808@qq.com
 * @create 2020-08-12 12:33
 */
public class PoiExcelUtils {

    /**
     * Excel sheet最大行数，默认65536
     */
    public static final int sheetSize = 65536;
    /**
     * 默认地址
     */
    public static final String PATH = HuiXianConfig.getProfile();

    /**
     * 工作表名称
     */
    private String sheetName;

    ///**
    // * 导出类型（EXPORT:导出数据；IMPORT：导入模板）
    // */
    //private Type type;

    /**
     * 工作薄对象
     */
    private Workbook wb;

    /**
     * 工作表对象
     */
    private Sheet sheet;

    /**
     * 样式列表
     */
    private Map<String, CellStyle> styles;

    /**
     * 导入导出数据列表
     */
    private List<T> list;

    /**
     * 注解列表
     */
    private List<Object[]> fields;

    /**
     * 实体对象
     */
    public Class<T> clazz;

    /**
     * 写出07的excel表格
     */
    public static void write07(List<T> list) {
        //创建工作簿
        Workbook workbook = new XSSFWorkbook();

        //创建一个工作表
        Sheet sheet = workbook.createSheet();

        for (int rowNum = 0; rowNum < sheetSize; rowNum++) {
            // 创建一行
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                //4.创建一个单元格 (1,1)
                Cell cell = row.createCell(cellNum);
                for (T t : list) {
                    cell.setCellValue(t.toString());
                }
            }
        }

        //生成一张表：（IO）  07版本：xlsx
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(PATH + IdUtils.simpleUUID() + ".xlsx");
            workbook.write(fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}

package com.huixian.common.core.text.convert;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.huixian.common.core.text.Convert;

/**
 * 日志类型转换器
 * @author JUNSHI 405773808@qq.com
 * @create 2020-08-29 22:05
 */
public class SysLogConverter implements Converter<Integer> {
    @Override
    public Class supportJavaTypeKey() {
        return null;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return null;
    }

    @Override
    public Integer convertToJavaData(CellData cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return null;
    }

    @Override
    public CellData convertToExcelData(Integer value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        switch (value) {
            case 1:
                return new CellData("新增");
            case 2:
                return new CellData("修改");
            case 3:
                return new CellData("删除");
            default:
                return new CellData("其它");
        }
    }
}

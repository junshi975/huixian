package com.huixian.common.utils.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huixian.common.entiry.SysLogininfor;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * 分页工具类
 * @author JUNSHI 405773808@qq.com
 * @create 2020-08-26 12:46
 */
public class PageUtils {

    /**
     * 分页导航数
     */
    public static final Integer NAVIGATEPAGES = 5;

    /**
     * @param pageNum       页数
     * @param pageSize      当前页的条目数
     */
    public static void startPage(Integer pageNum, Integer pageSize) {

        //开启分页
        PageHelper.startPage(pageNum, pageSize);
    }

    /**
     *
     * @param list 结果集
     * @param navigatePages 导航条目数
     * @return 返回分页对象
     */
    public static PageInfo getPageInfo(List list,Integer navigatePages){
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数(总共每个页面设置5个分页）
        return new PageInfo(list, navigatePages);
    }

}

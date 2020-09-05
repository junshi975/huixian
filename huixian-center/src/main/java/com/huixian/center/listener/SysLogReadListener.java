package com.huixian.center.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.huixian.common.entiry.SysLog;
import com.huixian.system.service.SysLogService;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 日志读入监听器
 * @author JUNSHI 405773808@qq.com
 * @create 2020-08-30 18:51
 */
@Component
@Scope("prototype")
public class SysLogReadListener extends AnalysisEventListener<SysLog> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysLogReadListener.class);
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;

    @Autowired
    private SysLogService sysLogService;

    List<SysLog> list = new ArrayList<>();

    /**
     * 每读一样会自动调用这个方法
     * @param data    读取的内容自动封装成了一个对象
     * @param context
     */
    @Override
    public void invoke(SysLog data, AnalysisContext context) {
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            for (SysLog sysLog : list){
                System.out.println(sysLog);
            }
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        try {
            LOGGER.info("{}条数据，开始存储数据库！", list.size());
            //sysLogService.saveLogs(list);
            LOGGER.info("存储数据库成功！");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("存储失败：{}", e.getMessage());
        }
    }

}

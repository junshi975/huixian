package com.huixian.web;



import com.huixian.common.utils.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.Date;

@SpringBootTest
public class HuiXianAdminApplicationTests {



    @Test
    void contextLoads() throws SQLException {
        Date date = new Date();
        String str = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, date);
        System.out.println(str);
    }

}

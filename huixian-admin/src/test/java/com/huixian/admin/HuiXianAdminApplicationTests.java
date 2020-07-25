package com.huixian.admin;



import com.huixian.common.utils.DateUtils;
import com.huixian.common.utils.spring.SpringUtils;
import com.huixian.common.utils.uuid.IdUtils;
import com.huixian.system.mapper.UserInfoMapper;
import com.huixian.system.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
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

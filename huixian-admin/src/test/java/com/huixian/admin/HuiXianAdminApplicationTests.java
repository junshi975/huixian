package com.huixian.admin;



import com.huixian.admin.HuiXianAdminApplication;
import com.huixian.system.mapper.UsersMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
public class HuiXianAdminApplicationTests {


    @Autowired
    private DataSource dataSource;

    @Autowired
    private UsersMapper usersMapper;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(usersMapper.findAllUsers());
        System.out.println(usersMapper.findUserById("F7F6D2AECE3211EAB12A00163E0E371C"));

    }

}

package com.huixian.admin.controller;

import com.huixian.common.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-24 19:25
 */
@RestController
public class HelloController {


    @Autowired
    DataSource dataSource;

    @GetMapping("/hello")
    public Person hello() throws SQLException {
        System.out.println(dataSource.getConnection());
        Person person = new Person(1);
        return person;
    }
}

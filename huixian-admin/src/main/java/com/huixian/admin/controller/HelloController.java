package com.huixian.admin.controller;

import com.huixian.common.pojo.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-24 19:25
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Person hello(){
        Person person = new Person(1);
        return person;
    }
}

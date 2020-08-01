package com.huixian.common.domain;


import javax.validation.constraints.NotNull;

/**
 * @author JUNSHI 405773808@qq.com
 * @create 2020-07-24 19:29
 */
public class Person {


    @NotNull
    private Integer id;

    public Person() {
    }

    public Person(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

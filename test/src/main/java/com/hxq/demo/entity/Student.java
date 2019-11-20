package com.hxq.demo.entity;

import com.hxq.demo.service.Person;

/**
 * @ClassName Student
 * @Description
 * @Author hongxq
 * @Date 2019/11/14 16:37
 * @Version 1.0
 **/
public class Student implements Person {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        System.out.println(name+"上交了班费50元");
    }
}

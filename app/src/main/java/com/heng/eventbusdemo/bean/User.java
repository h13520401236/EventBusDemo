package com.heng.eventbusdemo.bean;

/**
 * Created by hengweiyu on 2018/6/13.
 */

public class User {

    public int age;

    public String name;

    public User(int age,String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

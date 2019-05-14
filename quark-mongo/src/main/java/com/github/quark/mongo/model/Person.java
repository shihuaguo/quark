package com.github.quark.mongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author shihuaguo
 * @email huaguoshi@gmail.com
 * @date 2019-05-14
 **/
@Document
public class Person {

    private String id;
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}

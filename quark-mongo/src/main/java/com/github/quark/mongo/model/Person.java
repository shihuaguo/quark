package com.github.quark.mongo.model;

import com.github.quark.common.core.validator.AddGroup;
import com.github.quark.common.core.validator.UpdateGroup;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author shihuaguo
 * @email huaguoshi@gmail.com
 * @date 2019-05-14
 **/
@Document
public class Person {

    private String id;

    @Indexed(unique = true)
    @NotBlank(groups = {AddGroup.class, UpdateGroup.class}, message = "name不能为空")
    private String name;

    @NotNull(groups = {AddGroup.class, UpdateGroup.class}, message = "age")
    private int age;

    public Person() {
    }

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

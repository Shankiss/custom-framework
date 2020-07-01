package com.zyuc.demo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Version 1.0
 * @Description TODO
 * @Date 2020/5/9 9:59
 * @Created by ChenHao
 */
@Configuration
@ConfigurationProperties(prefix = "com.zyuc")
@PropertySource(value = "classpath:resource.properties")
public class User {

    private String name;

    private String date;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

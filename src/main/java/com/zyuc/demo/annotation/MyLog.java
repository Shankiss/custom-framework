package com.zyuc.demo.annotation;

import java.lang.annotation.*;

/**
 * @Version 1.0
 * @Description 自定义log注解
 * @Date 2020/5/14 14:20
 * @Created by ChenHao
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {

    String description() default "";
}

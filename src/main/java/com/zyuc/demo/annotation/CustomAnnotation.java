package com.zyuc.demo.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Version 1.0
 * @Description 自定义注解
 * @Date 2020/5/14 10:49
 * @Created by ChenHao
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface CustomAnnotation {


    /**
     * 业务代码
     * @return
     */
    String businessCode() default "业务代码";

    /**
     * 代理实现接口
     * @return
     */
    Class<?> clazz();

}

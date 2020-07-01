package com.zyuc.demo.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Version 1.0
 * @Description TODO
 * @Date 2020/5/7 15:23
 * @Created by ChenHao
 */
@Component
@Aspect
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //根据具体的执行类方法找到切点
//    @Pointcut("execution(public * com.zyuc.demo.controller.CoreRoleController.*(..))")
//    public void log() {
//    }

    //根据自定义注解找到切点
    @Pointcut("@annotation(com.zyuc.demo.annotation.MyLog)")
    public void log() {
    }

    @Before("log()")
    public void before(JoinPoint joinPoint) {
        doBefore(joinPoint);
    }

    @AfterReturning(returning = "response", pointcut = "log()")
    public void afterReturning(JoinPoint joinPoint, Object response) {
        doAfterReturning(joinPoint, response);
    }

    private void doBefore(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String url = request.getRequestURL().toString();
        Class targetClass = joinPoint.getTarget().getClass();
        Method[] methods = targetClass.getMethods();
        if (methods.length == 0) {
            return;
        }
        String targetName = targetClass.getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("{}.{} URL {} BEGIN >>>>>>>>>>> \n           INPUT PARAMS >>>>>>>>>>> {}", targetName, methodName, url, Arrays.toString(args));
    }

    private void doAfterReturning(JoinPoint joinPoint, Object response) {
        Class targetClass = joinPoint.getTarget().getClass();
        String targetName = targetClass.getName();
        String methodName = joinPoint.getSignature().getName();

        try {
            logger.info("{}.{} END >>>>>>>>>>> \n           OUTPUT PARAMS >>>>>>>>>>> {}", targetName, methodName, JSON.toJSONString(response));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("打印出参报错", e);
        }
    }
}

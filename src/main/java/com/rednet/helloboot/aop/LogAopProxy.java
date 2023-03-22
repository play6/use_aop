package com.rednet.helloboot.aop;

import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAopProxy {

    private final static Logger LOGGER = LoggerFactory.getLogger(LogAopProxy.class);

    /**
     * 定义切点
     */
    @Pointcut("@annotation(com.rednet.helloboot.annotatio.LogAnno)")
    public void pointCut() {
    }

    /**
     * 定义增强方式
     */
    @Around("pointCut()")
    public Object doEnhance(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Gson gson = new Gson();
        LOGGER.info("req param-> {}", gson.toJson(proceedingJoinPoint.getArgs()));
        Object proceed = proceedingJoinPoint.proceed();
        LOGGER.info("response-> {}", gson.toJson(proceed));
        return proceed;
    }

}

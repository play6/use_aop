package com.rednet.helloboot.annotatio;

import java.lang.annotation.*;

/**
 * 自定义注解实现日志切面
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface LogAnno {

    String desc() default "";

}

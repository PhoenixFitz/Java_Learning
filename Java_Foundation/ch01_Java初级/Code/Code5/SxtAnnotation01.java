package com.bjsxt.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SxtAnnotation01 {
//定义注解元素
    String studentName() default "";
    int age() default 0;
    int id() default -1;
    String[] schools() default  {};
}

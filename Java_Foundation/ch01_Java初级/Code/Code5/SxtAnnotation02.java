package com.bjsxt.test.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SxtAnnotation02 {

    String value(); //只有一个属性时 参数名一般定义成value()
}

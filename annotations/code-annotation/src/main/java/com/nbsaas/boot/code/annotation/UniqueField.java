package com.nbsaas.boot.code.annotation;


import java.lang.annotation.*;


/**
 * 字段唯一注解
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueField {

    String message() default "";

    String key();

}

package com.nbsaas.boot.code.annotation;


import java.lang.annotation.*;

/**
 * 需要lbs搜索
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LbsClass {
}

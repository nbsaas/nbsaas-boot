package com.nbsaas.boot.rest.annotations;


import java.lang.annotation.*;


/**
 * 通过aop自动注入用户基础信息
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface UpdateData {
}

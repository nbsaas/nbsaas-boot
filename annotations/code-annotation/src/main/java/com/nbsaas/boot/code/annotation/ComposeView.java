package com.nbsaas.boot.code.annotation;


import java.lang.annotation.*;


/**
 * 视图层是多模块
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ComposeView {
}

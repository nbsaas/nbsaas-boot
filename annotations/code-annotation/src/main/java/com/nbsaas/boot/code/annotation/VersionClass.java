package com.nbsaas.boot.code.annotation;


import java.lang.annotation.*;

/**
 * 实体需要进行版本控制
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface VersionClass {
}

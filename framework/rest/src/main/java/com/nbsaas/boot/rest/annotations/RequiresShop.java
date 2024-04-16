package com.nbsaas.boot.rest.annotations;


import java.lang.annotation.*;

/**
 * 租户注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RequiresShop {
}

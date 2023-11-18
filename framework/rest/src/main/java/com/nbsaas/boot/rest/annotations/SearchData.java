package com.nbsaas.boot.rest.annotations;

import java.lang.annotation.*;

/**
 * 搜索注解
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SearchData {
}

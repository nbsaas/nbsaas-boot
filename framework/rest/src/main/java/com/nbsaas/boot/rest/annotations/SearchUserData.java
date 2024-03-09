package com.nbsaas.boot.rest.annotations;

import java.lang.annotation.*;

/**
 * 用户搜索注解，可以通过aop实现只能获取当前用户数据
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface SearchUserData {
}

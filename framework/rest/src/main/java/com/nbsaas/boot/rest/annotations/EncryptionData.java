package com.nbsaas.boot.rest.annotations;


import java.lang.annotation.*;

/**
 * 加密注解，用于请求参数加密，相应数据加密
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface EncryptionData {
}

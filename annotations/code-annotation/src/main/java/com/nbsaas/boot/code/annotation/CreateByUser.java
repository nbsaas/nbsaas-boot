package com.nbsaas.boot.code.annotation;

import java.lang.annotation.*;

/**
 * 生成代码的时候时候添加创建人
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CreateByUser {
}

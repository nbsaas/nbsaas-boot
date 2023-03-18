package com.nbsaas.boot.code.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldConvert {

    String classType() default "Long";

    String dao() default "";

}

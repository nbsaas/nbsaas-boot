package com.nbsaas.boot.code.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldName {

    String name() default "";

    String parent() default "";

    String classType() default "String";

}

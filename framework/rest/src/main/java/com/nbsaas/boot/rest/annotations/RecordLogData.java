package com.nbsaas.boot.rest.annotations;


import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RecordLogData {

    String title() default "";

    String app() default "";

}

package com.nbsaas.boot.code.annotation;


import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FormAnnotation {

    String title() default "";

    String model() default "";

    String menu() default "";

    String searchWidth() default "80";

    String viewWidth() default "80";

}

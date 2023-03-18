package com.nbsaas.boot.code.annotation;


import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SearchItem {

    /**
     * 标题
     * @return
     */
    String label() ;

    /**
     * name
     *
     * @return
     */
    String name() ;

    String key() default "";

    InputType type() default InputType.text;

    String sortNum() default "0";

    String placeholder() default "";

    String classType() default "String";

    String operator() default "like";

    boolean show() default  true;


}

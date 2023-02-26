package com.nbsaas.boot.rest.filter;

import java.lang.annotation.*;

/**
 * @author ada
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OrderBy {

    String value() default "";

    SortType sort() default SortType.desc;

}

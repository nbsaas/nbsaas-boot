package com.nbsaas.boot.rest.filter;

import java.lang.annotation.*;

/**
 * @author ada
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Search {
    Operator operator() default Operator.eq;

    String name() default "";

    String prefix() default "";

    Condition condition() default Condition.AND;
}

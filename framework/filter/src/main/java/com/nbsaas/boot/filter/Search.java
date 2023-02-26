package com.nbsaas.boot.filter;

import java.lang.annotation.*;

/**
 * 搜索条件
 *
 * @author ada
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Search {

    /**
     * 表达式操作符
     *
     * @return
     */
    Filter.Operator operator() default Filter.Operator.eq;

    /**
     * bean对象属性
     *
     * @return
     */
    String name() default "";

    /**
     * 表达式前缀
     */
    String prefix() default "";

    /**
     * 计算条件，且和或，默认为且
     */
    Condition condition() default Condition.AND;

}

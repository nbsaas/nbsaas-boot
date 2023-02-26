package com.nbsaas.boot.rest.filter;

import java.util.List;

/**
 * 基础过滤器
 */
public class Filter {

    public String field;

    public Object value;

    public Operator operator;


    /**
     * 条件
     */
    public String condition = "and";

    /**
     * 表达式前缀
     */
    public String prefix = "";

    public Filter(String field, Object value, Operator operator) {
        this.field = field;
        this.value = value;
        this.operator = operator;
    }

    public static Filter eq(String field, Object object) {
        return new Filter(field, object, Operator.eq);
    }

    public static Filter ne(String field, Object object) {
        return new Filter(field, object, Operator.ne);
    }

    public static Filter ge(String field, Object object) {
        return new Filter(field, object, Operator.ge);
    }

    public static Filter gt(String field, Object object) {
        return new Filter(field, object, Operator.gt);
    }

    public static Filter le(String field, Object object) {
        return new Filter(field, object, Operator.le);
    }

    public static Filter lt(String field, Object object) {
        return new Filter(field, object, Operator.lt);
    }

    public static Filter like(String field, String object) {
        return new Filter(field, object, Operator.like);
    }

    public static Filter in(String field, List<?> object) {
        return new Filter(field, object, Operator.in);
    }

    public static Filter isNull(String field) {
        return new Filter(field, null, Operator.isNull);
    }

    public static Filter isNotNull(String field) {
        return new Filter(field, null, Operator.isNotNull);
    }
}

/*
 *
 *  * 版权声明和许可协议
 *  *
 *  * 版权所有 (c) 2023 纽百特®
 *  * 版权所有，保留所有权利
 *  *
 *  * 本软件使用 MIT 许可协议进行许可，详情请参阅：
 *  *
 *  *   https://opensource.org/licenses/MIT
 *  *
 *  * 更多信息，请访问我们的网站：
 *  *
 *  *   http://www.nbsaas.com
 *  *
 *  * 纽百特® 是西安纽百特科技有限责任公司的注册商标，未经授权不得使用。
 *
 */

package com.nbsaas.boot.rest.filter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

    public static Filter in(String field, Number... number) {
        List<Number> numbers = new ArrayList<>();
        if (number != null) {
            numbers.addAll(Arrays.asList(number));
        }

        return new Filter(field, numbers, Operator.in);
    }

    public static Filter notIn(String field, List<?> object) {
        return new Filter(field, object, Operator.notIn);
    }

    public static Filter notIn(String field, Number... number) {
        List<Number> numbers = new ArrayList<>();
        if (number != null) {
            numbers.addAll(Arrays.asList(number));
        }
        return new Filter(field, numbers, Operator.notIn);
    }

    public static Filter isNull(String field) {
        return new Filter(field, null, Operator.isNull);
    }

    public static Filter isNotNull(String field) {
        return new Filter(field, null, Operator.isNotNull);
    }


    public static Filter between(String field, Number object, Number object2) {
        List<Number> numbers = new ArrayList<>();
        numbers.add(object);
        numbers.add(object2);
        return new Filter(field, numbers, Operator.between);
    }

    public static Filter between(String field, Date object, Date object2) {
        List<Date> numbers = new ArrayList<>();
        numbers.add(object);
        numbers.add(object2);
        return new Filter(field, numbers, Operator.between);
    }

}

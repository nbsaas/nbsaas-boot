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

package com.nbsaas.boot.code.annotation;


import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FormExtField {


    /**
     * 字段名称
     *
     * @return
     */
    String fieldName();


    /**
     * 父类字段名称
     *
     * @return
     */
    String parentField();

    /**
     * 当前类的父类字段名称
     *
     * @return
     */
    String parent();


    String title() default "";

    Class<?> fieldClass();


    /**
     * 是否在列表显示出来
     *
     * @return
     */
    boolean grid() default false;


    /**
     * 排序号
     *
     * @return
     */
    int sortNum() default 0;


    /**
     * 是否生成Simple对象
     *
     * @return
     */
    boolean simple() default true;

    /**
     * 是否生成Response对象
     *
     * @return
     */
    boolean response() default true;


    String width() default "100";

}

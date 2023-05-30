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
public @interface FormField {


    boolean ignore() default false;


    boolean grid() default false;

    String title() default "";

    String width() default "100";


    /**
     * 排序号
     *
     * @return
     */
    String sortNum() default "0";

    /**
     * 输入框类型
     *
     * @return
     */
    InputType type() default InputType.text;


    /**
     * 列表bootstrap栅格大小
     *
     * @return
     */
    int col() default 12;

    /**
     * css类名
     *
     * @return
     */
    String className() default "form-control";

    /**
     * 数据框id
     *
     * @return
     */
    String id() default "";

    /**
     * 输入框提示信息
     *
     * @return
     */
    String placeholder() default "";

    /**
     * 是否是搜索字段
     *
     * @return
     */
    boolean search() default false;

    /**
     * 是否必填
     *
     * @return
     */
    boolean required() default false;

    /**
     * 列表是否排序
     *
     * @return
     */
    boolean sort() default false;

    String option() default "";

}

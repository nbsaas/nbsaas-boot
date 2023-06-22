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

package com.nbsaas.boot.generator.beans;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class FieldBean implements Serializable, Comparable<FieldBean> {

    /**
     * 字段名称
     */
    private String title;

    /**
     * 字段描述
     */
    private String comment;

    /**
     * 字段标识
     */
    private String id;


    /**
     * 父类在当前类的名称
     */
    private String parent;

    /**
     * 父类字段
     */
    private String parentField;

    /**
     * java类型简称
     */
    private String className;

    /**
     * java类型全路径名称
     */
    private String javaType;

    private Boolean simpleType;

    /**
     * java简体类
     */
    private String type;

    /**
     * java类全名称
     */
    private String fullType;

    /**
     * 父类
     */
    private String parentType;


    /**
     * 父类全名
     */
    private String parentFullType;

    /**
     * 输入框提示语
     */
    private String placeholder;

    private Integer sortNum;


    private int col;

    private String width;


    private String key;

    private String operator;

    /**
     * 2父级类id 3父级类名称 4枚举 5其他
     */
    private Integer fieldType;

    private boolean required;

    private String option;

    private String extName;

    /**
     * api模型名称
     */
    private String api;


    private boolean sort;

    private boolean show = true;

    @Override
    public int compareTo(FieldBean o) {
        return this.getSortNum().compareTo(o.getSortNum());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FieldBean fieldBean = (FieldBean) o;

        return id.equals(fieldBean.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

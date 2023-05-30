package com.nbsaas.boot.generator.beans;

import lombok.Data;

import java.io.Serializable;


@Data
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

    private String parent;


    private String className;

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
     * 2父级类id 3父级类名称 4枚举
     */
    private Integer fieldType;

    private boolean required;

    private String option;

    private String extName;

    private boolean sort;

    private boolean show = true;

    @Override
    public int compareTo(FieldBean o) {
        return this.getSortNum().compareTo(o.getSortNum());
    }
}

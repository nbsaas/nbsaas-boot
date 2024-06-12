package com.nbsaas.boot.rest.request;


import lombok.Data;

import java.io.Serializable;

@Data
public class QueryFilter implements Serializable {


    private String javaName;

    /**
     * 字段类型字段类型 字段类型 1、字符串 2、Integer，3，Long，3 Float，4 Double，5，BigDecimal 6、Date 7、Boolean 8、Enum 9、对象 10、字符数组,11,整形数组，12小数数组
     */
    private Integer fieldType;

    /**
     * 字段名称,中文
     */
    private String fieldName;

    /**
     * 是否必填 1、是 2、否
     */
    private Integer required;

    /**
     * 显示区域 1,接口调用 2、主搜索 3、扩展搜索
     */
    private Integer area;
    /**
     * 输入类型 1、输入框 2、下拉框 3、日期 4、时间 5、日期时间 6、下拉树 7、多选框 8、单选框 9、图片 10、文件 11、富文本
     */
    private Integer inputType;

    /**
     * 查询地址
     */
    private String queryUrl;

}

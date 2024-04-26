package com.nbsaas.boot.rest.request;

import lombok.Data;


@Data
public class SqlObject {

    /**
     * sql 语句
     */
    private String sql;

    private Long page;

    private Long size;

    /**
     * 1 分页 2 列表 3 统计 4单对象 5单值 6执行sql
     */
    private Integer queryType;

    private Integer sortNum;

    /**
     * 1 设置变量 2 用于后续计算 3 无
     */
    private Integer resultType;

    /**
     * 变量名
     */
    private String varName;

}

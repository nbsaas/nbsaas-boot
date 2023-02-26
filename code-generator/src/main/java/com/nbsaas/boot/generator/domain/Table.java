package com.nbsaas.boot.generator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @version 1.0
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Table {

    /**
     * 数据库表名称
     */
    private String srcName;
    /**
     * 去拓峰名称
     */
    private String name;
    /**
     * 备注星系
     */
    private String comment;
    /**
     * 主键
     */
    private String keys;
}

package com.nbsaas.boot.jpa.data.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 分类基础类
 *
 * @author 年高
 */

@Data
@MappedSuperclass
public abstract class CatalogEntity implements   Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * 名称
     */
    private String name;


    /**
     * 排序号
     */
    private Integer sortNum;

    /**
     * 编码
     */
    @Column(length = 50)
    private String code;


    /**
     * ids
     */
    private String ids;

    /**
     * 左节点
     */
    private Integer lft;

    /**
     * 右节点
     */
    private Integer rgt;

    /**
     * 等级
     */
    private Integer levelInfo;


    /**
     * 添加时间
     */
    private Date addDate;

    /**
     * 最新修改时间
     */
    private Date lastDate;


}

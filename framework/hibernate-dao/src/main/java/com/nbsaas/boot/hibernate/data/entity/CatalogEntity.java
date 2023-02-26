package com.nbsaas.boot.hibernate.data.entity;


import com.nbsaas.boot.hibernate.data.hibernate.HibernateTree;
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
public abstract class CatalogEntity implements HibernateTree<Integer>, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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


    @Override
    public java.lang.Integer getLft() {
        return lft;
    }

    /**
     * @see HibernateTree#getLftName()
     */
    @Override
    public String getLftName() {
        return DEF_LEFT_NAME;
    }

    public java.lang.String getName() {
        return name;
    }


    /**
     * @see HibernateTree#getParentName()
     */
    @Override
    public String getParentName() {
        return DEF_PARENT_NAME;
    }

    @Override
    public java.lang.Integer getRgt() {
        return rgt;
    }

    /**
     * @see HibernateTree#getRgtName()
     */
    @Override
    public String getRgtName() {
        return DEF_RIGHT_NAME;
    }


    @Override
    public String getTreeCondition() {
        return null;
    }
}

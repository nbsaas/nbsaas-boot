package com.nbsaas.boot.hibernate.data.hibernate;

import java.io.Serializable;

/**
 * Hibernate实现父子结构tree，使用The Nested Set Model算法
 */
public interface HibernateTree<T extends Number> extends Serializable {
    /**
     * 默认树左边属性名称
     */
    String DEF_LEFT_NAME = "lft";
    /**
     * 默认树右边属性名称
     */
    String DEF_RIGHT_NAME = "rgt";
    /**
     * 默认父节点属性名称
     */
    String DEF_PARENT_NAME = "parent";
    /**
     * 实体类别名
     */
    String ENTITY_ALIAS = "bean";

    /**
     * 获得树左边属性名称
     *
     * @return
     */
    String getLftName();

    /**
     * 获得树右边属性名称
     *
     * @return
     */
    String getRgtName();

    /**
     * 获得父节点属性名称
     *
     * @return
     */
    String getParentName();

    /**
     * 获得树左边值
     *
     * @return
     */
    T getLft();

    /**
     * 设置树左边值
     *
     * @param lft
     */
    void setLft(T lft);

    /**
     * 获得树右边值
     *
     * @return
     */
    T getRgt();

    /**
     * 设置数右边值
     *
     * @param rgt
     */
    void setRgt(T rgt);

    /**
     * 获得父节点ID
     *
     * @return 如果没有父节点，则返回null。
     */
    T getParentId();

    /**
     * 获得树ID
     *
     * @return
     */
    T getId();

    /**
     * 获得附加条件
     * <p>
     * 通过附加条件可以维护多棵树相互独立的树，附加条件使用hql语句，实体别名为bean。例如：bean.website.id=5
     *
     * @return 为null则不添加任何附加条件
     * @see HibernateTree#ENTITY_ALIAS
     */
    String getTreeCondition();
}

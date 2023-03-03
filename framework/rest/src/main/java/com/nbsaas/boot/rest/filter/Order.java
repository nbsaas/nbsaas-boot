/*
 *
 *
 *
 */

package com.nbsaas.boot.rest.filter;

import java.io.Serializable;

/**
 * 排序
 */

public class Order implements Serializable {


    private SortType sortType;

    private String property;

    public Order(String property, SortType sortType) {
        this.property = property;
        this.sortType = sortType;
    }

    /**
     * 返回递增排序
     *
     * @param property 属性
     * @return 递增排序
     */
    public static Order asc(String property) {
        return new Order(property, SortType.asc);
    }

    /**
     * 返回递减排序
     *
     * @param property 属性
     * @return 递减排序
     */
    public static Order desc(String property) {
        return new Order(property, SortType.desc);
    }

    public SortType getSortType() {
        return sortType;
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
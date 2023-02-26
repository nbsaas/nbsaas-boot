/*
 *
 *
 *
 */

package com.nbsaas.boot.filter;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 分页信息
 */
public class Pageable implements Serializable {

    private static final long serialVersionUID = -3930180379790344299L;

    /**
     * 默认页码
     */
    private static final int DEFAULT_PAGE_NUMBER = 1;

    /**
     * 默认每页记录数
     */
    private static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 最大每页记录数
     */
    private static final int MAX_PAGE_SIZE = 200;

    /**
     * 页码
     */
    private int pageNumber = DEFAULT_PAGE_NUMBER;

    /**
     * 每页记录数
     */
    private int pageSize = DEFAULT_PAGE_SIZE;

    /**
     * 搜索属性
     */
    private String searchProperty;

    /**
     * 搜索值
     */
    private String searchValue;

    /**
     * 搜索别名
     */
    private String searchAliasProperty;

    /**
     * 搜索别名值
     */
    private Object searchAliasValue;

    /**
     * 排序属性
     */
    private String orderProperty;

    /**
     * 排序方向
     */
    private Order.Direction orderDirection;

    /**
     * 筛选
     */
    private List<Filter> filters = new ArrayList<Filter>();

    /**
     * 排序
     */
    private List<Order> orders = new ArrayList<Order>();
    private boolean cache = false;

    public boolean isCache() {
        return cache;
    }

    public void setCache(boolean cache) {
        this.cache = cache;
    }

    /**
     * 初始化一个新创建的Pageable对象
     */
    public Pageable() {
    }

    /**
     * 初始化一个新创建的Pageable对象
     *
     * @param pageNumber 页码
     * @param pageSize   每页记录数
     */
    public Pageable(Integer pageNumber, Integer pageSize) {
        if (pageNumber != null && pageNumber >= 1) {
            this.pageNumber = pageNumber;
        }
        if (pageSize != null && pageSize >= 1 && pageSize <= MAX_PAGE_SIZE) {
            this.pageSize = pageSize;
        }
    }

    /**
     * 获取页码
     *
     * @return 页码
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * 获取页码
     *
     * @return 页码
     */
    public int getPageNo() {
        return pageNumber;
    }

    /**
     * 设置页码
     *
     * @param pageNumber 页码
     */
    public void setPageNumber(int pageNumber) {
        if (pageNumber < 1) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }
        this.pageNumber = pageNumber;
    }

    public void setPageNo(int no) {
        if (no < 1) {
            no = DEFAULT_PAGE_NUMBER;
        }
        this.pageNumber = no;
    }

    /**
     * 获取每页记录数
     *
     * @return 每页记录数
     */
    public int getPageSize() {
        return pageSize;
    }


    /**
     * 设置每页记录数
     *
     * @param pageSize 每页记录数
     */
    public void setPageSize(int pageSize) {
        if (pageSize < 1 || pageSize > MAX_PAGE_SIZE) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        this.pageSize = pageSize;
    }

    /**
     * 获取搜索属性
     *
     * @return 搜索属性
     */
    public String getSearchProperty() {
        return searchProperty;
    }

    /**
     * 设置搜索属性
     *
     * @param searchProperty 搜索属性
     */
    public void setSearchProperty(String searchProperty) {
        this.searchProperty = searchProperty;
    }

    /**
     * 获取搜索值
     *
     * @return 搜索值
     */
    public String getSearchValue() {
        return searchValue;
    }

    /**
     * 设置搜索值
     *
     * @param searchValue 搜索别名属性
     */
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    /**
     * 获取别名属性
     */
    public String getSearchAliasProperty() {
        return searchAliasProperty;
    }

    /**
     * 设置别名属性
     *
     * @param searchAliasProperty 搜索别名值
     */
    public void setSearchAliasProperty(String searchAliasProperty) {
        this.searchAliasProperty = searchAliasProperty;
    }

    /**
     * 获取别名值
     * <p>
     * 搜索别名值
     */
    public Object getSearchAliasValue() {
        return searchAliasValue;
    }

    /**
     * 设置别名值
     *
     * @param searchAliasValue 搜索值
     */
    public void setSearchAliasValue(Object searchAliasValue) {
        this.searchAliasValue = searchAliasValue;
    }

    /**
     * 获取排序属性
     *
     * @return 排序属性
     */
    public String getOrderProperty() {
        return orderProperty;
    }

    /**
     * 设置排序属性
     *
     * @param orderProperty 排序属性
     */
    public void setOrderProperty(String orderProperty) {
        this.orderProperty = orderProperty;
    }

    /**
     * 获取排序方向
     *
     * @return 排序方向
     */
    public Order.Direction getOrderDirection() {
        return orderDirection;
    }

    /**
     * 设置排序方向
     *
     * @param orderDirection 排序方向
     */
    public void setOrderDirection(Order.Direction orderDirection) {
        this.orderDirection = orderDirection;
    }

    /**
     * 获取筛选
     *
     * @return 筛选
     */
    public List<Filter> getFilters() {
        return filters;
    }

    /**
     * 设置筛选
     *
     * @param filters 筛选
     */
    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    /**
     * 获取排序
     *
     * @return 排序
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * 设置排序
     *
     * @param orders 排序
     */
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


}
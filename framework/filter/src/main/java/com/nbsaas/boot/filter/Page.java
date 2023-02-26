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
 * 分页对象
 */
public class Page<T> implements Serializable {

    private static final long serialVersionUID = -2053800594583879853L;

    /**
     * 内容
     */
    private final List<T> content = new ArrayList<T>();

    /**
     * 总记录数
     */
    private final long total;

    /**
     * 分页信息
     */
    private final Pageable pageable;


    /**
     * 页面分页条分割大小
     */
    private int splitSize = 3;


    /**
     * 初始化一个新创建的Page对象
     */
    public Page() {
        this.total = 0L;
        this.pageable = new Pageable();
    }

    /**
     * @param content  内容
     * @param total    总记录数
     * @param pageable 分页信息
     */
    public Page(List<T> content, long total, Pageable pageable) {
        this.content.addAll(content);
        this.total = total;
        this.pageable = pageable;
    }

    /**
     * 获取页码
     *
     * @return 页码
     */
    public int getPageNumber() {
        return pageable.getPageNumber();
    }

    /**
     * 获取页码
     *
     * @return 页码
     */
    public int getNo() {
        return pageable.getPageNo();
    }

    /**
     * 获取每页记录数
     *
     * @return 每页记录数
     */
    public int getPageSize() {
        return pageable.getPageSize();
    }

    /**
     * 获取每页记录数
     *
     * @return 每页记录数
     */
    public int getSize() {
        return pageable.getPageSize();
    }


    /**
     * 获取搜索属性
     *
     * @return 搜索属性
     */
    public String getSearchProperty() {
        return pageable.getSearchProperty();
    }

    /**
     * 获取搜索值
     *
     * @return 搜索值
     */
    public String getSearchValue() {
        return pageable.getSearchValue();
    }

    /**
     * 获取排序属性
     *
     * @return 排序属性
     */
    public String getOrderProperty() {
        return pageable.getOrderProperty();
    }

    /**
     * 获取排序方向
     *
     * @return 排序方向
     */
    public Order.Direction getOrderDirection() {
        return pageable.getOrderDirection();
    }

    /**
     * 获取排序
     *
     * @return 排序
     */
    public List<Order> getOrders() {
        return pageable.getOrders();
    }

    /**
     * 获取筛选
     *
     * @return 筛选
     */
    public List<Filter> getFilters() {
        return pageable.getFilters();
    }

    /**
     * 获取总页数
     *
     * @return 总页数
     */
    public int getTotalPages() {
        return (int) Math.ceil((double) getTotal() / (double) getPageSize());
    }

    /**
     * 获取内容
     *
     * @return 内容
     */
    public List<T> getContent() {
        return content;
    }

    /**
     * 获取总记录数
     *
     * @return 总记录数
     */
    public long getTotal() {
        return total;
    }

    /**
     * 获取分页信息
     *
     * @return 分页信息
     */
    public Pageable getPageable() {
        return pageable;
    }


    /**
     * 第一条数据位置
     *
     * @return
     */
    public int getFirstNo() {
        int result = 1;
        result = getPageNumber() - splitSize;

        int t = getEndNo() - result;
        int num = splitSize * 2;
        if (t < num) {
            result = result - (num - t);
        }
        if (result <= 0) {
            result = 1;
        }
        return result;
    }


    /**
     * 第一条数据位置
     *
     * @return
     */
    public int getEndNo() {
        int result = 1;
        result = getPageNumber() + splitSize;

        if (getPageNumber() <= splitSize) {
            result = result + splitSize - getPageNumber();
            result++;
        } else {
        }


        if (result > getTotalPages()) {
            result = getTotalPages();
        }
        return result;
    }

}
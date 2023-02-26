package com.nbsaas.boot.hibernate.data.core;

import java.io.Serializable;

/**
 * 简单分页类
 */
public class SimplePage implements Paginable, Serializable {
    public static final int DEF_COUNT = 20;
    private static final long serialVersionUID = 1L;
    protected int totalCount = 0;
    protected int pageSize = 20;
    protected int pageNo = 1;

    public SimplePage() {
    }

    /**
     * 构造器
     *
     * @param pageNo     页码
     * @param pageSize   每页几条数据
     * @param totalCount 总共几条数据
     */
    public SimplePage(int pageNo, int pageSize, int totalCount) {
        setTotalCount(totalCount);
        setPageSize(pageSize);
        setPageNo(pageNo);
        adjustPageNo();
    }

    /**
     * 检查页码 checkPageNo
     *
     * @param pageNo
     * @return 页码
     */
    public static int cpn(Integer pageNo) {
        return (pageNo == null || pageNo < 1) ? 1 : pageNo;
    }

    /**
     * 调整页码，使不超过最大页数
     */
    public void adjustPageNo() {
        if (pageNo == 1) {
            return;
        }
        int tp = getTotalPage();
        if (pageNo > tp) {
            pageNo = tp;
        }
    }

    /**
     * 获得页码
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * 设置页码
     *
     * @param pageNo
     */
    public void setPageNo(int pageNo) {
        if (pageNo < 1) {
            this.pageNo = 1;
        } else {
            this.pageNo = pageNo;
        }
    }

    /**
     * 每页几条数据
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置分页大小
     *
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        if (pageSize < 1) {
            this.pageSize = DEF_COUNT;
        } else {
            this.pageSize = pageSize;
        }
    }

    /**
     * 总共几条数据
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 设置总量
     *
     * @param totalCount
     */
    public void setTotalCount(int totalCount) {
        if (totalCount < 0) {
            this.totalCount = 0;
        } else {
            this.totalCount = totalCount;
        }
    }

    /**
     * 总共几页
     */
    public int getTotalPage() {
        int totalPage = totalCount / pageSize;
        if (totalPage == 0 || totalCount % pageSize != 0) {
            totalPage++;
        }
        return totalPage;
    }

    /**
     * 是否第一页
     */
    public boolean isFirstPage() {
        return pageNo <= 1;
    }

    /**
     * 是否最后一页
     */
    public boolean isLastPage() {
        return pageNo >= getTotalPage();
    }

    /**
     * 下一页页码
     */
    public int getNextPage() {
        if (isLastPage()) {
            return pageNo;
        } else {
            return pageNo + 1;
        }
    }

    /**
     * 上一页页码
     */
    public int getPrePage() {
        if (isFirstPage()) {
            return pageNo;
        } else {
            return pageNo - 1;
        }
    }
}

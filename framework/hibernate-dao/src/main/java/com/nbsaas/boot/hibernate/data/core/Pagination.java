package com.nbsaas.boot.hibernate.data.core;

import java.util.List;

/**
 * 列表分页。包含list属性。
 */
@SuppressWarnings("serial")
public class Pagination<T> extends SimplePage implements java.io.Serializable,
        Paginable {

    int size = 2;
    /**
     * 当前页的数据
     */
    private List<T> list;

    public Pagination() {
    }

    /**
     * 构造器
     *
     * @param pageNo     页码
     * @param pageSize   每页几条数据
     * @param totalCount 总共几条数据
     */
    public Pagination(int pageNo, int pageSize, int totalCount) {
        super(pageNo, pageSize, totalCount);
    }

    /**
     * 构造器
     *
     * @param pageNo     页码
     * @param pageSize   每页几条数据
     * @param totalCount 总共几条数据
     * @param list       分页内容
     */
    public Pagination(int pageNo, int pageSize, int totalCount, List<T> list) {
        super(pageNo, pageSize, totalCount);
        this.list = list;
    }

    public static void main(String[] args) {

        Pagination p = new Pagination(9, 10, 100);


        System.out.println(p.getFirstNo());
        System.out.println(p.getEndNo());
        System.out.println(p.getPageNo());
        System.out.println(p.getNextPage());
        System.out.println(p.getPrePage());
        System.out.println(p.getTotalPage());


    }

    /**
     * 第一条数据位置
     *
     * @return
     */
    public int getFirstResult() {
        return (pageNo - 1) * pageSize;
    }

    /**
     * 第一条数据位置
     *
     * @return
     */
    public int getFirstNo() {
        int result = 1;
        result = pageNo - size;

        int t = getEndNo() - result;
        int num = size * 2;
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
        result = getPageNo() + size;

        if (getPageNo() <= size) {
            result = result + size - getPageNo();
            result++;
        } else {
        }


        if (result > getTotalPage()) {
            result = getTotalPage();
        }
        return result;
    }

    /**
     * 获得分页内容
     *
     * @return
     */
    public List<T> getList() {
        return list;
    }

    /**
     * 设置分页内容
     *
     * @param list
     */
    @SuppressWarnings("unchecked")
    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Pagination [totalCount=" + totalCount + ", pageSize="
                + pageSize + ", pageNo=" + pageNo + "]";
    }
}

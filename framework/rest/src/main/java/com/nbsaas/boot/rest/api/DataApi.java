package com.nbsaas.boot.rest.api;


import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.request.RequestId;

import java.util.Collection;
import java.util.List;


/**
 * @param <Response> Response 单个响应对象
 * @param <Simple>   Simple 列表对象
 * @param <Form>     Form  表单对象
 * @param <Request>  SearchRequest 搜索对象
 */
public interface DataApi<Response, Simple, Form extends RequestId, Request extends PageRequest> {

    /**
     * 单个对象查询
     *
     * @param filters
     * @return 单条数据信息
     */
    Response oneData(Filter... filters);

    /**
     * 集合对象查询
     *
     * @param filters
     * @return 数据集合
     */
    List<Simple> listData(Filter... filters);


    /**
     * 行数
     *
     * @param filters
     * @return 数据行数
     */
    Long countData(Filter... filters);


    /**
     * 搜索列表
     *
     * @param request
     * @return 搜索的数据集合
     */
    List<Simple> searchData(Request request);


    /**
     * 行数
     *
     * @param request
     * @return 数据行数
     */
    Long countData(Request request);

    /**
     * 根据id查询对象
     *
     * @param form
     * @return 数据对象
     */
    Response findById(Form form);


    /**
     * 添加对象
     *
     * @param form
     * @return 创建数据信息
     */
    Response createData(Form form);


    /**
     * 更新数据
     *
     * @param form
     * @return 更新信息
     */
    Response updateData(Form form);

    /**
     * 根本id批量删除
     *
     * @param idList
     * @return 删除数量
     */
    int deleteBatchIds(Collection<?> idList);

    /**
     * 根据Filter进行条件删除
     *
     * @param filter
     * @return 删除数量
     */
    int deleteByFilter(Filter... filter);

}

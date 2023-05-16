package com.nbsaas.boot.rest.api;
/*
 * 版权声明和许可协议
 *
 * 版权所有 (c) 2023 纽百特®
 * 版权所有，保留所有权利
 *
 * 本软件使用 MIT 许可协议进行许可，详情请参阅：
 *
 *   https://opensource.org/licenses/MIT
 *
 * 更多信息，请访问我们的网站：
 *
 *   http://www.nbsaas.com
 *
 * 纽百特® 是西安纽百特科技有限责任公司的注册商标，未经授权不得使用。
 */


import com.nbsaas.boot.rest.filter.Filter;
import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.request.RequestId;

import java.util.Collection;
import java.util.List;


/**
 * @param <Response> Response 单个响应对象
 * @param <Simple>   Simple 列表对象
 */
public interface DataApi<Response, Simple, Request extends RequestId> {

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
    List<Simple> searchData(PageRequest request);


    /**
     * 行数
     *
     * @param request
     * @return 数据行数
     */
    Long countData(PageRequest request);

    /**
     * 根据id查询对象
     *
     * @param form
     * @return 数据对象
     */
    Response findById(RequestId form);


    /**
     * 添加对象
     *
     * @param form
     * @return 创建数据信息
     */
    Response createData(Request form);


    /**
     * 更新数据
     *
     * @param form
     * @return 更新信息
     */
    Response updateData(Request form);

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

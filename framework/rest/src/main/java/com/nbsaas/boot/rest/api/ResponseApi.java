package com.nbsaas.boot.rest.api;


import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.request.RequestId;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;
import com.nbsaas.boot.rest.response.ResponseObject;

/**
 * 响应接口
 *
 * @param <Response> 详情对象
 * @param <Simple>   列表对象
 * @param <Request>     表单对象
 */
public interface ResponseApi<Response, Simple, Request extends RequestId> {

    /**
     * 分页查询
     *
     * @param request
     * @return 分页数据信息
     */
    PageResponse<Simple> search(PageRequest request);

    /**
     * 根据条件查询集合，不分页
     *
     * @param request
     * @return 数据集合数据
     */
    ListResponse<Simple> list(PageRequest request);

    /**
     * 创建
     *
     * @param request
     * @return 数据详情
     */
    ResponseObject<Response> create(Request request);

    /**
     * 更新
     *
     * @param request
     * @return 数据详情
     */
    ResponseObject<Response> update(RequestId request);

    /**
     * 删除
     *
     * @param request
     * @return 删除状态
     */
    ResponseObject<?> delete(RequestId request);

    /**
     * 根据ID查询详情
     *
     * @param request
     * @return 数据详情
     */
    ResponseObject<Response> view(RequestId request);

}

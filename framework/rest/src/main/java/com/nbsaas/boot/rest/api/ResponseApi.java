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
 * @param <Form>     表单对象
 * @param <Request>  搜索对象
 */
public interface ResponseApi<Response, Simple, Form extends RequestId, Request extends PageRequest> {

    /**
     * 分页查询
     *
     * @param request
     * @return 分页数据信息
     */
    PageResponse<Simple> search(Request request);

    /**
     * 根据条件查询集合，不分页
     *
     * @param request
     * @return 数据集合数据
     */
    ListResponse<Simple> list(Request request);

    /**
     * 创建
     *
     * @param request
     * @return 数据详情
     */
    ResponseObject<Response> create(Form request);

    /**
     * 更新
     *
     * @param request
     * @return 数据详情
     */
    ResponseObject<Response> update(Form request);

    /**
     * 删除
     *
     * @param request
     * @return 删除状态
     */
    ResponseObject<?> delete(Form request);

    /**
     * 根据ID查询详情
     *
     * @param request
     * @return 数据详情
     */
    ResponseObject<Response> view(Form request);

}

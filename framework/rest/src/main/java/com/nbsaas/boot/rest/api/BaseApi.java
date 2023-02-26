package com.nbsaas.boot.rest.api;


import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.request.RequestId;

/**
 * @param <Response> Response 单个响应对象
 * @param <Simple>   Simple 列表对象
 * @param <Form>     Form  表单对象
 * @param <Request>  SearchRequest 搜索对象
 */
public interface BaseApi<Response, Simple, Form extends RequestId, Request extends PageRequest> extends
        DataApi<Response, Simple, Form, Request>,
        ResponseApi<Response, Simple, Form, Request> {

}

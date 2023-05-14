package com.nbsaas.boot.rest.api;


import com.nbsaas.boot.rest.request.RequestId;

/**
 * @param <Response> Response 单个响应对象
 * @param <Simple>   Simple 列表对象
 */
public interface BaseApi<Response, Simple,Request extends RequestId> extends
        ExtApi,
        DataApi<Response, Simple,Request>,
        ResponseApi<Response, Simple,Request> {

}

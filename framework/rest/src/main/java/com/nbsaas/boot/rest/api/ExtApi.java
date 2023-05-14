package com.nbsaas.boot.rest.api;


import com.nbsaas.boot.rest.request.PageRequest;
import com.nbsaas.boot.rest.response.ListResponse;
import com.nbsaas.boot.rest.response.PageResponse;

import java.util.function.Function;

public interface ExtApi {

    /**
     * 扩展搜索，传递返回类
     *
     * @param request
     * @param domainClass
     * @param <Domain>
     * @return
     */
    <Domain> PageResponse<Domain> searchExt(PageRequest request, Class<Domain> domainClass);


    /**
     * 扩展搜索，传递转化接口
     *
     * @param request
     * @param function
     * @param <Domain>
     * @return
     */
    <Domain> PageResponse<Domain> searchExt(PageRequest request, Function<Object, Domain> function);


    /**
     * 列表搜索
     *
     * @param request
     * @param function
     * @param <Domain>
     * @return
     */
    <Domain> ListResponse<Domain> listExt(PageRequest request, Function<Object, Domain> function);


}

package com.nbsaas.boot.system.api.apis;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.system.api.domain.request.MenuDataRequest;
import com.nbsaas.boot.system.api.domain.request.MenuSearchRequest;
import com.nbsaas.boot.system.api.domain.response.MenuResponse;
import com.nbsaas.boot.system.api.domain.simple.MenuSimple;


/**
 * 对外接口
 */
public interface MenuApi extends BaseApi
        <MenuResponse, MenuSimple, MenuDataRequest, MenuSearchRequest> {


}

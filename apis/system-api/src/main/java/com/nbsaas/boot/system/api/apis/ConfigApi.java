package com.nbsaas.boot.system.api.apis;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.system.api.domain.request.ConfigDataRequest;
import com.nbsaas.boot.system.api.domain.request.ConfigSearchRequest;
import com.nbsaas.boot.system.api.domain.response.ConfigResponse;
import com.nbsaas.boot.system.api.domain.simple.ConfigSimple;


/**
 * 对外接口
 */
public interface ConfigApi extends BaseApi
        <ConfigResponse, ConfigSimple, ConfigDataRequest, ConfigSearchRequest> {


}

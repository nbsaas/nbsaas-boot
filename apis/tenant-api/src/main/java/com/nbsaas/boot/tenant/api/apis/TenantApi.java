package com.nbsaas.boot.tenant.api.apis;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.tenant.api.domain.request.TenantDataRequest;
import com.nbsaas.boot.tenant.api.domain.request.TenantSearchRequest;
import com.nbsaas.boot.tenant.api.domain.response.TenantResponse;
import com.nbsaas.boot.tenant.api.domain.simple.TenantSimple;


/**
 * 对外接口
 */
public interface TenantApi extends BaseApi
        <TenantResponse, TenantSimple, TenantDataRequest, TenantSearchRequest> {


}

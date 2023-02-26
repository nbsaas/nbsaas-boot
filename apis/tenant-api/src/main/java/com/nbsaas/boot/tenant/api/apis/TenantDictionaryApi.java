package com.nbsaas.boot.tenant.api.apis;

import com.nbsaas.boot.tenant.api.domain.request.TenantDictionarySearchRequest;
import com.nbsaas.boot.tenant.api.domain.request.TenantDictionaryDataRequest;
import com.nbsaas.boot.tenant.api.domain.simple.TenantDictionarySimple;
import com.nbsaas.boot.tenant.api.domain.response.TenantDictionaryResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface TenantDictionaryApi extends BaseApi
<TenantDictionaryResponse, TenantDictionarySimple, TenantDictionaryDataRequest, TenantDictionarySearchRequest> {


}

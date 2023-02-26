package com.nbsaas.boot.tenant.api.apis;

import com.nbsaas.boot.tenant.api.domain.request.TenantDictionaryItemSearchRequest;
import com.nbsaas.boot.tenant.api.domain.request.TenantDictionaryItemDataRequest;
import com.nbsaas.boot.tenant.api.domain.simple.TenantDictionaryItemSimple;
import com.nbsaas.boot.tenant.api.domain.response.TenantDictionaryItemResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface TenantDictionaryItemApi extends BaseApi
<TenantDictionaryItemResponse, TenantDictionaryItemSimple, TenantDictionaryItemDataRequest, TenantDictionaryItemSearchRequest> {


}

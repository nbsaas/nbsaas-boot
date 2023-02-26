package com.nbsaas.boot.tenant.api.apis;

import com.nbsaas.boot.tenant.api.domain.request.TenantCatalogSearchRequest;
import com.nbsaas.boot.tenant.api.domain.request.TenantCatalogDataRequest;
import com.nbsaas.boot.tenant.api.domain.simple.TenantCatalogSimple;
import com.nbsaas.boot.tenant.api.domain.response.TenantCatalogResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface TenantCatalogApi extends BaseApi
<TenantCatalogResponse, TenantCatalogSimple, TenantCatalogDataRequest, TenantCatalogSearchRequest> {


}

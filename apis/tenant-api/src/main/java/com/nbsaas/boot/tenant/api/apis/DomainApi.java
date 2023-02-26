package com.nbsaas.boot.tenant.api.apis;

import com.nbsaas.boot.tenant.api.domain.request.DomainSearchRequest;
import com.nbsaas.boot.tenant.api.domain.request.DomainDataRequest;
import com.nbsaas.boot.tenant.api.domain.simple.DomainSimple;
import com.nbsaas.boot.tenant.api.domain.response.DomainResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface DomainApi extends BaseApi
<DomainResponse, DomainSimple, DomainDataRequest, DomainSearchRequest> {


}

package com.nbsaas.boot.system.api.apis;

import com.nbsaas.boot.system.api.domain.request.MockSearchRequest;
import com.nbsaas.boot.system.api.domain.request.MockDataRequest;
import com.nbsaas.boot.system.api.domain.simple.MockSimple;
import com.nbsaas.boot.system.api.domain.response.MockResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface MockApi extends BaseApi
<MockResponse, MockSimple, MockDataRequest, MockSearchRequest> {


}

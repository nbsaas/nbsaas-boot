package com.nbsaas.boot.system.api.apis;

import com.nbsaas.boot.system.api.domain.request.ApplicationMenuSearchRequest;
import com.nbsaas.boot.system.api.domain.request.ApplicationMenuDataRequest;
import com.nbsaas.boot.system.api.domain.simple.ApplicationMenuSimple;
import com.nbsaas.boot.system.api.domain.response.ApplicationMenuResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface ApplicationMenuApi extends BaseApi
<ApplicationMenuResponse, ApplicationMenuSimple, ApplicationMenuDataRequest, ApplicationMenuSearchRequest> {


}

package com.nbsaas.boot.system.api.apis;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.system.api.domain.request.ApplicationDataRequest;
import com.nbsaas.boot.system.api.domain.request.ApplicationSearchRequest;
import com.nbsaas.boot.system.api.domain.response.ApplicationResponse;
import com.nbsaas.boot.system.api.domain.simple.ApplicationSimple;


/**
 * 对外接口
 */
public interface ApplicationApi extends BaseApi
        <ApplicationResponse, ApplicationSimple, ApplicationDataRequest, ApplicationSearchRequest> {


}

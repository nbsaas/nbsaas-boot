package com.nbsaas.boot.user.api.apis;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.user.api.domain.request.UserAccessLogDataRequest;
import com.nbsaas.boot.user.api.domain.request.UserAccessLogSearchRequest;
import com.nbsaas.boot.user.api.domain.response.UserAccessLogResponse;
import com.nbsaas.boot.user.api.domain.simple.UserAccessLogSimple;


/**
 * 对外接口
 */
public interface UserAccessLogApi extends BaseApi
        <UserAccessLogResponse, UserAccessLogSimple, UserAccessLogDataRequest, UserAccessLogSearchRequest> {


}

package com.nbsaas.boot.user.api.apis;

import com.nbsaas.boot.user.api.domain.request.UserLoginLogSearchRequest;
import com.nbsaas.boot.user.api.domain.request.UserLoginLogDataRequest;
import com.nbsaas.boot.user.api.domain.simple.UserLoginLogSimple;
import com.nbsaas.boot.user.api.domain.response.UserLoginLogResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface UserLoginLogApi extends BaseApi
<UserLoginLogResponse, UserLoginLogSimple, UserLoginLogDataRequest, UserLoginLogSearchRequest> {


}

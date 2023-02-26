package com.nbsaas.boot.user.api.apis;

import com.nbsaas.boot.user.api.domain.request.UserPasswordSearchRequest;
import com.nbsaas.boot.user.api.domain.request.UserPasswordDataRequest;
import com.nbsaas.boot.user.api.domain.simple.UserPasswordSimple;
import com.nbsaas.boot.user.api.domain.response.UserPasswordResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface UserPasswordApi extends BaseApi
<UserPasswordResponse, UserPasswordSimple, UserPasswordDataRequest, UserPasswordSearchRequest> {


}

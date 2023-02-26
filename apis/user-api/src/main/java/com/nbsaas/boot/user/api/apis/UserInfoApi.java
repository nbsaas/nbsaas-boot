package com.nbsaas.boot.user.api.apis;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.user.api.domain.request.UserInfoDataRequest;
import com.nbsaas.boot.user.api.domain.request.UserInfoSearchRequest;
import com.nbsaas.boot.user.api.domain.response.UserInfoResponse;
import com.nbsaas.boot.user.api.domain.simple.UserInfoSimple;


/**
 * 对外接口
 */
public interface UserInfoApi extends BaseApi
        <UserInfoResponse, UserInfoSimple, UserInfoDataRequest, UserInfoSearchRequest> {


}

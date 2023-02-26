package com.nbsaas.boot.user.api.apis;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.user.api.domain.request.UserAccountDataRequest;
import com.nbsaas.boot.user.api.domain.request.UserAccountSearchRequest;
import com.nbsaas.boot.user.api.domain.response.UserAccountResponse;
import com.nbsaas.boot.user.api.domain.simple.UserAccountSimple;


/**
 * 对外接口
 */
public interface UserAccountApi extends BaseApi
        <UserAccountResponse, UserAccountSimple, UserAccountDataRequest, UserAccountSearchRequest> {


}

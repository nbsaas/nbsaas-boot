package com.nbsaas.boot.user.api.apis;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.user.api.domain.request.UserRoleDataRequest;
import com.nbsaas.boot.user.api.domain.request.UserRoleSearchRequest;
import com.nbsaas.boot.user.api.domain.response.UserRoleResponse;
import com.nbsaas.boot.user.api.domain.simple.UserRoleSimple;


/**
 * 对外接口
 */
public interface UserRoleApi extends BaseApi
        <UserRoleResponse, UserRoleSimple, UserRoleDataRequest, UserRoleSearchRequest> {


}

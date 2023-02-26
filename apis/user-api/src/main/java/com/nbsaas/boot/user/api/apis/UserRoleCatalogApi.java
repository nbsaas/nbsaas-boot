package com.nbsaas.boot.user.api.apis;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.user.api.domain.request.UserRoleCatalogDataRequest;
import com.nbsaas.boot.user.api.domain.request.UserRoleCatalogSearchRequest;
import com.nbsaas.boot.user.api.domain.response.UserRoleCatalogResponse;
import com.nbsaas.boot.user.api.domain.simple.UserRoleCatalogSimple;


/**
 * 对外接口
 */
public interface UserRoleCatalogApi extends BaseApi
        <UserRoleCatalogResponse, UserRoleCatalogSimple, UserRoleCatalogDataRequest, UserRoleCatalogSearchRequest> {


}

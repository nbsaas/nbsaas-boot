package com.nbsaas.boot.user.api.apis;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.user.api.domain.request.StructureDataRequest;
import com.nbsaas.boot.user.api.domain.request.StructureSearchRequest;
import com.nbsaas.boot.user.api.domain.response.StructureResponse;
import com.nbsaas.boot.user.api.domain.simple.StructureSimple;


/**
 * 对外接口
 */
public interface StructureApi extends BaseApi
        <StructureResponse, StructureSimple, StructureDataRequest, StructureSearchRequest> {


}

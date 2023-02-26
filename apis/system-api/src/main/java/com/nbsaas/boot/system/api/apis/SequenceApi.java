package com.nbsaas.boot.system.api.apis;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.system.api.domain.request.SequenceDataRequest;
import com.nbsaas.boot.system.api.domain.request.SequenceSearchRequest;
import com.nbsaas.boot.system.api.domain.response.SequenceResponse;
import com.nbsaas.boot.system.api.domain.simple.SequenceSimple;


/**
 * 对外接口
 */
public interface SequenceApi extends BaseApi
        <SequenceResponse, SequenceSimple, SequenceDataRequest, SequenceSearchRequest> {


}

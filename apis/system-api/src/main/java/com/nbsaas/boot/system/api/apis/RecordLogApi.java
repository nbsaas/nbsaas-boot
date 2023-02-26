package com.nbsaas.boot.system.api.apis;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.system.api.domain.request.RecordLogDataRequest;
import com.nbsaas.boot.system.api.domain.request.RecordLogSearchRequest;
import com.nbsaas.boot.system.api.domain.response.RecordLogResponse;
import com.nbsaas.boot.system.api.domain.simple.RecordLogSimple;


/**
 * 对外接口
 */
public interface RecordLogApi extends BaseApi
        <RecordLogResponse, RecordLogSimple, RecordLogDataRequest, RecordLogSearchRequest> {


}

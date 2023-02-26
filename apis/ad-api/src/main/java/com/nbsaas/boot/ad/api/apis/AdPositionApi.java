package com.nbsaas.boot.ad.api.apis;

import com.nbsaas.boot.ad.api.domain.request.AdPositionSearchRequest;
import com.nbsaas.boot.ad.api.domain.request.AdPositionDataRequest;
import com.nbsaas.boot.ad.api.domain.simple.AdPositionSimple;
import com.nbsaas.boot.ad.api.domain.response.AdPositionResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface AdPositionApi extends BaseApi
<AdPositionResponse, AdPositionSimple, AdPositionDataRequest, AdPositionSearchRequest> {


}

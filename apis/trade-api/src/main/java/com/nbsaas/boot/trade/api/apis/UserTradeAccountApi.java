package com.nbsaas.boot.trade.api.apis;

import com.nbsaas.boot.trade.api.domain.request.UserTradeAccountSearchRequest;
import com.nbsaas.boot.trade.api.domain.request.UserTradeAccountDataRequest;
import com.nbsaas.boot.trade.api.domain.simple.UserTradeAccountSimple;
import com.nbsaas.boot.trade.api.domain.response.UserTradeAccountResponse;
import com.nbsaas.boot.rest.api.BaseApi;


/**
* 对外接口
*/
public interface UserTradeAccountApi extends BaseApi
<UserTradeAccountResponse, UserTradeAccountSimple, UserTradeAccountDataRequest, UserTradeAccountSearchRequest> {


}

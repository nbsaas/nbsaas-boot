package com.nbsaas.boot.trade.api.apis;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.trade.api.domain.request.BasicTradeAccountDataRequest;
import com.nbsaas.boot.trade.api.domain.request.BasicTradeAccountSearchRequest;
import com.nbsaas.boot.trade.api.domain.response.BasicTradeAccountResponse;
import com.nbsaas.boot.trade.api.domain.simple.BasicTradeAccountSimple;


/**
 * 对外接口
 */
public interface BasicTradeAccountApi extends BaseApi
        <BasicTradeAccountResponse, BasicTradeAccountSimple, BasicTradeAccountDataRequest, BasicTradeAccountSearchRequest> {


}

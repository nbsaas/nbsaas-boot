package com.nbsaas.boot.trade.api.apis;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.trade.api.domain.request.TradeAccountExceptionDataRequest;
import com.nbsaas.boot.trade.api.domain.request.TradeAccountExceptionSearchRequest;
import com.nbsaas.boot.trade.api.domain.response.TradeAccountExceptionResponse;
import com.nbsaas.boot.trade.api.domain.simple.TradeAccountExceptionSimple;


/**
 * 对外接口
 */
public interface TradeAccountExceptionApi extends BaseApi
        <TradeAccountExceptionResponse, TradeAccountExceptionSimple, TradeAccountExceptionDataRequest, TradeAccountExceptionSearchRequest> {


}

package com.nbsaas.boot.trade.api.apis;

import com.nbsaas.boot.rest.api.BaseApi;
import com.nbsaas.boot.trade.api.domain.request.TradeStreamDataRequest;
import com.nbsaas.boot.trade.api.domain.request.TradeStreamSearchRequest;
import com.nbsaas.boot.trade.api.domain.response.TradeStreamResponse;
import com.nbsaas.boot.trade.api.domain.simple.TradeStreamSimple;


/**
 * 对外接口
 */
public interface TradeStreamApi extends BaseApi
        <TradeStreamResponse, TradeStreamSimple, TradeStreamDataRequest, TradeStreamSearchRequest> {


}

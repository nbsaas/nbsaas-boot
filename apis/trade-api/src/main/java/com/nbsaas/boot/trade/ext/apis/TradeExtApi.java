package com.nbsaas.boot.trade.ext.apis;

import com.nbsaas.boot.rest.response.ResponseObject;
import com.nbsaas.boot.trade.api.domain.response.TradeAccountResponse;
import com.nbsaas.boot.trade.ext.domain.request.TradeRequest;

public interface TradeExtApi {

    /**
     * 正常账户，余额不能为负数
     *
     * @return
     */
    ResponseObject<TradeAccountResponse> initNormal();

    /**
     * 特殊账户,余额可以为负数
     *
     * @return
     */
    ResponseObject<TradeAccountResponse> initSpecial();


    ResponseObject<?> trade(TradeRequest request);
}

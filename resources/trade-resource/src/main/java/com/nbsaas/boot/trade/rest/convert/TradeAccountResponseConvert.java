package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.entity.trade.TradeAccount;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.trade.api.domain.response.TradeAccountResponse;

/**
 * 实体对象转化成响应对象
 */

public class TradeAccountResponseConvert implements Converter
        <TradeAccountResponse, TradeAccount> {
    @Override
    public TradeAccountResponse convert(TradeAccount source) {
        TradeAccountResponse result = new TradeAccountResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}


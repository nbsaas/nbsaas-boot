package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.entity.trade.TradeAccount;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.trade.api.domain.request.TradeAccountDataRequest;

/**
 * 请求对象转换成实体对象
 */

public class TradeAccountEntityConvert implements Converter<TradeAccount, TradeAccountDataRequest> {
    @Override
    public TradeAccount convert(TradeAccountDataRequest source) {
        TradeAccount result = new TradeAccount();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}


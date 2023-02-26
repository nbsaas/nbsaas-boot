package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.entity.trade.TradeAccount;
import com.nbsaas.boot.entity.trade.TradeAccountException;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.trade.api.domain.request.TradeAccountExceptionDataRequest;

/**
 * 请求对象转换成实体对象
 */

public class TradeAccountExceptionEntityConvert implements Converter<TradeAccountException, TradeAccountExceptionDataRequest> {
    @Override
    public TradeAccountException convert(TradeAccountExceptionDataRequest source) {
        TradeAccountException result = new TradeAccountException();
        BeanDataUtils.copyProperties(source, result);
        if (source.getAccount() != null) {
            TradeAccount account = new TradeAccount();
            account.setId(source.getAccount());
            result.setAccount(account);
        }
        return result;
    }
}


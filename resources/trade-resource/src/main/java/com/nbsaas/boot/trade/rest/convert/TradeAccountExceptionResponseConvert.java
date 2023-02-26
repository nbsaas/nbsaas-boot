package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.entity.trade.TradeAccountException;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.trade.api.domain.response.TradeAccountExceptionResponse;

/**
 * 实体对象转化成响应对象
 */

public class TradeAccountExceptionResponseConvert implements Converter
        <TradeAccountExceptionResponse, TradeAccountException> {
    @Override
    public TradeAccountExceptionResponse convert(TradeAccountException source) {
        TradeAccountExceptionResponse result = new TradeAccountExceptionResponse();
        BeanDataUtils.copyProperties(source, result);
        if (source.getAccount() != null) {
            result.setAccount(source.getAccount().getId());
        }
        if (source.getAccount() != null) {
            result.setAccountName(source.getAccount().getName());
        }
        return result;
    }
}


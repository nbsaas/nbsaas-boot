package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.entity.trade.TradeAccount;
import com.nbsaas.boot.trade.api.domain.simple.TradeAccountSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/
public class TradeAccountSimpleConvert implements Converter
<TradeAccountSimple, TradeAccount> {

@Override
public TradeAccountSimple convert(TradeAccount source) {
TradeAccountSimple result = new TradeAccountSimple();
            result.setAddDate(source.getAddDate());
            result.setLastDate(source.getLastDate());
            result.setSalt(source.getSalt());
            result.setSerialNo(source.getSerialNo());
            result.setCheckValue(source.getCheckValue());
            result.setAmount(source.getAmount());
            result.setAccountType(source.getAccountType());
            result.setName(source.getName());

return result;
}
}
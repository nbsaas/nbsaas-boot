package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.entity.trade.TradeAccountException;
import com.nbsaas.boot.trade.api.domain.simple.TradeAccountExceptionSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/
public class TradeAccountExceptionSimpleConvert implements Converter
<TradeAccountExceptionSimple, TradeAccountException> {

@Override
public TradeAccountExceptionSimple convert(TradeAccountException source) {
TradeAccountExceptionSimple result = new TradeAccountExceptionSimple();
            result.setAddDate(source.getAddDate());
            result.setLastDate(source.getLastDate());
            result.setOldSalt(source.getOldSalt());
            result.setOldAmount(source.getOldAmount());
            result.setCheckValue(source.getCheckValue());
            result.setAmount(source.getAmount());
            if(source.getAccount()!=null){
            result.setAccount(source.getAccount().getId());
            }
            if(source.getAccount()!=null){
            result.setAccountName(source.getAccount().getName());
            }
            result.setOldCheckValue(source.getOldCheckValue());

return result;
}
}
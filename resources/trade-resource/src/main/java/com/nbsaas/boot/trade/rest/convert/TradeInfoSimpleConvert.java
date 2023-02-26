package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.entity.trade.TradeInfo;
import com.nbsaas.boot.trade.api.domain.simple.TradeInfoSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/
public class TradeInfoSimpleConvert implements Converter
<TradeInfoSimple, TradeInfo> {

@Override
public TradeInfoSimple convert(TradeInfo source) {
TradeInfoSimple result = new TradeInfoSimple();
            result.setAddDate(source.getAddDate());
            result.setLastDate(source.getLastDate());
            if(source.getFrom()!=null){
            result.setFromName(source.getFrom().getName());
            }
            if(source.getTo()!=null){
            result.setToName(source.getTo().getName());
            }
            result.setAmount(source.getAmount());
            if(source.getFrom()!=null){
            result.setFrom(source.getFrom().getId());
            }
            if(source.getTo()!=null){
            result.setTo(source.getTo().getId());
            }

return result;
}
}
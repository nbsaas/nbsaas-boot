package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.entity.trade.TradeStream;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.trade.api.domain.simple.TradeStreamSimple;

/**
 * 列表对象转换器
 */
public class TradeStreamSimpleConvert implements Converter
        <TradeStreamSimple, TradeStream> {

    @Override
    public TradeStreamSimple convert(TradeStream source) {
        TradeStreamSimple result = new TradeStreamSimple();
        result.setAddDate(source.getAddDate());
        result.setLastDate(source.getLastDate());
        result.setNote(source.getNote());
        result.setSerialNo(source.getSerialNo());
        result.setPreAmount(source.getPreAmount());
        result.setChangeType(source.getChangeType());
        if (source.getInfo() != null) {
            result.setInfo(source.getInfo().getId());
        }
        result.setAmount(source.getAmount());
        if (source.getAccount() != null) {
            result.setAccount(source.getAccount().getId());
        }
        if (source.getAccount() != null) {
            result.setAccountName(source.getAccount().getName());
        }
        result.setAfterAmount(source.getAfterAmount());

        return result;
    }
}
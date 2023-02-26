package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.entity.trade.BasicTradeAccount;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.trade.api.domain.simple.BasicTradeAccountSimple;

/**
 * 列表对象转换器
 */
public class BasicTradeAccountSimpleConvert implements Converter
        <BasicTradeAccountSimple, BasicTradeAccount> {

    @Override
    public BasicTradeAccountSimple convert(BasicTradeAccount source) {
        BasicTradeAccountSimple result = new BasicTradeAccountSimple();
        result.setAddDate(source.getAddDate());
        result.setLastDate(source.getLastDate());
        result.setKey(source.getKey());
        if (source.getAccount() != null) {
            result.setAccount(source.getAccount().getId());
        }
        if (source.getAccount() != null) {
            result.setAccountName(source.getAccount().getName());
        }

        return result;
    }
}
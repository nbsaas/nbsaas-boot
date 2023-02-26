package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.entity.trade.UserTradeAccount;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.trade.api.domain.simple.UserTradeAccountSimple;

/**
 * 列表对象转换器
 */
public class UserTradeAccountSimpleConvert implements Converter
        <UserTradeAccountSimple, UserTradeAccount> {

    @Override
    public UserTradeAccountSimple convert(UserTradeAccount source) {
        UserTradeAccountSimple result = new UserTradeAccountSimple();
        result.setAddDate(source.getAddDate());
        result.setLastDate(source.getLastDate());
        result.setKey(source.getKey());

        return result;
    }
}
package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.entity.trade.UserTradeAccount;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.trade.api.domain.request.UserTradeAccountDataRequest;

/**
 * 请求对象转换成实体对象
 */

public class UserTradeAccountEntityConvert implements Converter<UserTradeAccount, UserTradeAccountDataRequest> {
    @Override
    public UserTradeAccount convert(UserTradeAccountDataRequest source) {
        UserTradeAccount result = new UserTradeAccount();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}


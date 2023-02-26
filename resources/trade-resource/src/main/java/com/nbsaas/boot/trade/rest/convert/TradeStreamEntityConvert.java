package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.entity.trade.TradeAccount;
import com.nbsaas.boot.entity.trade.TradeInfo;
import com.nbsaas.boot.entity.trade.TradeStream;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.trade.api.domain.request.TradeStreamDataRequest;

/**
 * 请求对象转换成实体对象
 */

public class TradeStreamEntityConvert implements Converter<TradeStream, TradeStreamDataRequest> {
    @Override
    public TradeStream convert(TradeStreamDataRequest source) {
        TradeStream result = new TradeStream();
        BeanDataUtils.copyProperties(source, result);
        if (source.getInfo() != null) {
            TradeInfo info = new TradeInfo();
            info.setId(source.getInfo());
            result.setInfo(info);
        }
        if (source.getAccount() != null) {
            TradeAccount account = new TradeAccount();
            account.setId(source.getAccount());
            result.setAccount(account);
        }
        return result;
    }
}


package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.entity.trade.TradeInfo;
import com.nbsaas.boot.trade.api.domain.request.TradeInfoDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
            import com.nbsaas.boot.entity.trade.TradeAccount;
            import com.nbsaas.boot.entity.trade.TradeAccount;

/**
* 请求对象转换成实体对象
*/

public class TradeInfoEntityConvert  implements Converter<TradeInfo, TradeInfoDataRequest> {
@Override
public TradeInfo convert(TradeInfoDataRequest source) {
TradeInfo result = new TradeInfo();
BeanDataUtils.copyProperties(source, result);
            if(source.getFrom()!=null){
            TradeAccount from =new TradeAccount();
            from.setId(source.getFrom());
            result.setFrom(from);
            }
            if(source.getTo()!=null){
            TradeAccount to =new TradeAccount();
            to.setId(source.getTo());
            result.setTo(to);
            }
return result;
}
}


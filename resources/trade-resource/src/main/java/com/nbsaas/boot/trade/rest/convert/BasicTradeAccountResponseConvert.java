package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.entity.trade.BasicTradeAccount;
import com.nbsaas.boot.trade.api.domain.response.BasicTradeAccountResponse;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;

/**
* 实体对象转化成响应对象
*/

public class BasicTradeAccountResponseConvert  implements Converter
<BasicTradeAccountResponse,BasicTradeAccount  > {
@Override
public BasicTradeAccountResponse convert(BasicTradeAccount source) {
BasicTradeAccountResponse  result = new  BasicTradeAccountResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getAccount()!=null){
            result.setAccount(source.getAccount().getId());
            }
            if(source.getAccount()!=null){
            result.setAccountName(source.getAccount().getName());
            }
return result;
}
}


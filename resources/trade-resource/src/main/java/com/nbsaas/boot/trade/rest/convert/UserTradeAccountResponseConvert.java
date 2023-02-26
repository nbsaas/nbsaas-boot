package com.nbsaas.boot.trade.rest.convert;

import com.nbsaas.boot.entity.trade.UserTradeAccount;
import com.nbsaas.boot.trade.api.domain.response.UserTradeAccountResponse;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;

/**
* 实体对象转化成响应对象
*/

public class UserTradeAccountResponseConvert  implements Converter
<UserTradeAccountResponse,UserTradeAccount  > {
@Override
public UserTradeAccountResponse convert(UserTradeAccount source) {
UserTradeAccountResponse  result = new  UserTradeAccountResponse();
BeanDataUtils.copyProperties(source, result);
return result;
}
}


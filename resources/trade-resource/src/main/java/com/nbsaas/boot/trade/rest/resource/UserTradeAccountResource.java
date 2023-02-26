package com.nbsaas.boot.trade.rest.resource;

import com.nbsaas.boot.trade.api.apis.UserTradeAccountApi;
import com.nbsaas.boot.entity.trade.UserTradeAccount;
import com.nbsaas.boot.trade.api.domain.request.UserTradeAccountSearchRequest;
import com.nbsaas.boot.trade.api.domain.request.UserTradeAccountDataRequest;
import com.nbsaas.boot.trade.api.domain.response.UserTradeAccountResponse;
import com.nbsaas.boot.trade.api.domain.simple.UserTradeAccountSimple;
import com.nbsaas.boot.trade.rest.convert.UserTradeAccountSimpleConvert;
import com.nbsaas.boot.trade.rest.convert.UserTradeAccountEntityConvert;
import com.nbsaas.boot.trade.rest.convert.UserTradeAccountResponseConvert;

import java.io.Serializable;
import com.nbsaas.boot.hibernate.data.core.BaseResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/**
*   业务接口实现
*/
@Transactional
@Service
public class UserTradeAccountResource extends BaseResource<UserTradeAccount,UserTradeAccountResponse, UserTradeAccountSimple, UserTradeAccountDataRequest, UserTradeAccountSearchRequest>  implements UserTradeAccountApi {

@Override
protected Class<UserTradeAccount> getEntityClass() {
return UserTradeAccount.class;
}

@Override
public Function<UserTradeAccount, UserTradeAccountSimple> getConvertSimple() {
return new UserTradeAccountSimpleConvert();
}

@Override
public Function
<UserTradeAccountDataRequest, UserTradeAccount> getConvertForm() {
return new UserTradeAccountEntityConvert();
}

@Override
public Function<UserTradeAccount, UserTradeAccountResponse> getConvertResponse() {
return new UserTradeAccountResponseConvert();
}

}



package com.nbsaas.boot.trade.rest.resource;

import com.nbsaas.boot.trade.api.apis.BasicTradeAccountApi;
import com.nbsaas.boot.entity.trade.BasicTradeAccount;
import com.nbsaas.boot.trade.api.domain.request.BasicTradeAccountSearchRequest;
import com.nbsaas.boot.trade.api.domain.request.BasicTradeAccountDataRequest;
import com.nbsaas.boot.trade.api.domain.response.BasicTradeAccountResponse;
import com.nbsaas.boot.trade.api.domain.simple.BasicTradeAccountSimple;
import com.nbsaas.boot.trade.rest.convert.BasicTradeAccountSimpleConvert;
import com.nbsaas.boot.trade.rest.convert.BasicTradeAccountEntityConvert;
import com.nbsaas.boot.trade.rest.convert.BasicTradeAccountResponseConvert;

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
public class BasicTradeAccountResource extends BaseResource<BasicTradeAccount,BasicTradeAccountResponse, BasicTradeAccountSimple, BasicTradeAccountDataRequest, BasicTradeAccountSearchRequest>  implements BasicTradeAccountApi {

@Override
protected Class<BasicTradeAccount> getEntityClass() {
return BasicTradeAccount.class;
}

@Override
public Function<BasicTradeAccount, BasicTradeAccountSimple> getConvertSimple() {
return new BasicTradeAccountSimpleConvert();
}

@Override
public Function
<BasicTradeAccountDataRequest, BasicTradeAccount> getConvertForm() {
return new BasicTradeAccountEntityConvert();
}

@Override
public Function<BasicTradeAccount, BasicTradeAccountResponse> getConvertResponse() {
return new BasicTradeAccountResponseConvert();
}

}



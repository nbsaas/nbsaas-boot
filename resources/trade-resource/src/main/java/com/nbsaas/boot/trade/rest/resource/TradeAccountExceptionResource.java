package com.nbsaas.boot.trade.rest.resource;

import com.nbsaas.boot.trade.api.apis.TradeAccountExceptionApi;
import com.nbsaas.boot.entity.trade.TradeAccountException;
import com.nbsaas.boot.trade.api.domain.request.TradeAccountExceptionSearchRequest;
import com.nbsaas.boot.trade.api.domain.request.TradeAccountExceptionDataRequest;
import com.nbsaas.boot.trade.api.domain.response.TradeAccountExceptionResponse;
import com.nbsaas.boot.trade.api.domain.simple.TradeAccountExceptionSimple;
import com.nbsaas.boot.trade.rest.convert.TradeAccountExceptionSimpleConvert;
import com.nbsaas.boot.trade.rest.convert.TradeAccountExceptionEntityConvert;
import com.nbsaas.boot.trade.rest.convert.TradeAccountExceptionResponseConvert;

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
public class TradeAccountExceptionResource extends BaseResource<TradeAccountException,TradeAccountExceptionResponse, TradeAccountExceptionSimple, TradeAccountExceptionDataRequest, TradeAccountExceptionSearchRequest>  implements TradeAccountExceptionApi {

@Override
protected Class<TradeAccountException> getEntityClass() {
return TradeAccountException.class;
}

@Override
public Function<TradeAccountException, TradeAccountExceptionSimple> getConvertSimple() {
return new TradeAccountExceptionSimpleConvert();
}

@Override
public Function
<TradeAccountExceptionDataRequest, TradeAccountException> getConvertForm() {
return new TradeAccountExceptionEntityConvert();
}

@Override
public Function<TradeAccountException, TradeAccountExceptionResponse> getConvertResponse() {
return new TradeAccountExceptionResponseConvert();
}

}



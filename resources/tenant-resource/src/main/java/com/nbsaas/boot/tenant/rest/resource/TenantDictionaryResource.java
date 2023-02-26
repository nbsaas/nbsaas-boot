package com.nbsaas.boot.tenant.rest.resource;

import com.nbsaas.boot.tenant.api.apis.TenantDictionaryApi;
import com.nbsaas.boot.entity.tenant.TenantDictionary;
import com.nbsaas.boot.tenant.api.domain.request.TenantDictionarySearchRequest;
import com.nbsaas.boot.tenant.api.domain.request.TenantDictionaryDataRequest;
import com.nbsaas.boot.tenant.api.domain.response.TenantDictionaryResponse;
import com.nbsaas.boot.tenant.api.domain.simple.TenantDictionarySimple;
import com.nbsaas.boot.tenant.rest.convert.TenantDictionarySimpleConvert;
import com.nbsaas.boot.tenant.rest.convert.TenantDictionaryEntityConvert;
import com.nbsaas.boot.tenant.rest.convert.TenantDictionaryResponseConvert;

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
public class TenantDictionaryResource extends BaseResource<TenantDictionary,TenantDictionaryResponse, TenantDictionarySimple, TenantDictionaryDataRequest, TenantDictionarySearchRequest>  implements TenantDictionaryApi {

@Override
protected Class<TenantDictionary> getEntityClass() {
return TenantDictionary.class;
}

@Override
public Function<TenantDictionary, TenantDictionarySimple> getConvertSimple() {
return new TenantDictionarySimpleConvert();
}

@Override
public Function
<TenantDictionaryDataRequest, TenantDictionary> getConvertForm() {
return new TenantDictionaryEntityConvert();
}

@Override
public Function<TenantDictionary, TenantDictionaryResponse> getConvertResponse() {
return new TenantDictionaryResponseConvert();
}

}



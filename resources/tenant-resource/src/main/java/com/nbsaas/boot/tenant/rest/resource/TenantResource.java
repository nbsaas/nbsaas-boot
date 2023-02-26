package com.nbsaas.boot.tenant.rest.resource;

import com.nbsaas.boot.tenant.api.apis.TenantApi;
import com.nbsaas.boot.entity.tenant.Tenant;
import com.nbsaas.boot.tenant.api.domain.request.TenantSearchRequest;
import com.nbsaas.boot.tenant.api.domain.request.TenantDataRequest;
import com.nbsaas.boot.tenant.api.domain.response.TenantResponse;
import com.nbsaas.boot.tenant.api.domain.simple.TenantSimple;
import com.nbsaas.boot.tenant.rest.convert.TenantSimpleConvert;
import com.nbsaas.boot.tenant.rest.convert.TenantEntityConvert;
import com.nbsaas.boot.tenant.rest.convert.TenantResponseConvert;

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
public class TenantResource extends BaseResource<Tenant,TenantResponse, TenantSimple, TenantDataRequest, TenantSearchRequest>  implements TenantApi {

@Override
protected Class<Tenant> getEntityClass() {
return Tenant.class;
}

@Override
public Function<Tenant, TenantSimple> getConvertSimple() {
return new TenantSimpleConvert();
}

@Override
public Function
<TenantDataRequest, Tenant> getConvertForm() {
return new TenantEntityConvert();
}

@Override
public Function<Tenant, TenantResponse> getConvertResponse() {
return new TenantResponseConvert();
}

}



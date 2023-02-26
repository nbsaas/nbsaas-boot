package com.nbsaas.boot.tenant.rest.resource;

import com.nbsaas.boot.tenant.api.apis.TenantCatalogApi;
import com.nbsaas.boot.entity.tenant.TenantCatalog;
import com.nbsaas.boot.tenant.api.domain.request.TenantCatalogSearchRequest;
import com.nbsaas.boot.tenant.api.domain.request.TenantCatalogDataRequest;
import com.nbsaas.boot.tenant.api.domain.response.TenantCatalogResponse;
import com.nbsaas.boot.tenant.api.domain.simple.TenantCatalogSimple;
import com.nbsaas.boot.tenant.rest.convert.TenantCatalogSimpleConvert;
import com.nbsaas.boot.tenant.rest.convert.TenantCatalogEntityConvert;
import com.nbsaas.boot.tenant.rest.convert.TenantCatalogResponseConvert;

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
public class TenantCatalogResource extends BaseResource<TenantCatalog,TenantCatalogResponse, TenantCatalogSimple, TenantCatalogDataRequest, TenantCatalogSearchRequest>  implements TenantCatalogApi {

@Override
protected Class<TenantCatalog> getEntityClass() {
return TenantCatalog.class;
}

@Override
public Function<TenantCatalog, TenantCatalogSimple> getConvertSimple() {
return new TenantCatalogSimpleConvert();
}

@Override
public Function
<TenantCatalogDataRequest, TenantCatalog> getConvertForm() {
return new TenantCatalogEntityConvert();
}

@Override
public Function<TenantCatalog, TenantCatalogResponse> getConvertResponse() {
return new TenantCatalogResponseConvert();
}

}



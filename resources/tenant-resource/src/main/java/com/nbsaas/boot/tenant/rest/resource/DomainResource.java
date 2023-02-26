package com.nbsaas.boot.tenant.rest.resource;

import com.nbsaas.boot.tenant.api.apis.DomainApi;
import com.nbsaas.boot.entity.tenant.Domain;
import com.nbsaas.boot.tenant.api.domain.request.DomainSearchRequest;
import com.nbsaas.boot.tenant.api.domain.request.DomainDataRequest;
import com.nbsaas.boot.tenant.api.domain.response.DomainResponse;
import com.nbsaas.boot.tenant.api.domain.simple.DomainSimple;
import com.nbsaas.boot.tenant.rest.convert.DomainSimpleConvert;
import com.nbsaas.boot.tenant.rest.convert.DomainEntityConvert;
import com.nbsaas.boot.tenant.rest.convert.DomainResponseConvert;

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
public class DomainResource extends BaseResource<Domain,DomainResponse, DomainSimple, DomainDataRequest, DomainSearchRequest>  implements DomainApi {

@Override
protected Class<Domain> getEntityClass() {
return Domain.class;
}

@Override
public Function<Domain, DomainSimple> getConvertSimple() {
return new DomainSimpleConvert();
}

@Override
public Function
<DomainDataRequest, Domain> getConvertForm() {
return new DomainEntityConvert();
}

@Override
public Function<Domain, DomainResponse> getConvertResponse() {
return new DomainResponseConvert();
}

}



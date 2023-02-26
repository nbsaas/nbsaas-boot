package com.nbsaas.boot.user.rest.resource;

import com.nbsaas.boot.user.api.apis.UserRoleCatalogApi;
import com.nbsaas.boot.entity.user.UserRoleCatalog;
import com.nbsaas.boot.user.api.domain.request.UserRoleCatalogSearchRequest;
import com.nbsaas.boot.user.api.domain.request.UserRoleCatalogDataRequest;
import com.nbsaas.boot.user.api.domain.response.UserRoleCatalogResponse;
import com.nbsaas.boot.user.api.domain.simple.UserRoleCatalogSimple;
import com.nbsaas.boot.user.rest.convert.UserRoleCatalogSimpleConvert;
import com.nbsaas.boot.user.rest.convert.UserRoleCatalogEntityConvert;
import com.nbsaas.boot.user.rest.convert.UserRoleCatalogResponseConvert;

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
public class UserRoleCatalogResource extends BaseResource<UserRoleCatalog,UserRoleCatalogResponse, UserRoleCatalogSimple, UserRoleCatalogDataRequest, UserRoleCatalogSearchRequest>  implements UserRoleCatalogApi {

@Override
protected Class<UserRoleCatalog> getEntityClass() {
return UserRoleCatalog.class;
}

@Override
public Function<UserRoleCatalog, UserRoleCatalogSimple> getConvertSimple() {
return new UserRoleCatalogSimpleConvert();
}

@Override
public Function
<UserRoleCatalogDataRequest, UserRoleCatalog> getConvertForm() {
return new UserRoleCatalogEntityConvert();
}

@Override
public Function<UserRoleCatalog, UserRoleCatalogResponse> getConvertResponse() {
return new UserRoleCatalogResponseConvert();
}

}



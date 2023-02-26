package com.nbsaas.boot.user.rest.resource;

import com.nbsaas.boot.user.api.apis.UserRoleApi;
import com.nbsaas.boot.entity.user.UserRole;
import com.nbsaas.boot.user.api.domain.request.UserRoleSearchRequest;
import com.nbsaas.boot.user.api.domain.request.UserRoleDataRequest;
import com.nbsaas.boot.user.api.domain.response.UserRoleResponse;
import com.nbsaas.boot.user.api.domain.simple.UserRoleSimple;
import com.nbsaas.boot.user.rest.convert.UserRoleSimpleConvert;
import com.nbsaas.boot.user.rest.convert.UserRoleEntityConvert;
import com.nbsaas.boot.user.rest.convert.UserRoleResponseConvert;

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
public class UserRoleResource extends BaseResource<UserRole,UserRoleResponse, UserRoleSimple, UserRoleDataRequest, UserRoleSearchRequest>  implements UserRoleApi {

@Override
protected Class<UserRole> getEntityClass() {
return UserRole.class;
}

@Override
public Function<UserRole, UserRoleSimple> getConvertSimple() {
return new UserRoleSimpleConvert();
}

@Override
public Function
<UserRoleDataRequest, UserRole> getConvertForm() {
return new UserRoleEntityConvert();
}

@Override
public Function<UserRole, UserRoleResponse> getConvertResponse() {
return new UserRoleResponseConvert();
}

}



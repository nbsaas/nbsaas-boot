package com.nbsaas.boot.user.rest.resource;

import com.nbsaas.boot.user.api.apis.UserPasswordApi;
import com.nbsaas.boot.entity.user.UserPassword;
import com.nbsaas.boot.user.api.domain.request.UserPasswordSearchRequest;
import com.nbsaas.boot.user.api.domain.request.UserPasswordDataRequest;
import com.nbsaas.boot.user.api.domain.response.UserPasswordResponse;
import com.nbsaas.boot.user.api.domain.simple.UserPasswordSimple;
import com.nbsaas.boot.user.rest.convert.UserPasswordSimpleConvert;
import com.nbsaas.boot.user.rest.convert.UserPasswordEntityConvert;
import com.nbsaas.boot.user.rest.convert.UserPasswordResponseConvert;

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
public class UserPasswordResource extends BaseResource<UserPassword,UserPasswordResponse, UserPasswordSimple, UserPasswordDataRequest, UserPasswordSearchRequest>  implements UserPasswordApi {

@Override
protected Class<UserPassword> getEntityClass() {
return UserPassword.class;
}

@Override
public Function<UserPassword, UserPasswordSimple> getConvertSimple() {
return new UserPasswordSimpleConvert();
}

@Override
public Function
<UserPasswordDataRequest, UserPassword> getConvertForm() {
return new UserPasswordEntityConvert();
}

@Override
public Function<UserPassword, UserPasswordResponse> getConvertResponse() {
return new UserPasswordResponseConvert();
}

}



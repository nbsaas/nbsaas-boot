package com.nbsaas.boot.user.rest.resource;

import com.nbsaas.boot.user.api.apis.UserOauthConfigApi;
import com.nbsaas.boot.entity.user.UserOauthConfig;
import com.nbsaas.boot.user.api.domain.request.UserOauthConfigSearchRequest;
import com.nbsaas.boot.user.api.domain.request.UserOauthConfigDataRequest;
import com.nbsaas.boot.user.api.domain.response.UserOauthConfigResponse;
import com.nbsaas.boot.user.api.domain.simple.UserOauthConfigSimple;
import com.nbsaas.boot.user.rest.convert.UserOauthConfigSimpleConvert;
import com.nbsaas.boot.user.rest.convert.UserOauthConfigEntityConvert;
import com.nbsaas.boot.user.rest.convert.UserOauthConfigResponseConvert;

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
public class UserOauthConfigResource extends BaseResource<UserOauthConfig,UserOauthConfigResponse, UserOauthConfigSimple, UserOauthConfigDataRequest, UserOauthConfigSearchRequest>  implements UserOauthConfigApi {

@Override
protected Class<UserOauthConfig> getEntityClass() {
return UserOauthConfig.class;
}

@Override
public Function<UserOauthConfig, UserOauthConfigSimple> getConvertSimple() {
return new UserOauthConfigSimpleConvert();
}

@Override
public Function
<UserOauthConfigDataRequest, UserOauthConfig> getConvertForm() {
return new UserOauthConfigEntityConvert();
}

@Override
public Function<UserOauthConfig, UserOauthConfigResponse> getConvertResponse() {
return new UserOauthConfigResponseConvert();
}

}



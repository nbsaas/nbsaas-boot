package com.nbsaas.boot.user.rest.resource;

import com.nbsaas.boot.entity.user.UserOauthToken;
import com.nbsaas.boot.hibernate.data.core.BaseResource;
import com.nbsaas.boot.user.api.apis.UserOauthTokenApi;
import com.nbsaas.boot.user.api.domain.request.UserOauthTokenDataRequest;
import com.nbsaas.boot.user.api.domain.request.UserOauthTokenSearchRequest;
import com.nbsaas.boot.user.api.domain.response.UserOauthTokenResponse;
import com.nbsaas.boot.user.api.domain.simple.UserOauthTokenSimple;
import com.nbsaas.boot.user.rest.convert.UserOauthTokenEntityConvert;
import com.nbsaas.boot.user.rest.convert.UserOauthTokenResponseConvert;
import com.nbsaas.boot.user.rest.convert.UserOauthTokenSimpleConvert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

/**
 * 业务接口实现
 */
@Transactional
@Service
public class UserOauthTokenResource extends BaseResource<UserOauthToken, UserOauthTokenResponse, UserOauthTokenSimple, UserOauthTokenDataRequest, UserOauthTokenSearchRequest> implements UserOauthTokenApi {

    @Override
    protected Class<UserOauthToken> getEntityClass() {
        return UserOauthToken.class;
    }

    @Override
    public Function<UserOauthToken, UserOauthTokenSimple> getConvertSimple() {
        return new UserOauthTokenSimpleConvert();
    }

    @Override
    public Function
            <UserOauthTokenDataRequest, UserOauthToken> getConvertForm() {
        return new UserOauthTokenEntityConvert();
    }

    @Override
    public Function<UserOauthToken, UserOauthTokenResponse> getConvertResponse() {
        return new UserOauthTokenResponseConvert();
    }

}



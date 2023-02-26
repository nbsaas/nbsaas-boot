package com.nbsaas.boot.user.rest.resource;

import com.nbsaas.boot.entity.user.UserInfo;
import com.nbsaas.boot.hibernate.data.core.BaseResource;
import com.nbsaas.boot.user.api.apis.UserInfoApi;
import com.nbsaas.boot.user.api.domain.request.UserInfoDataRequest;
import com.nbsaas.boot.user.api.domain.request.UserInfoSearchRequest;
import com.nbsaas.boot.user.api.domain.response.UserInfoResponse;
import com.nbsaas.boot.user.api.domain.simple.UserInfoSimple;
import com.nbsaas.boot.user.rest.convert.UserInfoEntityConvert;
import com.nbsaas.boot.user.rest.convert.UserInfoResponseConvert;
import com.nbsaas.boot.user.rest.convert.UserInfoSimpleConvert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

/**
 * 业务接口实现
 */
@Transactional
@Service
public class UserInfoResource extends BaseResource<UserInfo, UserInfoResponse, UserInfoSimple, UserInfoDataRequest, UserInfoSearchRequest> implements UserInfoApi {

    @Override
    protected Class<UserInfo> getEntityClass() {
        return UserInfo.class;
    }

    @Override
    public Function<UserInfo, UserInfoSimple> getConvertSimple() {
        return new UserInfoSimpleConvert();
    }

    @Override
    public Function
            <UserInfoDataRequest, UserInfo> getConvertForm() {
        return new UserInfoEntityConvert();
    }

    @Override
    public Function<UserInfo, UserInfoResponse> getConvertResponse() {
        return new UserInfoResponseConvert();
    }

}



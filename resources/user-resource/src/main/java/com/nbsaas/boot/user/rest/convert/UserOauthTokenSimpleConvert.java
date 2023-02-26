package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.UserOauthToken;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.simple.UserOauthTokenSimple;

/**
 * 列表对象转换器
 */
public class UserOauthTokenSimpleConvert implements Converter
        <UserOauthTokenSimple, UserOauthToken> {

    @Override
    public UserOauthTokenSimple convert(UserOauthToken source) {
        UserOauthTokenSimple result = new UserOauthTokenSimple();
        result.setAddDate(source.getAddDate());
        result.setLastDate(source.getLastDate());
        result.setToken_type(source.getToken_type());
        result.setExpires_in(source.getExpires_in());
        result.setAccess_token(source.getAccess_token());
        result.setUid(source.getUid());
        result.setLoginSize(source.getLoginSize());
        result.setRefresh_token(source.getRefresh_token());
        if (source.getUser() != null) {
            result.setUser(source.getUser().getId());
        }

        return result;
    }
}
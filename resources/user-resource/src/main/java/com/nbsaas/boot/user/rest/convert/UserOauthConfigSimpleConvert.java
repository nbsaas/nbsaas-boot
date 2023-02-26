package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.UserOauthConfig;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.simple.UserOauthConfigSimple;

/**
 * 列表对象转换器
 */
public class UserOauthConfigSimpleConvert implements Converter
        <UserOauthConfigSimple, UserOauthConfig> {

    @Override
    public UserOauthConfigSimple convert(UserOauthConfig source) {
        UserOauthConfigSimple result = new UserOauthConfigSimple();
        result.setState(source.getState());
        result.setAddDate(source.getAddDate());
        result.setLastDate(source.getLastDate());
        result.setClassName(source.getClassName());
        result.setModel(source.getModel());
        result.setAppKey(source.getAppKey());
        result.setName(source.getName());
        result.setAppSecret(source.getAppSecret());

        return result;
    }
}
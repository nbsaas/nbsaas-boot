package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.UserPassword;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.simple.UserPasswordSimple;

/**
 * 列表对象转换器
 */
public class UserPasswordSimpleConvert implements Converter
        <UserPasswordSimple, UserPassword> {

    @Override
    public UserPasswordSimple convert(UserPassword source) {
        UserPasswordSimple result = new UserPasswordSimple();
        result.setAddDate(source.getAddDate());
        result.setLastDate(source.getLastDate());
        result.setSalt(source.getSalt());
        result.setPassword(source.getPassword());
        result.setSecurityType(source.getSecurityType());
        result.setCheckSize(source.getCheckSize());
        if (source.getUser() != null) {
            result.setUser(source.getUser().getId());
        }

        return result;
    }
}
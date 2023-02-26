package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.UserAccount;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.simple.UserAccountSimple;

/**
 * 列表对象转换器
 */
public class UserAccountSimpleConvert implements Converter
        <UserAccountSimple, UserAccount> {

    @Override
    public UserAccountSimple convert(UserAccount source) {
        UserAccountSimple result = new UserAccountSimple();
        result.setAddDate(source.getAddDate());
        result.setLastDate(source.getLastDate());
        result.setAccountType(source.getAccountType());
        result.setLoginSize(source.getLoginSize());
        result.setUsername(source.getUsername());
        if (source.getUser() != null) {
            result.setUser(source.getUser().getId());
        }

        return result;
    }
}
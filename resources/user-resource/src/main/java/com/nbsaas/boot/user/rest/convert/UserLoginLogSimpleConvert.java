package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.UserLoginLog;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.simple.UserLoginLogSimple;

/**
 * 列表对象转换器
 */
public class UserLoginLogSimpleConvert implements Converter
        <UserLoginLogSimple, UserLoginLog> {

    @Override
    public UserLoginLogSimple convert(UserLoginLog source) {
        UserLoginLogSimple result = new UserLoginLogSimple();
        result.setClient(source.getClient());
        result.setState(source.getState());
        result.setAddDate(source.getAddDate());
        result.setLastDate(source.getLastDate());
        result.setPassword(source.getPassword());
        result.setNote(source.getNote());
        if (source.getUser() != null) {
            result.setUserName(source.getUser().getName());
        }
        result.setIp(source.getIp());
        result.setStoreState(source.getStoreState());
        result.setAccount(source.getAccount());
        if (source.getUser() != null) {
            result.setUser(source.getUser().getId());
        }

        return result;
    }
}
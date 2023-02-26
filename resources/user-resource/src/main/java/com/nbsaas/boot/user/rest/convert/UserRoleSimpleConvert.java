package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.UserRole;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.simple.UserRoleSimple;

/**
 * 列表对象转换器
 */
public class UserRoleSimpleConvert implements Converter
        <UserRoleSimple, UserRole> {

    @Override
    public UserRoleSimple convert(UserRole source) {
        UserRoleSimple result = new UserRoleSimple();
        result.setAddDate(source.getAddDate());
        result.setLastDate(source.getLastDate());
        if (source.getCatalog() != null) {
            result.setCatalogName(source.getCatalog().getName());
        }
        if (source.getCatalog() != null) {
            result.setCatalog(source.getCatalog().getId());
        }
        result.setAlias(source.getAlias());
        result.setDescription(source.getDescription());
        result.setName(source.getName());
        result.setType(source.getType());

        return result;
    }
}
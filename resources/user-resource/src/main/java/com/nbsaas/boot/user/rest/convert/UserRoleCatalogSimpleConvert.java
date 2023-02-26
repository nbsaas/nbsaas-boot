package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.UserRoleCatalog;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.simple.UserRoleCatalogSimple;

/**
 * 列表对象转换器
 */
public class UserRoleCatalogSimpleConvert implements Converter
        <UserRoleCatalogSimple, UserRoleCatalog> {

    @Override
    public UserRoleCatalogSimple convert(UserRoleCatalog source) {
        UserRoleCatalogSimple result = new UserRoleCatalogSimple();
        result.setAddDate(source.getAddDate());
        result.setLastDate(source.getLastDate());
        result.setLft(source.getLft());
        result.setRgt(source.getRgt());
        result.setIds(source.getIds());
        result.setLevelInfo(source.getLevelInfo());
        result.setSortNum(source.getSortNum());
        result.setName(source.getName());
        if (source.getParent() != null) {
            result.setParentName(source.getParent().getName());
        }
        result.setCode(source.getCode());
        if (source.getParent() != null) {
            result.setParent(source.getParent().getId());
        }

        return result;
    }
}
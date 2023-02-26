package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.ApplicationMenu;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.system.api.domain.simple.ApplicationMenuSimple;

/**
 * 列表对象转换器
 */
public class ApplicationMenuSimpleConvert implements Converter
        <ApplicationMenuSimple, ApplicationMenu> {

    @Override
    public ApplicationMenuSimple convert(ApplicationMenu source) {
        ApplicationMenuSimple result = new ApplicationMenuSimple();
        result.setNum(source.getNum());
        result.setLastDate(source.getLastDate());
        result.setLft(source.getLft());
        result.setRgt(source.getRgt());
        result.setMenuType(source.getMenuType());
        result.setPermission(source.getPermission());
        result.setLevelInfo(source.getLevelInfo());
        if (source.getApp() != null) {
            result.setAppName(source.getApp().getName());
        }
        result.setAddDate(source.getAddDate());
        if (source.getParent() != null) {
            result.setParent(source.getParent().getId());
        }
        if (source.getApp() != null) {
            result.setApp(source.getApp().getId());
        }
        result.setIds(source.getIds());
        result.setIcon(source.getIcon());
        result.setRouter(source.getRouter());
        result.setMenuId(source.getMenuId());
        result.setCatalog(source.getCatalog());
        result.setSortNum(source.getSortNum());
        result.setName(source.getName());
        result.setCode(source.getCode());
        if (source.getCreator() != null) {
            result.setCreatorName(source.getCreator().getName());
        }
        if (source.getCreator() != null) {
            result.setCreator(source.getCreator().getId());
        }
        result.setPath(source.getPath());

        return result;
    }
}
package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.Menu;
import com.nbsaas.boot.system.api.domain.simple.MenuSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/
public class MenuSimpleConvert implements Converter
<MenuSimple, Menu> {

@Override
public MenuSimple convert(Menu source) {
MenuSimple result = new MenuSimple();
            result.setLastDate(source.getLastDate());
            result.setLft(source.getLft());
            result.setRgt(source.getRgt());
            result.setMenuType(source.getMenuType());
            result.setPermission(source.getPermission());
            result.setLevelInfo(source.getLevelInfo());
            result.setAddDate(source.getAddDate());
            result.setIds(source.getIds());
            result.setIcon(source.getIcon());
            result.setRouter(source.getRouter());
            result.setCatalog(source.getCatalog());
            result.setNums(source.getNums());
            result.setSortNum(source.getSortNum());
            result.setName(source.getName());
            result.setCode(source.getCode());
            result.setPath(source.getPath());

return result;
}
}
package com.nbsaas.boot.tenant.rest.convert;

import com.nbsaas.boot.entity.tenant.TenantCatalog;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.tenant.api.domain.simple.TenantCatalogSimple;

/**
 * 列表对象转换器
 */
public class TenantCatalogSimpleConvert implements Converter
        <TenantCatalogSimple, TenantCatalog> {

    @Override
    public TenantCatalogSimple convert(TenantCatalog source) {
        TenantCatalogSimple result = new TenantCatalogSimple();
        result.setAddDate(source.getAddDate());
        result.setLastDate(source.getLastDate());
        result.setLft(source.getLft());
        result.setRgt(source.getRgt());
        result.setIds(source.getIds());
        result.setLevelInfo(source.getLevelInfo());
        if (source.getParent() != null) {
            result.setParent(source.getParent().getId());
        }
        result.setSortNum(source.getSortNum());
        result.setName(source.getName());
        if (source.getParent() != null) {
            result.setParentName(source.getParent().getName());
        }
        result.setCode(source.getCode());

        return result;
    }
}
package com.nbsaas.boot.tenant.rest.convert;

import com.nbsaas.boot.entity.tenant.TenantDictionaryItem;
import com.nbsaas.boot.tenant.api.domain.simple.TenantDictionaryItemSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/
public class TenantDictionaryItemSimpleConvert implements Converter
<TenantDictionaryItemSimple, TenantDictionaryItem> {

@Override
public TenantDictionaryItemSimple convert(TenantDictionaryItem source) {
TenantDictionaryItemSimple result = new TenantDictionaryItemSimple();
            result.setSortNum(source.getSortNum());
            result.setState(source.getState());
            result.setName(source.getName());
            result.setCode(source.getCode());

return result;
}
}
package com.nbsaas.boot.tenant.rest.convert;

import com.nbsaas.boot.entity.tenant.TenantDictionary;
import com.nbsaas.boot.tenant.api.domain.simple.TenantDictionarySimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/
public class TenantDictionarySimpleConvert implements Converter
<TenantDictionarySimple, TenantDictionary> {

@Override
public TenantDictionarySimple convert(TenantDictionary source) {
TenantDictionarySimple result = new TenantDictionarySimple();
            result.setAddDate(source.getAddDate());
            result.setLastDate(source.getLastDate());
            result.setNote(source.getNote());
            result.setKey(source.getKey());
            result.setVersion(source.getVersion());
            result.setStoreState(source.getStoreState());
            result.setName(source.getName());

return result;
}
}
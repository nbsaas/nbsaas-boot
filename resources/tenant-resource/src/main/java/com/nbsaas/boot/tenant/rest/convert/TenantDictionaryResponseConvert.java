package com.nbsaas.boot.tenant.rest.convert;

import com.nbsaas.boot.entity.tenant.TenantDictionary;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.tenant.api.domain.response.TenantDictionaryResponse;

/**
 * 实体对象转化成响应对象
 */

public class TenantDictionaryResponseConvert implements Converter
        <TenantDictionaryResponse, TenantDictionary> {
    @Override
    public TenantDictionaryResponse convert(TenantDictionary source) {
        TenantDictionaryResponse result = new TenantDictionaryResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}


package com.nbsaas.boot.tenant.rest.convert;

import com.nbsaas.boot.entity.tenant.TenantDictionaryItem;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.tenant.api.domain.response.TenantDictionaryItemResponse;

/**
 * 实体对象转化成响应对象
 */

public class TenantDictionaryItemResponseConvert implements Converter
        <TenantDictionaryItemResponse, TenantDictionaryItem> {
    @Override
    public TenantDictionaryItemResponse convert(TenantDictionaryItem source) {
        TenantDictionaryItemResponse result = new TenantDictionaryItemResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}


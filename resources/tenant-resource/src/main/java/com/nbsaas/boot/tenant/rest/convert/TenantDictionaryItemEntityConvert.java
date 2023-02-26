package com.nbsaas.boot.tenant.rest.convert;

import com.nbsaas.boot.entity.tenant.TenantDictionaryItem;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.tenant.api.domain.request.TenantDictionaryItemDataRequest;

/**
 * 请求对象转换成实体对象
 */

public class TenantDictionaryItemEntityConvert implements Converter<TenantDictionaryItem, TenantDictionaryItemDataRequest> {
    @Override
    public TenantDictionaryItem convert(TenantDictionaryItemDataRequest source) {
        TenantDictionaryItem result = new TenantDictionaryItem();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}


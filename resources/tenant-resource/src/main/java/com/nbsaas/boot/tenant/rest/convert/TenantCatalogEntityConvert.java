package com.nbsaas.boot.tenant.rest.convert;

import com.nbsaas.boot.entity.tenant.TenantCatalog;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.tenant.api.domain.request.TenantCatalogDataRequest;

/**
 * 请求对象转换成实体对象
 */

public class TenantCatalogEntityConvert implements Converter<TenantCatalog, TenantCatalogDataRequest> {
    @Override
    public TenantCatalog convert(TenantCatalogDataRequest source) {
        TenantCatalog result = new TenantCatalog();
        BeanDataUtils.copyProperties(source, result);
        if (source.getParent() != null) {
            TenantCatalog parent = new TenantCatalog();
            parent.setId(source.getParent());
            result.setParent(parent);
        }
        return result;
    }
}


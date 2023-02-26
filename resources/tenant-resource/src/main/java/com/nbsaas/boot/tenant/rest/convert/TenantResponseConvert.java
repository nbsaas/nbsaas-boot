package com.nbsaas.boot.tenant.rest.convert;

import com.nbsaas.boot.entity.tenant.Tenant;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.tenant.api.domain.response.TenantResponse;

/**
 * 实体对象转化成响应对象
 */

public class TenantResponseConvert implements Converter
        <TenantResponse, Tenant> {
    @Override
    public TenantResponse convert(Tenant source) {
        TenantResponse result = new TenantResponse();
        BeanDataUtils.copyProperties(source, result);
        if (source.getDomainGroup() != null) {
            result.setDomainGroup(source.getDomainGroup().getId());
        }
        if (source.getCreator() != null) {
            result.setCreatorName(source.getCreator().getName());
        }
        if (source.getCreator() != null) {
            result.setCreator(source.getCreator().getId());
        }
        return result;
    }
}


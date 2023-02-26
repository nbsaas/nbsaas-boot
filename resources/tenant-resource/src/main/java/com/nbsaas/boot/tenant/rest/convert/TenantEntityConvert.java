package com.nbsaas.boot.tenant.rest.convert;

import com.nbsaas.boot.entity.tenant.Domain;
import com.nbsaas.boot.entity.tenant.Tenant;
import com.nbsaas.boot.hibernate.data.entity.User;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.tenant.api.domain.request.TenantDataRequest;

/**
 * 请求对象转换成实体对象
 */

public class TenantEntityConvert implements Converter<Tenant, TenantDataRequest> {
    @Override
    public Tenant convert(TenantDataRequest source) {
        Tenant result = new Tenant();
        BeanDataUtils.copyProperties(source, result);
        if (source.getDomainGroup() != null) {
            Domain domainGroup = new Domain();
            domainGroup.setId(source.getDomainGroup());
            result.setDomainGroup(domainGroup);
        }
        if (source.getCreator() != null) {
            User creator = new User();
            creator.setId(source.getCreator());
            result.setCreator(creator);
        }
        return result;
    }
}


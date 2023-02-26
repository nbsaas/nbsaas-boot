package com.nbsaas.boot.tenant.rest.convert;

import com.nbsaas.boot.entity.tenant.Domain;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.tenant.api.domain.response.DomainResponse;

/**
 * 实体对象转化成响应对象
 */

public class DomainResponseConvert implements Converter
        <DomainResponse, Domain> {
    @Override
    public DomainResponse convert(Domain source) {
        DomainResponse result = new DomainResponse();
        BeanDataUtils.copyProperties(source, result);
        if (source.getCreator() != null) {
            result.setCreatorName(source.getCreator().getName());
        }
        if (source.getCreator() != null) {
            result.setCreator(source.getCreator().getId());
        }
        return result;
    }
}


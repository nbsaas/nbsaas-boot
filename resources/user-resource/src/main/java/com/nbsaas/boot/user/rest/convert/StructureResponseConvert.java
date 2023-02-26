package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.Structure;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.response.StructureResponse;

/**
 * 实体对象转化成响应对象
 */

public class StructureResponseConvert implements Converter
        <StructureResponse, Structure> {
    @Override
    public StructureResponse convert(Structure source) {
        StructureResponse result = new StructureResponse();
        BeanDataUtils.copyProperties(source, result);
        if (source.getParent() != null) {
            result.setParent(source.getParent().getId());
        }
        if (source.getParent() != null) {
            result.setParentName(source.getParent().getName());
        }
        return result;
    }
}


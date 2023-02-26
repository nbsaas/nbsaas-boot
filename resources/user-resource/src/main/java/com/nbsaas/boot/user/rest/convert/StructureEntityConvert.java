package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.Structure;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.request.StructureDataRequest;

/**
 * 请求对象转换成实体对象
 */

public class StructureEntityConvert implements Converter<Structure, StructureDataRequest> {
    @Override
    public Structure convert(StructureDataRequest source) {
        Structure result = new Structure();
        BeanDataUtils.copyProperties(source, result);
        if (source.getParent() != null) {
            Structure parent = new Structure();
            parent.setId(source.getParent());
            result.setParent(parent);
        }
        return result;
    }
}


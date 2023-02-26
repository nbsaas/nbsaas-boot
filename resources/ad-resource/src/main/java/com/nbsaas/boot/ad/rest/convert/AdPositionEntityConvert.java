package com.nbsaas.boot.ad.rest.convert;

import com.nbsaas.boot.ad.api.domain.request.AdPositionDataRequest;
import com.nbsaas.boot.entity.ad.AdPosition;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
 * 请求对象转换成实体对象
 */

public class AdPositionEntityConvert implements Converter<AdPosition, AdPositionDataRequest> {
    @Override
    public AdPosition convert(AdPositionDataRequest source) {
        AdPosition result = new AdPosition();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}


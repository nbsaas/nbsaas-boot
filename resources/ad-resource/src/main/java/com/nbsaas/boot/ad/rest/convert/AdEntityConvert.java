package com.nbsaas.boot.ad.rest.convert;

import com.nbsaas.boot.ad.api.domain.request.AdDataRequest;
import com.nbsaas.boot.entity.ad.Ad;
import com.nbsaas.boot.entity.ad.AdPosition;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;

/**
 * 请求对象转换成实体对象
 */

public class AdEntityConvert implements Converter<Ad, AdDataRequest> {
    @Override
    public Ad convert(AdDataRequest source) {
        Ad result = new Ad();
        BeanDataUtils.copyProperties(source, result);
        if (source.getAdPosition() != null) {
            AdPosition adPosition = new AdPosition();
            adPosition.setId(source.getAdPosition());
            result.setAdPosition(adPosition);
        }
        return result;
    }
}


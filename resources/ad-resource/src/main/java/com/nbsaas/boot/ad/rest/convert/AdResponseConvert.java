package com.nbsaas.boot.ad.rest.convert;

import com.nbsaas.boot.entity.ad.Ad;
import com.nbsaas.boot.ad.api.domain.response.AdResponse;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;

/**
* 实体对象转化成响应对象
*/

public class AdResponseConvert  implements Converter
<AdResponse,Ad  > {
@Override
public AdResponse convert(Ad source) {
AdResponse  result = new  AdResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getAdPosition()!=null){
            result.setAdPosition(source.getAdPosition().getId());
            }
            if(source.getAdPosition()!=null){
            result.setAdPositionName(source.getAdPosition().getName());
            }
return result;
}
}


package com.nbsaas.boot.ad.rest.convert;

import com.nbsaas.boot.entity.ad.AdPosition;
import com.nbsaas.boot.ad.api.domain.response.AdPositionResponse;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;

/**
* 实体对象转化成响应对象
*/

public class AdPositionResponseConvert  implements Converter
<AdPositionResponse,AdPosition  > {
@Override
public AdPositionResponse convert(AdPosition source) {
AdPositionResponse  result = new  AdPositionResponse();
BeanDataUtils.copyProperties(source, result);
return result;
}
}


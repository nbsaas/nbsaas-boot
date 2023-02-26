package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.Config;
import com.nbsaas.boot.system.api.domain.response.ConfigResponse;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;

/**
* 实体对象转化成响应对象
*/

public class ConfigResponseConvert  implements Converter
<ConfigResponse,Config  > {
@Override
public ConfigResponse convert(Config source) {
ConfigResponse  result = new  ConfigResponse();
BeanDataUtils.copyProperties(source, result);
return result;
}
}


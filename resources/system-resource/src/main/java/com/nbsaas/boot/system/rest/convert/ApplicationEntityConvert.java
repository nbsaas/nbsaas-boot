package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.Application;
import com.nbsaas.boot.system.api.domain.request.ApplicationDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class ApplicationEntityConvert  implements Converter<Application, ApplicationDataRequest> {
@Override
public Application convert(ApplicationDataRequest source) {
Application result = new Application();
BeanDataUtils.copyProperties(source, result);
return result;
}
}


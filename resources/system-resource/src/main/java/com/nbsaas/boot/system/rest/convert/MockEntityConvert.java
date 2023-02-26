package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.Mock;
import com.nbsaas.boot.system.api.domain.request.MockDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class MockEntityConvert  implements Converter<Mock, MockDataRequest> {
@Override
public Mock convert(MockDataRequest source) {
Mock result = new Mock();
BeanDataUtils.copyProperties(source, result);
return result;
}
}


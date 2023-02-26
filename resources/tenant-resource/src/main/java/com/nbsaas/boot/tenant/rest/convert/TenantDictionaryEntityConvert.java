package com.nbsaas.boot.tenant.rest.convert;

import com.nbsaas.boot.entity.tenant.TenantDictionary;
import com.nbsaas.boot.tenant.api.domain.request.TenantDictionaryDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class TenantDictionaryEntityConvert  implements Converter<TenantDictionary, TenantDictionaryDataRequest> {
@Override
public TenantDictionary convert(TenantDictionaryDataRequest source) {
TenantDictionary result = new TenantDictionary();
BeanDataUtils.copyProperties(source, result);
return result;
}
}


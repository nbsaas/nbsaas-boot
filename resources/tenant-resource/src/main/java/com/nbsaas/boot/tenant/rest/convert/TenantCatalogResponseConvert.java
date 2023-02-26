package com.nbsaas.boot.tenant.rest.convert;

import com.nbsaas.boot.entity.tenant.TenantCatalog;
import com.nbsaas.boot.tenant.api.domain.response.TenantCatalogResponse;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;

/**
* 实体对象转化成响应对象
*/

public class TenantCatalogResponseConvert  implements Converter
<TenantCatalogResponse,TenantCatalog  > {
@Override
public TenantCatalogResponse convert(TenantCatalog source) {
TenantCatalogResponse  result = new  TenantCatalogResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getParent()!=null){
            result.setParent(source.getParent().getId());
            }
            if(source.getParent()!=null){
            result.setParentName(source.getParent().getName());
            }
return result;
}
}


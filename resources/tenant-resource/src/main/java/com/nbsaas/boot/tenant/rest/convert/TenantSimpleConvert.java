package com.nbsaas.boot.tenant.rest.convert;

import com.nbsaas.boot.entity.tenant.Tenant;
import com.nbsaas.boot.tenant.api.domain.simple.TenantSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/
public class TenantSimpleConvert implements Converter
<TenantSimple, Tenant> {

@Override
public TenantSimple convert(Tenant source) {
TenantSimple result = new TenantSimple();
            result.setLastDate(source.getLastDate());
            result.setLogo(source.getLogo());
            if(source.getDomainGroup()!=null){
            result.setDomainGroup(source.getDomainGroup().getId());
            }
            result.setTheme(source.getTheme());
            result.setStoreState(source.getStoreState());
            result.setLng(source.getLng());
            result.setAddDate(source.getAddDate());
            result.setExpireDate(source.getExpireDate());
            result.setNote(source.getNote());
            result.setKey(source.getKey());
            result.setLat(source.getLat());
            result.setBeginDate(source.getBeginDate());
            result.setPhone(source.getPhone());
            result.setName(source.getName());
            if(source.getCreator()!=null){
            result.setCreatorName(source.getCreator().getName());
            }
            result.setDomain(source.getDomain());
            if(source.getCreator()!=null){
            result.setCreator(source.getCreator().getId());
            }
            result.setAddress(source.getAddress());

return result;
}
}
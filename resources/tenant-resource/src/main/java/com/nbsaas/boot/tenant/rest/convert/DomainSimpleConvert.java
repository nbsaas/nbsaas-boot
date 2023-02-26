package com.nbsaas.boot.tenant.rest.convert;

import com.nbsaas.boot.entity.tenant.Domain;
import com.nbsaas.boot.tenant.api.domain.simple.DomainSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/
public class DomainSimpleConvert implements Converter
<DomainSimple, Domain> {

@Override
public DomainSimple convert(Domain source) {
DomainSimple result = new DomainSimple();
            result.setAddDate(source.getAddDate());
            result.setLastDate(source.getLastDate());
            result.setNote(source.getNote());
            if(source.getCreator()!=null){
            result.setCreatorName(source.getCreator().getName());
            }
            result.setDomain(source.getDomain());
            if(source.getCreator()!=null){
            result.setCreator(source.getCreator().getId());
            }

return result;
}
}
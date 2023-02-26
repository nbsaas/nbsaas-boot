package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.Application;
import com.nbsaas.boot.system.api.domain.simple.ApplicationSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/
public class ApplicationSimpleConvert implements Converter
<ApplicationSimple, Application> {

@Override
public ApplicationSimple convert(Application source) {
ApplicationSimple result = new ApplicationSimple();
            result.setAddDate(source.getAddDate());
            result.setLastDate(source.getLastDate());
            result.setNote(source.getNote());
            result.setAppKey(source.getAppKey());
            result.setName(source.getName());

return result;
}
}
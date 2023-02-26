package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.ErrorLog;
import com.nbsaas.boot.system.api.domain.simple.ErrorLogSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/
public class ErrorLogSimpleConvert implements Converter
<ErrorLogSimple, ErrorLog> {

@Override
public ErrorLogSimple convert(ErrorLog source) {
ErrorLogSimple result = new ErrorLogSimple();
            result.setParam(source.getParam());
            result.setAddDate(source.getAddDate());
            result.setLastDate(source.getLastDate());
            result.setUrl(source.getUrl());
            result.setNote(source.getNote());
            result.setName(source.getName());
            result.setApp(source.getApp());
            result.setServerName(source.getServerName());

return result;
}
}
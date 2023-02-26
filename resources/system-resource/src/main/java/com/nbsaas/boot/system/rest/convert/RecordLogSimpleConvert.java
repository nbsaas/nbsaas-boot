package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.RecordLog;
import com.nbsaas.boot.system.api.domain.simple.RecordLogSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/
public class RecordLogSimpleConvert implements Converter
<RecordLogSimple, RecordLog> {

@Override
public RecordLogSimple convert(RecordLog source) {
RecordLogSimple result = new RecordLogSimple();
            result.setAddDate(source.getAddDate());
            result.setLastDate(source.getLastDate());
            result.setIp(source.getIp());
            result.setCreateName(source.getCreateName());
            result.setData(source.getData());
            result.setTitle(source.getTitle());
            result.setCreateUser(source.getCreateUser());
            result.setCreateDate(source.getCreateDate());
            result.setApp(source.getApp());

return result;
}
}
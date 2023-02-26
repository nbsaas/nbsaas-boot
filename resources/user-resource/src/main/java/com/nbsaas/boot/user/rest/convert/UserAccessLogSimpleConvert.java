package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.UserAccessLog;
import com.nbsaas.boot.user.api.domain.simple.UserAccessLogSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/
public class UserAccessLogSimpleConvert implements Converter
<UserAccessLogSimple, UserAccessLog> {

@Override
public UserAccessLogSimple convert(UserAccessLog source) {
UserAccessLogSimple result = new UserAccessLogSimple();
            result.setAddDate(source.getAddDate());
            result.setLastDate(source.getLastDate());
            result.setUrl(source.getUrl());
            result.setIp(source.getIp());
            result.setConsumeTime(source.getConsumeTime());
            if(source.getCreator()!=null){
            result.setCreator(source.getCreator().getId());
            }
            result.setStoreState(source.getStoreState());
            if(source.getCreator()!=null){
            result.setCreatorName(source.getCreator().getName());
            }

return result;
}
}
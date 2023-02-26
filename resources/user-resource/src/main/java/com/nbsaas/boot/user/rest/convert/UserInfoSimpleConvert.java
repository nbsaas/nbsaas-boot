package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.UserInfo;
import com.nbsaas.boot.user.api.domain.simple.UserInfoSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/
public class UserInfoSimpleConvert implements Converter
<UserInfoSimple, UserInfo> {

@Override
public UserInfoSimple convert(UserInfo source) {
UserInfoSimple result = new UserInfoSimple();
            result.setLastDate(source.getLastDate());
            result.setStoreState(source.getStoreState());
            result.setState(source.getState());
            result.setAddDate(source.getAddDate());
            if(source.getStructure()!=null){
            result.setStructure(source.getStructure().getId());
            }
            result.setNote(source.getNote());
            result.setDataScope(source.getDataScope());
            if(source.getStructure()!=null){
            result.setStructureName(source.getStructure().getName());
            }
            result.setAvatar(source.getAvatar());
            result.setCatalog(source.getCatalog());
            result.setPhone(source.getPhone());
            result.setLoginSize(source.getLoginSize());
            result.setName(source.getName());

return result;
}
}
package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.UserRole;
import com.nbsaas.boot.user.api.domain.response.UserRoleResponse;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;

/**
* 实体对象转化成响应对象
*/

public class UserRoleResponseConvert  implements Converter
<UserRoleResponse,UserRole  > {
@Override
public UserRoleResponse convert(UserRole source) {
UserRoleResponse  result = new  UserRoleResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getCatalog()!=null){
            result.setCatalogName(source.getCatalog().getName());
            }
            if(source.getCatalog()!=null){
            result.setCatalog(source.getCatalog().getId());
            }
return result;
}
}


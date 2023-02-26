package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.UserLoginLog;
import com.nbsaas.boot.user.api.domain.response.UserLoginLogResponse;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;

/**
* 实体对象转化成响应对象
*/

public class UserLoginLogResponseConvert  implements Converter
<UserLoginLogResponse,UserLoginLog  > {
@Override
public UserLoginLogResponse convert(UserLoginLog source) {
UserLoginLogResponse  result = new  UserLoginLogResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getUser()!=null){
            result.setUserName(source.getUser().getName());
            }
            if(source.getUser()!=null){
            result.setUser(source.getUser().getId());
            }
return result;
}
}


package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.UserAccount;
import com.nbsaas.boot.user.api.domain.response.UserAccountResponse;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;

/**
* 实体对象转化成响应对象
*/

public class UserAccountResponseConvert  implements Converter
<UserAccountResponse,UserAccount  > {
@Override
public UserAccountResponse convert(UserAccount source) {
UserAccountResponse  result = new  UserAccountResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getUser()!=null){
            result.setUser(source.getUser().getId());
            }
return result;
}
}


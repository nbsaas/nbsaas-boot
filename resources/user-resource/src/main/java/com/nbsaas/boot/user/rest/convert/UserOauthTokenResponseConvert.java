package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.UserOauthToken;
import com.nbsaas.boot.user.api.domain.response.UserOauthTokenResponse;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;

/**
* 实体对象转化成响应对象
*/

public class UserOauthTokenResponseConvert  implements Converter
<UserOauthTokenResponse,UserOauthToken  > {
@Override
public UserOauthTokenResponse convert(UserOauthToken source) {
UserOauthTokenResponse  result = new  UserOauthTokenResponse();
BeanDataUtils.copyProperties(source, result);
            if(source.getUser()!=null){
            result.setUser(source.getUser().getId());
            }
return result;
}
}


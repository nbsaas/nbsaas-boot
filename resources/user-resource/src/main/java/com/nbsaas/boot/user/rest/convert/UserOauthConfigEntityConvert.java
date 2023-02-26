package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.UserOauthConfig;
import com.nbsaas.boot.user.api.domain.request.UserOauthConfigDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class UserOauthConfigEntityConvert  implements Converter<UserOauthConfig, UserOauthConfigDataRequest> {
@Override
public UserOauthConfig convert(UserOauthConfigDataRequest source) {
UserOauthConfig result = new UserOauthConfig();
BeanDataUtils.copyProperties(source, result);
return result;
}
}


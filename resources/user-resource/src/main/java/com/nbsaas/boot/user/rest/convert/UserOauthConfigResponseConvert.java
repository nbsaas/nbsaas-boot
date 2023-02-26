package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.UserOauthConfig;
import com.nbsaas.boot.user.api.domain.response.UserOauthConfigResponse;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;

/**
* 实体对象转化成响应对象
*/

public class UserOauthConfigResponseConvert  implements Converter
<UserOauthConfigResponse,UserOauthConfig  > {
@Override
public UserOauthConfigResponse convert(UserOauthConfig source) {
UserOauthConfigResponse  result = new  UserOauthConfigResponse();
BeanDataUtils.copyProperties(source, result);
return result;
}
}


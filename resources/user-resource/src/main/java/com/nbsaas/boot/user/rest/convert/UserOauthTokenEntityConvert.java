package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.UserInfo;
import com.nbsaas.boot.entity.user.UserOauthToken;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.request.UserOauthTokenDataRequest;

/**
 * 请求对象转换成实体对象
 */

public class UserOauthTokenEntityConvert implements Converter<UserOauthToken, UserOauthTokenDataRequest> {
    @Override
    public UserOauthToken convert(UserOauthTokenDataRequest source) {
        UserOauthToken result = new UserOauthToken();
        BeanDataUtils.copyProperties(source, result);
        if (source.getUser() != null) {
            UserInfo user = new UserInfo();
            user.setId(source.getUser());
            result.setUser(user);
        }
        return result;
    }
}


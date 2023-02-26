package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.UserAccount;
import com.nbsaas.boot.entity.user.UserInfo;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.request.UserAccountDataRequest;

/**
 * 请求对象转换成实体对象
 */

public class UserAccountEntityConvert implements Converter<UserAccount, UserAccountDataRequest> {
    @Override
    public UserAccount convert(UserAccountDataRequest source) {
        UserAccount result = new UserAccount();
        BeanDataUtils.copyProperties(source, result);
        if (source.getUser() != null) {
            UserInfo user = new UserInfo();
            user.setId(source.getUser());
            result.setUser(user);
        }
        return result;
    }
}


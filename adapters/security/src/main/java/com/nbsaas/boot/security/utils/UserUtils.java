package com.nbsaas.boot.security.utils;

import com.nbsaas.boot.user.api.domain.response.UserInfoResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.beans.BeanUtils;

/**
 * @author ada
 */
public class UserUtils {

    public static UserInfoResponse user() {
        UserInfoResponse result = new UserInfoResponse();
        Object obj = SecurityUtils.getSubject().getPrincipal();
        if (obj instanceof UserInfoResponse) {
            return (UserInfoResponse) obj;
        }
        if (obj == null) {
            throw new UnauthenticatedException();
        }
        BeanUtils.copyProperties(obj, result);
        return result;
    }
}

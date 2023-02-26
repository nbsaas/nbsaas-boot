package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.UserRole;
import com.nbsaas.boot.entity.user.UserRoleCatalog;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.request.UserRoleDataRequest;

/**
 * 请求对象转换成实体对象
 */

public class UserRoleEntityConvert implements Converter<UserRole, UserRoleDataRequest> {
    @Override
    public UserRole convert(UserRoleDataRequest source) {
        UserRole result = new UserRole();
        BeanDataUtils.copyProperties(source, result);
        if (source.getCatalog() != null) {
            UserRoleCatalog catalog = new UserRoleCatalog();
            catalog.setId(source.getCatalog());
            result.setCatalog(catalog);
        }
        return result;
    }
}


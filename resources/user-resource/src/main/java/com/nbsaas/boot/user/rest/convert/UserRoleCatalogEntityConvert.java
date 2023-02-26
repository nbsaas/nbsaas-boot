package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.UserRoleCatalog;
import com.nbsaas.boot.user.api.domain.request.UserRoleCatalogDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
            import com.nbsaas.boot.entity.user.UserRoleCatalog;

/**
* 请求对象转换成实体对象
*/

public class UserRoleCatalogEntityConvert  implements Converter<UserRoleCatalog, UserRoleCatalogDataRequest> {
@Override
public UserRoleCatalog convert(UserRoleCatalogDataRequest source) {
UserRoleCatalog result = new UserRoleCatalog();
BeanDataUtils.copyProperties(source, result);
            if(source.getParent()!=null){
            UserRoleCatalog parent =new UserRoleCatalog();
            parent.setId(source.getParent());
            result.setParent(parent);
            }
return result;
}
}


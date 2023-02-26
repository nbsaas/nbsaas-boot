package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.UserPassword;
import com.nbsaas.boot.user.api.domain.request.UserPasswordDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
            import com.nbsaas.boot.entity.user.UserInfo;

/**
* 请求对象转换成实体对象
*/

public class UserPasswordEntityConvert  implements Converter<UserPassword, UserPasswordDataRequest> {
@Override
public UserPassword convert(UserPasswordDataRequest source) {
UserPassword result = new UserPassword();
BeanDataUtils.copyProperties(source, result);
            if(source.getUser()!=null){
            UserInfo user =new UserInfo();
            user.setId(source.getUser());
            result.setUser(user);
            }
return result;
}
}


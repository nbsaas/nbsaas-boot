package com.nbsaas.boot.tenant.rest.convert;

import com.nbsaas.boot.entity.tenant.Domain;
import com.nbsaas.boot.tenant.api.domain.request.DomainDataRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
            import com.nbsaas.boot.hibernate.data.entity.User;

/**
* 请求对象转换成实体对象
*/

public class DomainEntityConvert  implements Converter<Domain, DomainDataRequest> {
@Override
public Domain convert(DomainDataRequest source) {
Domain result = new Domain();
BeanDataUtils.copyProperties(source, result);
            if(source.getCreator()!=null){
            User creator =new User();
            creator.setId(source.getCreator());
            result.setCreator(creator);
            }
return result;
}
}


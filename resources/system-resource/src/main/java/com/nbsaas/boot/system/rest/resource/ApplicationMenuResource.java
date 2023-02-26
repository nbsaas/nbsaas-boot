package com.nbsaas.boot.system.rest.resource;

import com.nbsaas.boot.system.api.apis.ApplicationMenuApi;
import com.nbsaas.boot.entity.system.ApplicationMenu;
import com.nbsaas.boot.system.api.domain.request.ApplicationMenuSearchRequest;
import com.nbsaas.boot.system.api.domain.request.ApplicationMenuDataRequest;
import com.nbsaas.boot.system.api.domain.response.ApplicationMenuResponse;
import com.nbsaas.boot.system.api.domain.simple.ApplicationMenuSimple;
import com.nbsaas.boot.system.rest.convert.ApplicationMenuSimpleConvert;
import com.nbsaas.boot.system.rest.convert.ApplicationMenuEntityConvert;
import com.nbsaas.boot.system.rest.convert.ApplicationMenuResponseConvert;

import java.io.Serializable;
import com.nbsaas.boot.hibernate.data.core.BaseResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/**
*   业务接口实现
*/
@Transactional
@Service
public class ApplicationMenuResource extends BaseResource<ApplicationMenu,ApplicationMenuResponse, ApplicationMenuSimple, ApplicationMenuDataRequest, ApplicationMenuSearchRequest>  implements ApplicationMenuApi {

@Override
protected Class<ApplicationMenu> getEntityClass() {
return ApplicationMenu.class;
}

@Override
public Function<ApplicationMenu, ApplicationMenuSimple> getConvertSimple() {
return new ApplicationMenuSimpleConvert();
}

@Override
public Function
<ApplicationMenuDataRequest, ApplicationMenu> getConvertForm() {
return new ApplicationMenuEntityConvert();
}

@Override
public Function<ApplicationMenu, ApplicationMenuResponse> getConvertResponse() {
return new ApplicationMenuResponseConvert();
}

}



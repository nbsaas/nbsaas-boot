package com.nbsaas.boot.system.rest.resource;

import com.nbsaas.boot.system.api.apis.ConfigApi;
import com.nbsaas.boot.entity.system.Config;
import com.nbsaas.boot.system.api.domain.request.ConfigSearchRequest;
import com.nbsaas.boot.system.api.domain.request.ConfigDataRequest;
import com.nbsaas.boot.system.api.domain.response.ConfigResponse;
import com.nbsaas.boot.system.api.domain.simple.ConfigSimple;
import com.nbsaas.boot.system.rest.convert.ConfigSimpleConvert;
import com.nbsaas.boot.system.rest.convert.ConfigEntityConvert;
import com.nbsaas.boot.system.rest.convert.ConfigResponseConvert;

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
public class ConfigResource extends BaseResource<Config,ConfigResponse, ConfigSimple, ConfigDataRequest, ConfigSearchRequest>  implements ConfigApi {

@Override
protected Class<Config> getEntityClass() {
return Config.class;
}

@Override
public Function<Config, ConfigSimple> getConvertSimple() {
return new ConfigSimpleConvert();
}

@Override
public Function
<ConfigDataRequest, Config> getConvertForm() {
return new ConfigEntityConvert();
}

@Override
public Function<Config, ConfigResponse> getConvertResponse() {
return new ConfigResponseConvert();
}

}



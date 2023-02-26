package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.Config;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.system.api.domain.request.ConfigDataRequest;

/**
 * 请求对象转换成实体对象
 */

public class ConfigEntityConvert implements Converter<Config, ConfigDataRequest> {
    @Override
    public Config convert(ConfigDataRequest source) {
        Config result = new Config();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}


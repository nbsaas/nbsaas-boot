package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.Application;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.system.api.domain.response.ApplicationResponse;

/**
 * 实体对象转化成响应对象
 */

public class ApplicationResponseConvert implements Converter
        <ApplicationResponse, Application> {
    @Override
    public ApplicationResponse convert(Application source) {
        ApplicationResponse result = new ApplicationResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}


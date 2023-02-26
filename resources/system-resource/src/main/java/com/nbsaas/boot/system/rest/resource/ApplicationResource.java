package com.nbsaas.boot.system.rest.resource;

import com.nbsaas.boot.entity.system.Application;
import com.nbsaas.boot.hibernate.data.core.BaseResource;
import com.nbsaas.boot.system.api.apis.ApplicationApi;
import com.nbsaas.boot.system.api.domain.request.ApplicationDataRequest;
import com.nbsaas.boot.system.api.domain.request.ApplicationSearchRequest;
import com.nbsaas.boot.system.api.domain.response.ApplicationResponse;
import com.nbsaas.boot.system.api.domain.simple.ApplicationSimple;
import com.nbsaas.boot.system.rest.convert.ApplicationEntityConvert;
import com.nbsaas.boot.system.rest.convert.ApplicationResponseConvert;
import com.nbsaas.boot.system.rest.convert.ApplicationSimpleConvert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

/**
 * 业务接口实现
 */
@Transactional
@Service
public class ApplicationResource extends BaseResource<Application, ApplicationResponse, ApplicationSimple, ApplicationDataRequest, ApplicationSearchRequest> implements ApplicationApi {

    @Override
    protected Class<Application> getEntityClass() {
        return Application.class;
    }

    @Override
    public Function<Application, ApplicationSimple> getConvertSimple() {
        return new ApplicationSimpleConvert();
    }

    @Override
    public Function
            <ApplicationDataRequest, Application> getConvertForm() {
        return new ApplicationEntityConvert();
    }

    @Override
    public Function<Application, ApplicationResponse> getConvertResponse() {
        return new ApplicationResponseConvert();
    }

}



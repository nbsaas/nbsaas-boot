package com.nbsaas.boot.system.rest.resource;

import com.nbsaas.boot.entity.system.ErrorLog;
import com.nbsaas.boot.hibernate.data.core.BaseResource;
import com.nbsaas.boot.system.api.apis.ErrorLogApi;
import com.nbsaas.boot.system.api.domain.request.ErrorLogDataRequest;
import com.nbsaas.boot.system.api.domain.request.ErrorLogSearchRequest;
import com.nbsaas.boot.system.api.domain.response.ErrorLogResponse;
import com.nbsaas.boot.system.api.domain.simple.ErrorLogSimple;
import com.nbsaas.boot.system.rest.convert.ErrorLogEntityConvert;
import com.nbsaas.boot.system.rest.convert.ErrorLogResponseConvert;
import com.nbsaas.boot.system.rest.convert.ErrorLogSimpleConvert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

/**
 * 业务接口实现
 */
@Transactional
@Service
public class ErrorLogResource extends BaseResource<ErrorLog, ErrorLogResponse, ErrorLogSimple, ErrorLogDataRequest, ErrorLogSearchRequest> implements ErrorLogApi {

    @Override
    protected Class<ErrorLog> getEntityClass() {
        return ErrorLog.class;
    }

    @Override
    public Function<ErrorLog, ErrorLogSimple> getConvertSimple() {
        return new ErrorLogSimpleConvert();
    }

    @Override
    public Function
            <ErrorLogDataRequest, ErrorLog> getConvertForm() {
        return new ErrorLogEntityConvert();
    }

    @Override
    public Function<ErrorLog, ErrorLogResponse> getConvertResponse() {
        return new ErrorLogResponseConvert();
    }

}



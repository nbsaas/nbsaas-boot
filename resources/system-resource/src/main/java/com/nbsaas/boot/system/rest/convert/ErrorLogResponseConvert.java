package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.ErrorLog;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.system.api.domain.response.ErrorLogResponse;

/**
 * 实体对象转化成响应对象
 */

public class ErrorLogResponseConvert implements Converter
        <ErrorLogResponse, ErrorLog> {
    @Override
    public ErrorLogResponse convert(ErrorLog source) {
        ErrorLogResponse result = new ErrorLogResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}


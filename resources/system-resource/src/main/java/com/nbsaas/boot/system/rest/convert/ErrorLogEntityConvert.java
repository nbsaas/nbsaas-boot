package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.ErrorLog;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.system.api.domain.request.ErrorLogDataRequest;

/**
 * 请求对象转换成实体对象
 */

public class ErrorLogEntityConvert implements Converter<ErrorLog, ErrorLogDataRequest> {
    @Override
    public ErrorLog convert(ErrorLogDataRequest source) {
        ErrorLog result = new ErrorLog();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}


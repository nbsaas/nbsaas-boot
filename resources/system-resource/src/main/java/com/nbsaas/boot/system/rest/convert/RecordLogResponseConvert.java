package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.RecordLog;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.system.api.domain.response.RecordLogResponse;

/**
 * 实体对象转化成响应对象
 */

public class RecordLogResponseConvert implements Converter
        <RecordLogResponse, RecordLog> {
    @Override
    public RecordLogResponse convert(RecordLog source) {
        RecordLogResponse result = new RecordLogResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}


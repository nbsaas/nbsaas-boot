package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.RecordLog;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.system.api.domain.request.RecordLogDataRequest;

/**
 * 请求对象转换成实体对象
 */

public class RecordLogEntityConvert implements Converter<RecordLog, RecordLogDataRequest> {
    @Override
    public RecordLog convert(RecordLogDataRequest source) {
        RecordLog result = new RecordLog();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}


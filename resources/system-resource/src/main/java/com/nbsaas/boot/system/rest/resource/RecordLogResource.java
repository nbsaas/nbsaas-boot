package com.nbsaas.boot.system.rest.resource;

import com.nbsaas.boot.system.api.apis.RecordLogApi;
import com.nbsaas.boot.entity.system.RecordLog;
import com.nbsaas.boot.system.api.domain.request.RecordLogSearchRequest;
import com.nbsaas.boot.system.api.domain.request.RecordLogDataRequest;
import com.nbsaas.boot.system.api.domain.response.RecordLogResponse;
import com.nbsaas.boot.system.api.domain.simple.RecordLogSimple;
import com.nbsaas.boot.system.rest.convert.RecordLogSimpleConvert;
import com.nbsaas.boot.system.rest.convert.RecordLogEntityConvert;
import com.nbsaas.boot.system.rest.convert.RecordLogResponseConvert;

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
public class RecordLogResource extends BaseResource<RecordLog,RecordLogResponse, RecordLogSimple, RecordLogDataRequest, RecordLogSearchRequest>  implements RecordLogApi {

@Override
protected Class<RecordLog> getEntityClass() {
return RecordLog.class;
}

@Override
public Function<RecordLog, RecordLogSimple> getConvertSimple() {
return new RecordLogSimpleConvert();
}

@Override
public Function
<RecordLogDataRequest, RecordLog> getConvertForm() {
return new RecordLogEntityConvert();
}

@Override
public Function<RecordLog, RecordLogResponse> getConvertResponse() {
return new RecordLogResponseConvert();
}

}



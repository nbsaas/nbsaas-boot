package com.nbsaas.boot.user.rest.resource;

import com.nbsaas.boot.entity.user.UserAccessLog;
import com.nbsaas.boot.hibernate.data.core.BaseResource;
import com.nbsaas.boot.user.api.apis.UserAccessLogApi;
import com.nbsaas.boot.user.api.domain.request.UserAccessLogDataRequest;
import com.nbsaas.boot.user.api.domain.request.UserAccessLogSearchRequest;
import com.nbsaas.boot.user.api.domain.response.UserAccessLogResponse;
import com.nbsaas.boot.user.api.domain.simple.UserAccessLogSimple;
import com.nbsaas.boot.user.rest.convert.UserAccessLogEntityConvert;
import com.nbsaas.boot.user.rest.convert.UserAccessLogResponseConvert;
import com.nbsaas.boot.user.rest.convert.UserAccessLogSimpleConvert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

/**
 * 业务接口实现
 */
@Transactional
@Service
public class UserAccessLogResource extends BaseResource<UserAccessLog, UserAccessLogResponse, UserAccessLogSimple, UserAccessLogDataRequest, UserAccessLogSearchRequest> implements UserAccessLogApi {

    @Override
    protected Class<UserAccessLog> getEntityClass() {
        return UserAccessLog.class;
    }

    @Override
    public Function<UserAccessLog, UserAccessLogSimple> getConvertSimple() {
        return new UserAccessLogSimpleConvert();
    }

    @Override
    public Function
            <UserAccessLogDataRequest, UserAccessLog> getConvertForm() {
        return new UserAccessLogEntityConvert();
    }

    @Override
    public Function<UserAccessLog, UserAccessLogResponse> getConvertResponse() {
        return new UserAccessLogResponseConvert();
    }

}



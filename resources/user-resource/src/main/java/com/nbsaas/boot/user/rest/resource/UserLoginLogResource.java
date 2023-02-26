package com.nbsaas.boot.user.rest.resource;

import com.nbsaas.boot.user.api.apis.UserLoginLogApi;
import com.nbsaas.boot.entity.user.UserLoginLog;
import com.nbsaas.boot.user.api.domain.request.UserLoginLogSearchRequest;
import com.nbsaas.boot.user.api.domain.request.UserLoginLogDataRequest;
import com.nbsaas.boot.user.api.domain.response.UserLoginLogResponse;
import com.nbsaas.boot.user.api.domain.simple.UserLoginLogSimple;
import com.nbsaas.boot.user.rest.convert.UserLoginLogSimpleConvert;
import com.nbsaas.boot.user.rest.convert.UserLoginLogEntityConvert;
import com.nbsaas.boot.user.rest.convert.UserLoginLogResponseConvert;

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
public class UserLoginLogResource extends BaseResource<UserLoginLog,UserLoginLogResponse, UserLoginLogSimple, UserLoginLogDataRequest, UserLoginLogSearchRequest>  implements UserLoginLogApi {

@Override
protected Class<UserLoginLog> getEntityClass() {
return UserLoginLog.class;
}

@Override
public Function<UserLoginLog, UserLoginLogSimple> getConvertSimple() {
return new UserLoginLogSimpleConvert();
}

@Override
public Function
<UserLoginLogDataRequest, UserLoginLog> getConvertForm() {
return new UserLoginLogEntityConvert();
}

@Override
public Function<UserLoginLog, UserLoginLogResponse> getConvertResponse() {
return new UserLoginLogResponseConvert();
}

}



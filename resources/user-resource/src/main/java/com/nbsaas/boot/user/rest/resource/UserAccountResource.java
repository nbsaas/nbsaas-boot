package com.nbsaas.boot.user.rest.resource;

import com.nbsaas.boot.user.api.apis.UserAccountApi;
import com.nbsaas.boot.entity.user.UserAccount;
import com.nbsaas.boot.user.api.domain.request.UserAccountSearchRequest;
import com.nbsaas.boot.user.api.domain.request.UserAccountDataRequest;
import com.nbsaas.boot.user.api.domain.response.UserAccountResponse;
import com.nbsaas.boot.user.api.domain.simple.UserAccountSimple;
import com.nbsaas.boot.user.rest.convert.UserAccountSimpleConvert;
import com.nbsaas.boot.user.rest.convert.UserAccountEntityConvert;
import com.nbsaas.boot.user.rest.convert.UserAccountResponseConvert;

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
public class UserAccountResource extends BaseResource<UserAccount,UserAccountResponse, UserAccountSimple, UserAccountDataRequest, UserAccountSearchRequest>  implements UserAccountApi {

@Override
protected Class<UserAccount> getEntityClass() {
return UserAccount.class;
}

@Override
public Function<UserAccount, UserAccountSimple> getConvertSimple() {
return new UserAccountSimpleConvert();
}

@Override
public Function
<UserAccountDataRequest, UserAccount> getConvertForm() {
return new UserAccountEntityConvert();
}

@Override
public Function<UserAccount, UserAccountResponse> getConvertResponse() {
return new UserAccountResponseConvert();
}

}



package com.nbsaas.boot.system.rest.resource;

import com.nbsaas.boot.system.api.apis.MockApi;
import com.nbsaas.boot.entity.system.Mock;
import com.nbsaas.boot.system.api.domain.request.MockSearchRequest;
import com.nbsaas.boot.system.api.domain.request.MockDataRequest;
import com.nbsaas.boot.system.api.domain.response.MockResponse;
import com.nbsaas.boot.system.api.domain.simple.MockSimple;
import com.nbsaas.boot.system.rest.convert.MockSimpleConvert;
import com.nbsaas.boot.system.rest.convert.MockEntityConvert;
import com.nbsaas.boot.system.rest.convert.MockResponseConvert;

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
public class MockResource extends BaseResource<Mock,MockResponse, MockSimple, MockDataRequest, MockSearchRequest>  implements MockApi {

@Override
protected Class<Mock> getEntityClass() {
return Mock.class;
}

@Override
public Function<Mock, MockSimple> getConvertSimple() {
return new MockSimpleConvert();
}

@Override
public Function
<MockDataRequest, Mock> getConvertForm() {
return new MockEntityConvert();
}

@Override
public Function<Mock, MockResponse> getConvertResponse() {
return new MockResponseConvert();
}

}



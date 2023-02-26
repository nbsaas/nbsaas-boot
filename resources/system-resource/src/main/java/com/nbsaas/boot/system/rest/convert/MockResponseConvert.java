package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.Mock;
import com.nbsaas.boot.hibernate.data.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.system.api.domain.response.MockResponse;

/**
 * 实体对象转化成响应对象
 */

public class MockResponseConvert implements Converter
        <MockResponse, Mock> {
    @Override
    public MockResponse convert(Mock source) {
        MockResponse result = new MockResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}


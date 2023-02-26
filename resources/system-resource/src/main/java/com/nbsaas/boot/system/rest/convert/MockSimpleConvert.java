package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.Mock;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.system.api.domain.simple.MockSimple;

/**
 * 列表对象转换器
 */
public class MockSimpleConvert implements Converter
        <MockSimple, Mock> {

    @Override
    public MockSimple convert(Mock source) {
        MockSimple result = new MockSimple();
        result.setAddDate(source.getAddDate());
        result.setLastDate(source.getLastDate());
        result.setContent(source.getContent());
        result.setName(source.getName());

        return result;
    }
}
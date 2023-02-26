package com.nbsaas.boot.system.rest.convert;

import com.nbsaas.boot.entity.system.Sequence;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.system.api.domain.simple.SequenceSimple;

/**
 * 列表对象转换器
 */
public class SequenceSimpleConvert implements Converter
        <SequenceSimple, Sequence> {

    @Override
    public SequenceSimple convert(Sequence source) {
        SequenceSimple result = new SequenceSimple();
        result.setAddDate(source.getAddDate());
        result.setLastDate(source.getLastDate());
        result.setIncrement(source.getIncrement());
        result.setCurrentNum(source.getCurrentNum());
        result.setUpdateDate(source.getUpdateDate());
        result.setName(source.getName());
        result.setCreateDate(source.getCreateDate());

        return result;
    }
}
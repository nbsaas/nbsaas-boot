package com.nbsaas.boot.user.rest.convert;

import com.nbsaas.boot.entity.user.Structure;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.user.api.domain.simple.StructureSimple;

/**
 * 列表对象转换器
 */
public class StructureSimpleConvert implements Converter
        <StructureSimple, Structure> {

    @Override
    public StructureSimple convert(Structure source) {
        StructureSimple result = new StructureSimple();
        result.setAddDate(source.getAddDate());
        result.setLastDate(source.getLastDate());
        result.setLft(source.getLft());
        result.setRgt(source.getRgt());
        if (source.getParent() != null) {
            result.setParent(source.getParent().getId());
        }
        result.setIds(source.getIds());
        result.setLevelInfo(source.getLevelInfo());
        result.setSortNum(source.getSortNum());
        result.setName(source.getName());
        if (source.getParent() != null) {
            result.setParentName(source.getParent().getName());
        }
        result.setCode(source.getCode());

        return result;
    }
}
package com.nbsaas.boot.ad.rest.convert;

import com.nbsaas.boot.ad.api.domain.simple.AdPositionSimple;
import com.nbsaas.boot.entity.ad.AdPosition;
import com.nbsaas.boot.rest.api.Converter;

/**
 * 列表对象转换器
 */
public class AdPositionSimpleConvert implements Converter
        <AdPositionSimple, AdPosition> {

    @Override
    public AdPositionSimple convert(AdPosition source) {
        AdPositionSimple result = new AdPositionSimple();
        result.setAddDate(source.getAddDate());
        result.setLastDate(source.getLastDate());
        result.setNote(source.getNote());
        result.setKey(source.getKey());
        result.setHeight(source.getHeight());
        result.setTemplate(source.getTemplate());
        result.setSortNum(source.getSortNum());
        result.setName(source.getName());
        result.setWidth(source.getWidth());

        return result;
    }
}
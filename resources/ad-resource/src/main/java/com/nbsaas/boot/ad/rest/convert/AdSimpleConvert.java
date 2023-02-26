package com.nbsaas.boot.ad.rest.convert;

import com.nbsaas.boot.entity.ad.Ad;
import com.nbsaas.boot.ad.api.domain.simple.AdSimple;

import com.nbsaas.boot.rest.api.Converter;

/**
* 列表对象转换器
*/
public class AdSimpleConvert implements Converter
<AdSimple, Ad> {

@Override
public AdSimple convert(Ad source) {
AdSimple result = new AdSimple();
            result.setLastDate(source.getLastDate());
            result.setType(source.getType());
            result.setEndDate(source.getEndDate());
            if(source.getAdPosition()!=null){
            result.setAdPosition(source.getAdPosition().getId());
            }
            if(source.getAdPosition()!=null){
            result.setAdPositionName(source.getAdPosition().getName());
            }
            result.setAddDate(source.getAddDate());
            result.setUrl(source.getUrl());
            result.setNote(source.getNote());
            result.setBeginDate(source.getBeginDate());
            result.setTitle(source.getTitle());
            result.setBussId(source.getBussId());
            result.setCatalog(source.getCatalog());
            result.setSortNum(source.getSortNum());
            result.setPath(source.getPath());

return result;
}
}
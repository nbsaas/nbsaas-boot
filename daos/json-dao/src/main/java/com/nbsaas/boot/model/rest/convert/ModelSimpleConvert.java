package com.nbsaas.boot.model.rest.convert;

import com.nbsaas.boot.model.data.entity.Model;
import com.nbsaas.boot.model.api.domain.simple.ModelSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class ModelSimpleConvert implements Converter<ModelSimple, Model> {




@Override
public ModelSimple convert(Model source) {
    ModelSimple result = new ModelSimple();

                result.setNote(source.getNote());
                result.setName(source.getName());
                result.setId(source.getId());


    return result;
}

}
package com.nbsaas.boot.model.rest.convert;

import com.nbsaas.boot.model.data.entity.ModelField;
import com.nbsaas.boot.model.api.domain.simple.ModelFieldSimple;

import com.nbsaas.boot.rest.api.Converter;
/**
* 列表对象转换器
*/

public class ModelFieldSimpleConvert implements Converter<ModelFieldSimple, ModelField> {




@Override
public ModelFieldSimple convert(ModelField source) {
    ModelFieldSimple result = new ModelFieldSimple();

                result.setFieldName(source.getFieldName());
                result.setModelId(source.getModelId());
                result.setDbName(source.getDbName());
                result.setId(source.getId());
                result.setJavaName(source.getJavaName());
                result.setFieldType(source.getFieldType());


    return result;
}

}
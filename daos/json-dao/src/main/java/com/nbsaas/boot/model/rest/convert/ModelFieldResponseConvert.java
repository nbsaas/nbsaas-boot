package com.nbsaas.boot.model.rest.convert;

import com.nbsaas.boot.model.data.entity.ModelField;
import com.nbsaas.boot.model.api.domain.response.ModelFieldResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class ModelFieldResponseConvert  implements Converter<ModelFieldResponse,ModelField> {

    @Override
    public ModelFieldResponse convert(ModelField source) {
        ModelFieldResponse  result = new  ModelFieldResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}


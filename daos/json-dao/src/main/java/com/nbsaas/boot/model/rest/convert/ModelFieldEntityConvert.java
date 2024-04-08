package com.nbsaas.boot.model.rest.convert;

import com.nbsaas.boot.model.data.entity.ModelField;
import com.nbsaas.boot.model.api.domain.request.ModelFieldRequest;

import org.springframework.beans.BeanUtils;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class ModelFieldEntityConvert  implements Converter<ModelField, ModelFieldRequest> {

    @Override
    public ModelField convert(ModelFieldRequest source) {
        ModelField result = new ModelField();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}


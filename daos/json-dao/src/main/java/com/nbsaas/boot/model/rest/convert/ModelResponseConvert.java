package com.nbsaas.boot.model.rest.convert;

import com.nbsaas.boot.model.data.entity.Model;
import com.nbsaas.boot.model.api.domain.response.ModelResponse;

import com.nbsaas.boot.utils.BeanDataUtils;
import com.nbsaas.boot.rest.api.Converter;
/**
* 实体对象转化成响应对象
*/

public class ModelResponseConvert  implements Converter<ModelResponse,Model> {

    @Override
    public ModelResponse convert(Model source) {
        ModelResponse  result = new  ModelResponse();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }

}


package com.nbsaas.boot.model.rest.convert;

import com.nbsaas.boot.model.api.domain.request.ModelRequest;
import com.nbsaas.boot.model.data.entity.Model;
import com.nbsaas.boot.rest.api.Converter;
import com.nbsaas.boot.utils.BeanDataUtils;

/**
* 请求对象转换成实体对象
*/

public class ModelEntityConvert  implements Converter<Model, ModelRequest> {

    @Override
    public Model convert(ModelRequest source) {
        Model result = new Model();
        BeanDataUtils.copyProperties(source, result);
        return result;
    }
}


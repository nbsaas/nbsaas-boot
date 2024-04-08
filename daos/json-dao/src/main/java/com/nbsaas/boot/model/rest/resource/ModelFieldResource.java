package com.nbsaas.boot.model.rest.resource;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nbsaas.boot.model.api.apis.ModelFieldApi;
import com.nbsaas.boot.model.api.domain.request.ModelFieldRequest;
import com.nbsaas.boot.model.api.domain.response.ModelFieldResponse;
import com.nbsaas.boot.model.api.domain.simple.ModelFieldSimple;
import com.nbsaas.boot.model.data.entity.ModelField;
import com.nbsaas.boot.model.data.mapper.ModelFieldMapper;
import com.nbsaas.boot.model.rest.convert.ModelFieldEntityConvert;
import com.nbsaas.boot.model.rest.convert.ModelFieldResponseConvert;
import com.nbsaas.boot.model.rest.convert.ModelFieldSimpleConvert;
import com.nbsaas.boot.mp.core.BaseResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.function.Function;

/**
*   业务接口实现
*/
@Transactional
@Service
public class ModelFieldResource extends BaseResource<ModelField,ModelFieldResponse, ModelFieldSimple, ModelFieldRequest>  implements ModelFieldApi {

    @Resource
    private ModelFieldMapper modelFieldMapper;

    @Override
    public BaseMapper<ModelField> getMapper() {
        return modelFieldMapper;
    }

    @Override
    public Function<ModelField, ModelFieldSimple> getConvertSimple() {
        return new ModelFieldSimpleConvert();
    }

    @Override
    public Function<ModelFieldRequest, ModelField> getConvertForm() {
        return new ModelFieldEntityConvert();
    }

    @Override
    public Function<ModelField, ModelFieldResponse> getConvertResponse() {
        return new ModelFieldResponseConvert();
    }




}



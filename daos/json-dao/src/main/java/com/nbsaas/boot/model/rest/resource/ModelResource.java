package com.nbsaas.boot.model.rest.resource;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nbsaas.boot.model.api.apis.ModelApi;
import com.nbsaas.boot.model.data.entity.Model;
import com.nbsaas.boot.model.api.domain.request.ModelRequest;
import com.nbsaas.boot.model.api.domain.request.ModelSearch;
import com.nbsaas.boot.model.api.domain.response.ModelResponse;
import com.nbsaas.boot.model.api.domain.simple.ModelSimple;
import com.nbsaas.boot.model.rest.convert.ModelSimpleConvert;
import com.nbsaas.boot.model.rest.convert.ModelEntityConvert;
import com.nbsaas.boot.model.rest.convert.ModelResponseConvert;
import com.nbsaas.boot.model.data.mapper.ModelMapper;

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
public class ModelResource extends BaseResource<Model,ModelResponse, ModelSimple, ModelRequest>  implements ModelApi {

    @Resource
    private ModelMapper modelMapper;

    @Override
    public BaseMapper<Model> getMapper() {
        return modelMapper;
    }

    @Override
    public Function<Model, ModelSimple> getConvertSimple() {
        return new ModelSimpleConvert();
    }

    @Override
    public Function<ModelRequest, Model> getConvertForm() {
        return new ModelEntityConvert();
    }

    @Override
    public Function<Model, ModelResponse> getConvertResponse() {
        return new ModelResponseConvert();
    }




}



package com.nbsaas.boot.system.rest.resource;

import com.nbsaas.boot.entity.system.Sequence;
import com.nbsaas.boot.hibernate.data.core.BaseResource;
import com.nbsaas.boot.system.api.apis.SequenceApi;
import com.nbsaas.boot.system.api.domain.request.SequenceDataRequest;
import com.nbsaas.boot.system.api.domain.request.SequenceSearchRequest;
import com.nbsaas.boot.system.api.domain.response.SequenceResponse;
import com.nbsaas.boot.system.api.domain.simple.SequenceSimple;
import com.nbsaas.boot.system.rest.convert.SequenceEntityConvert;
import com.nbsaas.boot.system.rest.convert.SequenceResponseConvert;
import com.nbsaas.boot.system.rest.convert.SequenceSimpleConvert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

/**
 * 业务接口实现
 */
@Transactional
@Service
public class SequenceResource extends BaseResource<Sequence, SequenceResponse, SequenceSimple, SequenceDataRequest, SequenceSearchRequest> implements SequenceApi {

    @Override
    protected Class<Sequence> getEntityClass() {
        return Sequence.class;
    }

    @Override
    public Function<Sequence, SequenceSimple> getConvertSimple() {
        return new SequenceSimpleConvert();
    }

    @Override
    public Function
            <SequenceDataRequest, Sequence> getConvertForm() {
        return new SequenceEntityConvert();
    }

    @Override
    public Function<Sequence, SequenceResponse> getConvertResponse() {
        return new SequenceResponseConvert();
    }

}



package com.nbsaas.boot.ad.rest.resource;

import com.nbsaas.boot.ad.api.apis.AdApi;
import com.nbsaas.boot.ad.api.domain.request.AdDataRequest;
import com.nbsaas.boot.ad.api.domain.request.AdSearchRequest;
import com.nbsaas.boot.ad.api.domain.response.AdResponse;
import com.nbsaas.boot.ad.api.domain.simple.AdSimple;
import com.nbsaas.boot.ad.rest.convert.AdEntityConvert;
import com.nbsaas.boot.ad.rest.convert.AdResponseConvert;
import com.nbsaas.boot.ad.rest.convert.AdSimpleConvert;
import com.nbsaas.boot.entity.ad.Ad;
import com.nbsaas.boot.hibernate.data.core.BaseResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

/**
 * 业务接口实现
 */
@Transactional
@Service
public class AdResource extends BaseResource<Ad, AdResponse, AdSimple, AdDataRequest, AdSearchRequest> implements AdApi {

    @Override
    protected Class<Ad> getEntityClass() {
        return Ad.class;
    }

    @Override
    public Function<Ad, AdSimple> getConvertSimple() {
        return new AdSimpleConvert();
    }

    @Override
    public Function
            <AdDataRequest, Ad> getConvertForm() {
        return new AdEntityConvert();
    }

    @Override
    public Function<Ad, AdResponse> getConvertResponse() {
        return new AdResponseConvert();
    }

}



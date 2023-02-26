package com.nbsaas.boot.tenant.rest.resource;

import com.nbsaas.boot.entity.tenant.TenantDictionaryItem;
import com.nbsaas.boot.hibernate.data.core.BaseResource;
import com.nbsaas.boot.tenant.api.apis.TenantDictionaryItemApi;
import com.nbsaas.boot.tenant.api.domain.request.TenantDictionaryItemDataRequest;
import com.nbsaas.boot.tenant.api.domain.request.TenantDictionaryItemSearchRequest;
import com.nbsaas.boot.tenant.api.domain.response.TenantDictionaryItemResponse;
import com.nbsaas.boot.tenant.api.domain.simple.TenantDictionaryItemSimple;
import com.nbsaas.boot.tenant.rest.convert.TenantDictionaryItemEntityConvert;
import com.nbsaas.boot.tenant.rest.convert.TenantDictionaryItemResponseConvert;
import com.nbsaas.boot.tenant.rest.convert.TenantDictionaryItemSimpleConvert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

/**
 * 业务接口实现
 */
@Transactional
@Service
public class TenantDictionaryItemResource extends BaseResource<TenantDictionaryItem, TenantDictionaryItemResponse, TenantDictionaryItemSimple, TenantDictionaryItemDataRequest, TenantDictionaryItemSearchRequest> implements TenantDictionaryItemApi {

    @Override
    protected Class<TenantDictionaryItem> getEntityClass() {
        return TenantDictionaryItem.class;
    }

    @Override
    public Function<TenantDictionaryItem, TenantDictionaryItemSimple> getConvertSimple() {
        return new TenantDictionaryItemSimpleConvert();
    }

    @Override
    public Function
            <TenantDictionaryItemDataRequest, TenantDictionaryItem> getConvertForm() {
        return new TenantDictionaryItemEntityConvert();
    }

    @Override
    public Function<TenantDictionaryItem, TenantDictionaryItemResponse> getConvertResponse() {
        return new TenantDictionaryItemResponseConvert();
    }

}



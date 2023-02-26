package com.nbsaas.boot.trade.rest.resource;

import com.nbsaas.boot.entity.trade.TradeInfo;
import com.nbsaas.boot.hibernate.data.core.BaseResource;
import com.nbsaas.boot.trade.api.apis.TradeInfoApi;
import com.nbsaas.boot.trade.api.domain.request.TradeInfoDataRequest;
import com.nbsaas.boot.trade.api.domain.request.TradeInfoSearchRequest;
import com.nbsaas.boot.trade.api.domain.response.TradeInfoResponse;
import com.nbsaas.boot.trade.api.domain.simple.TradeInfoSimple;
import com.nbsaas.boot.trade.rest.convert.TradeInfoEntityConvert;
import com.nbsaas.boot.trade.rest.convert.TradeInfoResponseConvert;
import com.nbsaas.boot.trade.rest.convert.TradeInfoSimpleConvert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

/**
 * 业务接口实现
 */
@Transactional
@Service
public class TradeInfoResource extends BaseResource<TradeInfo, TradeInfoResponse, TradeInfoSimple, TradeInfoDataRequest, TradeInfoSearchRequest> implements TradeInfoApi {

    @Override
    protected Class<TradeInfo> getEntityClass() {
        return TradeInfo.class;
    }

    @Override
    public Function<TradeInfo, TradeInfoSimple> getConvertSimple() {
        return new TradeInfoSimpleConvert();
    }

    @Override
    public Function
            <TradeInfoDataRequest, TradeInfo> getConvertForm() {
        return new TradeInfoEntityConvert();
    }

    @Override
    public Function<TradeInfo, TradeInfoResponse> getConvertResponse() {
        return new TradeInfoResponseConvert();
    }

}



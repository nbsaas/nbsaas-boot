package com.nbsaas.boot.trade.api.domain.request;

import com.nbsaas.boot.rest.request.PageRequest;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 搜索bean
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TradeAccountSearchRequest extends PageRequest implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;

}
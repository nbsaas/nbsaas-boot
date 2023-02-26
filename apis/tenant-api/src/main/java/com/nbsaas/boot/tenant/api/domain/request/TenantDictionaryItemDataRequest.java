package com.nbsaas.boot.tenant.api.domain.request;

import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;

/**
 * 请求对象
 */
@Data
public class TenantDictionaryItemDataRequest implements Serializable, RequestId {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    private int sortNum;
    private StoreState state;
    private String name;
    private String code;
    private Long id;
}
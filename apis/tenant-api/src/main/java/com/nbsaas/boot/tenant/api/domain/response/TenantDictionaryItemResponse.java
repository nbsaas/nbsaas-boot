package com.nbsaas.boot.tenant.api.domain.response;

import com.nbsaas.boot.rest.enums.StoreState;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 响应对象
 */
@Getter
@Setter
@ToString(callSuper = true)
public class TenantDictionaryItemResponse implements Serializable {
    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;

    private int sortNum;

    private StoreState state;

    private String name;

    private String code;


}
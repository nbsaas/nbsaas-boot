package com.nbsaas.boot.tenant.api.domain.request;

import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 请求对象
 */
@Data
public class TenantDictionaryDataRequest implements Serializable, RequestId {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    private Date addDate;
    private Date lastDate;
    private String note;
    private String key;
    private Integer version;
    private String name;
    private Long id;
    private StoreState storeState;
}
package com.nbsaas.boot.tenant.api.domain.simple;

import com.nbsaas.boot.rest.enums.StoreState;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 列表对象
 */
@Data
public class TenantDictionarySimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date addDate;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date lastDate;
    private String note;
    private String key;
    private Integer version;
    private StoreState storeState;
    private String name;

}
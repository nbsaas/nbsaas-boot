package com.nbsaas.boot.tenant.api.domain.response;

import com.nbsaas.boot.rest.enums.StoreState;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 响应对象
 */
@Getter
@Setter
@ToString(callSuper = true)
public class TenantResponse implements Serializable {
    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date lastDate;

    private String logo;

    private Long domainGroup;

    private String theme;

    private StoreState storeState;

    private Double lng;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date addDate;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date expireDate;

    private String note;

    private String key;

    private Double lat;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date beginDate;

    private String phone;

    private String name;

    private String creatorName;

    private String domain;

    private Long creator;

    private String address;


}
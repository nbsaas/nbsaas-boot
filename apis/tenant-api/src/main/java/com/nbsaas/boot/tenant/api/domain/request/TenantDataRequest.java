package com.nbsaas.boot.tenant.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
            import com.nbsaas.boot.rest.enums.StoreState;
/**
* 请求对象
*/
@Data
public class TenantDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        private Date lastDate;
        private String logo;
        private Long domainGroup;
        private String theme;
        private Double lng;
        private Date addDate;
        private Date expireDate;
        private String note;
        private String key;
        private Double lat;
        private Date beginDate;
        private String phone;
        private String name;
        private Long id;
        private String domain;
        private Long creator;
        private StoreState storeState;
        private String address;
}
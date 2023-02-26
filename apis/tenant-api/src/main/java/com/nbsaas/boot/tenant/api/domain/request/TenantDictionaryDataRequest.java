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
public class TenantDictionaryDataRequest implements Serializable,RequestId {

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
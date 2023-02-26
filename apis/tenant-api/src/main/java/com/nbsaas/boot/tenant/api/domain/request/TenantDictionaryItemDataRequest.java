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
public class TenantDictionaryItemDataRequest implements Serializable,RequestId {

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
package com.nbsaas.boot.tenant.api.domain.response;

import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
            import com.nbsaas.boot.rest.enums.StoreState;
/**
* 响应对象
*/
@Getter
@Setter
@ToString(callSuper = true)
public class TenantDictionaryItemResponse  implements Serializable {
/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

        private int sortNum;

        private StoreState state;

        private String name;

        private String code;


}
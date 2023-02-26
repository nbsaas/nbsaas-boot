package com.nbsaas.boot.tenant.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
            import com.nbsaas.boot.rest.enums.StoreState;
/**
* 列表对象
*/
@Data
public class TenantDictionaryItemSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

        private int sortNum;
        private StoreState state;
        private String name;
        private String code;

}
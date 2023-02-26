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
public class TenantDictionaryResponse  implements Serializable {
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
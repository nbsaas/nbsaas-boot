package com.nbsaas.boot.tenant.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class DomainDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        private Date addDate;
        private Date lastDate;
        private String note;
        private Long id;
        private String domain;
        private Long creator;
}
package com.nbsaas.boot.system.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class ErrorLogDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        private String param;
        private Date addDate;
        private Date lastDate;
        private String url;
        private String note;
        private String name;
        private Long id;
        private String app;
        private String serverName;
}
package com.nbsaas.boot.user.api.domain.request;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
import com.nbsaas.boot.rest.request.RequestId;
/**
* 请求对象
*/
@Data
public class UserOauthConfigDataRequest implements Serializable,RequestId {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;


        private Integer state;
        private Date addDate;
        private Date lastDate;
        private String className;
        private String model;
        private String appKey;
        private String name;
        private String appSecret;
        private Long id;
}
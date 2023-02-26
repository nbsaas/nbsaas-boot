package com.nbsaas.boot.user.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
/**
* 列表对象
*/
@Data
public class UserOauthTokenSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date addDate;
            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date lastDate;
        private String token_type;
        private Long expires_in;
        private String access_token;
        private String uid;
        private Integer loginSize;
        private String refresh_token;
        private Long user;

}
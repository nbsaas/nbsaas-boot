package com.nbsaas.boot.user.api.domain.simple;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import lombok.Data;
/**
* 列表对象
*/
@Data
public class UserOauthConfigSimple implements Serializable {

/**
* 序列化参数
*/
private static final long serialVersionUID = 1L;

        private Integer state;
            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date addDate;
            //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
        private Date lastDate;
        private String className;
        private String model;
        private String appKey;
        private String name;
        private String appSecret;

}
package com.nbsaas.boot.user.api.domain.request;

import com.nbsaas.boot.enums.user.SecurityType;
import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 请求对象
 */
@Data
public class UserPasswordDataRequest implements Serializable, RequestId {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    private Date addDate;
    private Date lastDate;
    private String salt;
    private String password;
    private Long id;
    private Integer checkSize;
    private SecurityType securityType;
    private Long user;
}
package com.nbsaas.boot.user.api.domain.response;

import com.nbsaas.boot.enums.user.SecurityType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 响应对象
 */
@Getter
@Setter
@ToString(callSuper = true)
public class UserPasswordResponse implements Serializable {
    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date addDate;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date lastDate;

    private String salt;

    private String password;

    private SecurityType securityType;

    private Integer checkSize;

    private Long user;


}
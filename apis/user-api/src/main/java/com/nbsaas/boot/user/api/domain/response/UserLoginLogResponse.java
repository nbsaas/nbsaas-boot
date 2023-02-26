package com.nbsaas.boot.user.api.domain.response;

import com.nbsaas.boot.enums.user.LoginState;
import com.nbsaas.boot.rest.enums.StoreState;
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
public class UserLoginLogResponse implements Serializable {
    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;

    private String client;

    private LoginState state;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date addDate;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date lastDate;

    private String password;

    private String note;

    private String userName;

    private String ip;

    private StoreState storeState;

    private String account;

    private Long user;


}
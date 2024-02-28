package com.nbsaas.boot.rest.simple;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserSimple implements Serializable {

    /**
     * 用户id
     */
    private Long id;

    /**
     * 昵称
     */
    private String name;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 业务id
     */
    private Long businessId;
}

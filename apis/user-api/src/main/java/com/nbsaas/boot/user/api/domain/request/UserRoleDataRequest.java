package com.nbsaas.boot.user.api.domain.request;

import com.nbsaas.boot.enums.user.RoleType;
import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 请求对象
 */
@Data
public class UserRoleDataRequest implements Serializable, RequestId {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    private Date addDate;
    private Date lastDate;
    private RoleType type;
    private Integer catalog;
    private String alias;
    private String description;
    private String name;
    private Long id;
}
package com.nbsaas.boot.user.api.domain.request;

import com.nbsaas.boot.rest.enums.DataScope;
import com.nbsaas.boot.rest.enums.State;
import com.nbsaas.boot.rest.enums.StoreState;
import com.nbsaas.boot.rest.request.RequestId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 请求对象
 */
@Data
public class UserInfoDataRequest implements Serializable, RequestId {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;


    private Date lastDate;
    private DataScope dataScope;
    private State state;
    private Date addDate;
    private Integer structure;
    private String note;
    private String avatar;
    private Integer catalog;
    private String phone;
    private Integer loginSize;
    private String name;
    private Long id;
    private StoreState storeState;
}
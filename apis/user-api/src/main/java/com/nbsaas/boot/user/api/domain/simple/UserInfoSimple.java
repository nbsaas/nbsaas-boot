package com.nbsaas.boot.user.api.domain.simple;

import com.nbsaas.boot.rest.enums.DataScope;
import com.nbsaas.boot.rest.enums.State;
import com.nbsaas.boot.rest.enums.StoreState;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 列表对象
 */
@Data
public class UserInfoSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;

    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date lastDate;
    private StoreState storeState;
    private State state;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date addDate;
    private Integer structure;
    private String note;
    private DataScope dataScope;
    private String structureName;
    private String avatar;
    private Integer catalog;
    private String phone;
    private Integer loginSize;
    private String name;

}
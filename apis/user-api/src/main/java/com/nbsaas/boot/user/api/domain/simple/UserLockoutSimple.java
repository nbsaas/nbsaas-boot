package com.nbsaas.boot.user.api.domain.simple;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * description: user_lockout 账号锁定
 */
@Data
public class UserLockoutSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * beginDate
     */
    private Date beginDate;

    /**
     * endDate
     */
    private Date endDate;

    /**
     * note
     */
    private String note;

    /**
     * user_id
     */
    private Long userId;

}
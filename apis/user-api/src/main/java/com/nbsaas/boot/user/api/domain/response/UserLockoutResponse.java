package com.nbsaas.boot.user.api.domain.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * description: user_lockout 账号锁定
 */
@Getter
@Setter
@ToString(callSuper = true)
public class UserLockoutResponse implements Serializable {
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
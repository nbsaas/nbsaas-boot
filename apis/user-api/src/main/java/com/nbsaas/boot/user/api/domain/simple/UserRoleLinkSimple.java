package com.nbsaas.boot.user.api.domain.simple;

import lombok.Data;

import java.io.Serializable;

/**
 * description: user_role_link
 */
@Data
public class UserRoleLinkSimple implements Serializable {

    /**
     * 序列化参数
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * user_id 用户Id
     */
    private Long userId;

    /**
     * role_id 角色Id
     */
    private Long roleId;

}
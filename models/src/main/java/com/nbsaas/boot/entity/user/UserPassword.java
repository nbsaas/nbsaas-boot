package com.nbsaas.boot.entity.user;


import com.nbsaas.boot.enums.user.SecurityType;
import com.nbsaas.boot.hibernate.data.entity.AbstractEntity;
import com.nbsaas.codemake.annotation.FieldConvert;
import lombok.Data;

import javax.persistence.*;

/**
 * 用户密码集合
 */


@Data
@Entity
@Table(name = "user_password")
public class UserPassword extends AbstractEntity {

    @FieldConvert
    @ManyToOne(fetch = FetchType.LAZY)
    private UserInfo user;

    /**
     * 校验次数
     */
    private Integer checkSize;

    /**
     * 密码
     */
    @Column(length = 50)
    private String password;

    /**
     * 盐
     */
    @Column(length = 50)
    private String salt;

    private SecurityType securityType;

}

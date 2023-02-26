package com.nbsaas.boot.entity.user;

import com.nbsaas.boot.hibernate.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ada on 2017/7/20.
 */

@Data
@Entity
@Table(name = "user_oauth_config")
public class UserOauthConfig extends AbstractEntity {

    /**
     * 第三方登陆名称
     */
    private String name;


    private String model;


    /**
     * 程序key
     */
    private String appKey;


    /**
     * 程序密钥
     */
    private String appSecret;


    private Integer state;

    private String className;

}

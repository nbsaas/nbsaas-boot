package com.nbsaas.boot.entity.system;

import com.nbsaas.boot.hibernate.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * description: sys_application  实体类
 */
@Data
@Entity
@Table(name = "sys_app")
public class Application extends AbstractEntity {


    /**
     * name 应用名称
     */
    private String name;

    /**
     * app_key 应用key
     */
    private String appKey;

    /**
     * note 应用介绍
     */
    private String note;

}
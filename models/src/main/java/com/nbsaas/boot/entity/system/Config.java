package com.nbsaas.boot.entity.system;

import com.nbsaas.boot.hibernate.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * description: sys_config 配置 实体类
 */
@Data
@Entity
@Table(name = "sys_config")
public class Config extends AbstractEntity {


    /**
     * content json内容
     */
    private String content;

}
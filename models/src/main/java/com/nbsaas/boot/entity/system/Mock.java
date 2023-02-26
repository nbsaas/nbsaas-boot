package com.nbsaas.boot.entity.system;

import com.nbsaas.boot.hibernate.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * description: sys_mock 模拟数据 实体类
 */
@Data
@Entity
@Table(name = "sys_mock")
public class Mock extends AbstractEntity {


    /**
     * name
     */
    private String name;

    /**
     * content
     */
    private String content;

}
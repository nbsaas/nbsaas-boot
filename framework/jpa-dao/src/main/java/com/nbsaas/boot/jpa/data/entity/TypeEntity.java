package com.nbsaas.boot.jpa.data.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by ada on 2017/7/5.
 */

@Data
@MappedSuperclass
public class TypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 分类名称
     */
    private String name;


    /**
     * 排序号
     */
    private Integer sortNum;

}

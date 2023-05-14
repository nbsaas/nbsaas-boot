package com.nbsaas.boot.jpa.data.entity;

import lombok.Data;
import org.hibernate.annotations.Comment;

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

    @Comment("主键id")
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

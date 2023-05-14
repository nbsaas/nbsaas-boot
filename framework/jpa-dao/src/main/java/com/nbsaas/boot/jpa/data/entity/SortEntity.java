package com.nbsaas.boot.jpa.data.entity;

import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.MappedSuperclass;


@Data
@MappedSuperclass
public class SortEntity extends AbstractEntity {


    @Comment("排序号")
    private Integer sortNum;

}
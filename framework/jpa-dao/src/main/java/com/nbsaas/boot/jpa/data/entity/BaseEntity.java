package com.nbsaas.boot.jpa.data.entity;

import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class BaseEntity {

    @Comment("主键id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}

package com.nbsaas.boot.entity.system;

import com.nbsaas.boot.hibernate.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * description: sys_sequence 序列 实体类
 */
@Data
@Entity
@Table(name = "sys_sequence")
public class Sequence extends AbstractEntity {


    /**
     * name 序列名称
     */
    private String name;

    /**
     * increment 增长步长
     */
    private Integer increment;

    /**
     * currentNum 当前编号，默认0
     */
    private Long currentNum;

    /**
     * create_date
     */
    private Date createDate;

    /**
     * update_date
     */
    private Date updateDate;

}
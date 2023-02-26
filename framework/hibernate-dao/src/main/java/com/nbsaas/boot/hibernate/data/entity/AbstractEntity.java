package com.nbsaas.boot.hibernate.data.entity;


import com.nbsaas.boot.hibernate.data.listener.EntityListener;
import lombok.Data;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;


@EntityListeners(EntityListener.class)
@Data
@MappedSuperclass
public abstract class AbstractEntity extends LongEntity implements Serializable {


    /**
     * 添加时间
     */
    private Date addDate;

    /**
     * 最新修改时间
     */
    private Date lastDate;


}
